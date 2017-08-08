package ajdu_restful_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
public class TodoTaskRestController extends AuthenticatedRestController {
	
	@Autowired
	TodoTaskService taskService;
	@Autowired
	UserService userService;
	
		
	@RequestMapping(value="/todos",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<TodoTask>> getAllTask(@RequestParam Optional<Boolean> userDefined, Authentication auth) {
		
			if(!userDefined.isPresent()) {
				if(isAdmin(auth))
					return new ResponseEntity<List<TodoTask>>(taskService.findAll(),HttpStatus.OK);
				else return new ResponseEntity<List<TodoTask>>(HttpStatus.FORBIDDEN);
			}
			else {
				if(userDefined.get().equals(true) && isAdmin(auth)) {
					return new ResponseEntity<List<TodoTask>>(taskService
							.findAllTasksByUserDefined(userDefined.get()),HttpStatus.OK);
				}
				else if(userDefined.get().equals(false))
					return new ResponseEntity<List<TodoTask>>(taskService
							.findAllTasksByUserDefined(userDefined.get()),HttpStatus.OK);
				else return new ResponseEntity<List<TodoTask>>(HttpStatus.FORBIDDEN);
			}
			
				
	}
	
	
	@RequestMapping(value="/todos",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<TodoTask> saveNewTask(@RequestBody TodoTask todo, Authentication auth) {
		
		if(auth.getName() != null && todo.getTitle() != null) {
			User user = userService.findUserByLogin(auth.getName());
			if(user != null) {
				if(hasPermission(auth, user.getLogin())) {
					
					if(todo.getStatus()== null) 
						todo.setStatus(TaskStatus.TODO);
					if(isAdmin(auth) && todo.isUserDefined() != null) {
						taskService.saveTask(todo);
					} else {
						todo.setUserDefined(true);
						todo.setUser(user);
						user.getTodoTasks().add(todo);
						userService.save(user);
						taskService.saveTask(todo);
					}
					
				} else return new ResponseEntity<TodoTask>(HttpStatus.FORBIDDEN);
			} else return new ResponseEntity<TodoTask>(HttpStatus.NOT_FOUND);
		} else return new ResponseEntity<TodoTask>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<TodoTask>(todo, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value="/todos/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<TodoTask> getTask(@PathVariable int id, Authentication auth) {
		TodoTask task = taskService.findTask(id);
		if(task != null)
			if(!task.isUserDefined() || hasPermission(auth, task.getUser().getLogin())) {
				return new ResponseEntity<TodoTask>(taskService.findTask(id),HttpStatus.OK);				
			} else return new ResponseEntity<TodoTask>(HttpStatus.FORBIDDEN);
		else return new ResponseEntity<TodoTask>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value="/todos/by/user",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<TodoTask>> getTaskByUser(@RequestParam int userid, Authentication auth) {
		User user = userService.findUser(userid);
		if(user != null) 
			if(hasPermission(auth, user.getLogin())) {
				return new ResponseEntity<List<TodoTask>>(user.getTodoTasks(), HttpStatus.OK);
			}else return new ResponseEntity<List<TodoTask>>(HttpStatus.FORBIDDEN);
		else
			return new ResponseEntity<List<TodoTask>>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value="/todos/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<TodoTask> deleteTask(@PathVariable int id, Authentication auth) {
		TodoTask tdt = taskService.findTask(id);
		if(tdt != null) {
			if((tdt.isUserDefined() && hasPermission(auth, tdt.getUser().getLogin())) ||
					!tdt.isUserDefined() && isAdmin(auth)) {
				taskService.deleteTask(id);
				return new ResponseEntity<TodoTask>(HttpStatus.NO_CONTENT);
			} else return new ResponseEntity<TodoTask>(HttpStatus.FORBIDDEN);
		}
		else return new ResponseEntity<TodoTask>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/todos/{id}",method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<TodoTask> updateTask(@PathVariable int id, @RequestBody TodoTask task, Authentication auth) {
		TodoTask t = taskService.findTask(id);
		if(t != null) {
			if((t.isUserDefined() && hasPermission(auth, t.getUser().getLogin())) ||
					!t.isUserDefined() && isAdmin(auth)) {
				t.setStatus(task.getStatus());
				taskService.saveTask(t);
				return new ResponseEntity<TodoTask>(t, HttpStatus.OK);
			}
			else return new ResponseEntity<TodoTask>(HttpStatus.FORBIDDEN);
		}
		else return new ResponseEntity<TodoTask>(HttpStatus.NOT_FOUND);
	}
	
}
