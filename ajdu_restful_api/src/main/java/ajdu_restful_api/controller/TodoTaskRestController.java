package ajdu_restful_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ajdu_restful_api.model.TaskStatus;
import ajdu_restful_api.model.TodoTask;
import ajdu_restful_api.model.User;
import ajdu_restful_api.service.TodoTaskService;
import ajdu_restful_api.service.UserService;

@RestController
public class TodoTaskRestController {
	
	@Autowired
	TodoTaskService taskService;
	@Autowired
	UserService userService;
	
		
	@RequestMapping(value="/todos",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<TodoTask>> getAllTask(@RequestParam Optional<Boolean> userDefined) {
			if(!userDefined.isPresent())
				return new ResponseEntity<List<TodoTask>>(taskService.findAll(),HttpStatus.OK);
			else 
				return new ResponseEntity<List<TodoTask>>(taskService
						.findAllTasksByUserDefined(userDefined.get()),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/todos",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<TodoTask>> saveNewTask(@RequestBody TodoTask todo) {
		Integer userId = todo.getUser().getId();
		if(userId != null && userService.findUser(userId.intValue()) != null) {
			User user = userService.findUser(userId.intValue());
			if(todo.getStatus()!= null) 
				todo.setStatus(TaskStatus.TODO);
			todo.setUserDefined(true);
			user.getTodoTasks().add(todo);
			userService.save(user);
			taskService.saveTask(todo);
		} else return new ResponseEntity<List<TodoTask>>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<TodoTask>>(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value="/todos/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<TodoTask> getTask(@PathVariable int id) {
		if(taskService.findTask(id) != null)
			return new ResponseEntity<TodoTask>(taskService.findTask(id),HttpStatus.OK);
		else return new ResponseEntity<TodoTask>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value="/todos/by/user",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<TodoTask>> getTaskByUser(@RequestParam int userid) {
		User user = userService.findUser(userid);
		if(user != null) 
			return new ResponseEntity<List<TodoTask>>(user.getTodoTasks(), HttpStatus.OK);
		else
			return new ResponseEntity<List<TodoTask>>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value="/todos/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<TodoTask> deleteTask(@PathVariable int id) {
		TodoTask tdt = taskService.findTask(id);
		if(tdt != null) {
			if(tdt.isUserDefined()) {
				taskService.deleteTask(id);
				return new ResponseEntity<TodoTask>(HttpStatus.NO_CONTENT);
			} else return new ResponseEntity<TodoTask>(HttpStatus.UNAUTHORIZED);
		}
		else return new ResponseEntity<TodoTask>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/todos/{id}",method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<TodoTask> updateTask(@PathVariable int id, @RequestBody TodoTask task) {
		TodoTask t = taskService.findTask(id);
		if(t != null) {
			if(t.isUserDefined()) {
				t.setTitle(task.getTitle());
				t.setDescription(task.getDescription());
				t.setStatus(task.getStatus());
				taskService.saveTask(t);
				return new ResponseEntity<TodoTask>(t, HttpStatus.OK);
			}
			else return new ResponseEntity<TodoTask>(HttpStatus.UNAUTHORIZED);
		}
		else return new ResponseEntity<TodoTask>(HttpStatus.NOT_FOUND);
	}
	
}
