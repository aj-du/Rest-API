package ajdu_restful_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ajdu_restful_api.model.Schedule;
import ajdu_restful_api.model.Task;
import ajdu_restful_api.service.ScheduleService;
import ajdu_restful_api.service.TaskService;

@RestController
public class TaskRestController {
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	ScheduleService scheduleService;
		
	@RequestMapping(value="/tasks",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Task>> getAllTask() {
			return new ResponseEntity<List<Task>>(taskService.findAll(),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/tasks/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Task> getTask(@PathVariable int id) {
		if(taskService.findTask(id) != null)
			return new ResponseEntity<Task>(taskService.findTask(id),HttpStatus.OK);
		else return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value="/tasks/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Task> deleteTask(@PathVariable int id) {
		if(taskService.findTask(id) != null) {
			taskService.deleteTask(id);
			return new ResponseEntity<Task>(HttpStatus.OK);
		}
		else return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/tasks/{id}",method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Task> updateTask(@PathVariable int id, @RequestBody Task task) {
		Task t = taskService.findTask(id);
		if(t != null) {
			t.setName(task.getName());
			t.setDescription(task.getDescription());
			t.setDueDate(task.getDueDate());
			t.setStatus(task.getStatus());
			return new ResponseEntity<Task>(t, HttpStatus.OK);
		}
		else return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/tasks/{id}/schedule",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Schedule> getTaskSchedule(@PathVariable int id){
		Task t = taskService.findTask(id);
		if(t != null && t.getSchedule() != null) 
			return new ResponseEntity<Schedule>(t.getSchedule(),HttpStatus.OK);
		else return new ResponseEntity<Schedule>(HttpStatus.NOT_FOUND);
		
	}
}
