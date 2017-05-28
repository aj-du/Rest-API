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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ajdu_restful_api.model.CalendarTask;
import ajdu_restful_api.model.Schedule;
import ajdu_restful_api.model.User;
import ajdu_restful_api.service.CalendarTaskService;
import ajdu_restful_api.service.ScheduleService;
import ajdu_restful_api.service.UserService;

@RestController
public class CalendarTaskRestController {
	
	@Autowired
	CalendarTaskService taskService;
	
	@Autowired
	ScheduleService scheduleService;
	@Autowired
	UserService userService;
		
	@RequestMapping(value="/tasks",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<CalendarTask>> getAllTask() {
			return new ResponseEntity<List<CalendarTask>>(taskService.findAll(),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/tasks/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CalendarTask> getTask(@PathVariable int id) {
		if(taskService.findTask(id) != null)
			return new ResponseEntity<CalendarTask>(taskService.findTask(id),HttpStatus.OK);
		else return new ResponseEntity<CalendarTask>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value="/tasks/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<CalendarTask> deleteTask(@PathVariable int id) {
		if(taskService.findTask(id) != null) {
			taskService.deleteTask(id);
			return new ResponseEntity<CalendarTask>(HttpStatus.NO_CONTENT);
		}
		else return new ResponseEntity<CalendarTask>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/tasks/by/user",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<CalendarTask>> getTasksByUser(@RequestParam int userid) {
		User user = userService.findUser(userid);
		if(user != null) 
			return new ResponseEntity<List<CalendarTask>>(taskService.findTaskBySchedule(user.getSchedule()), HttpStatus.OK);
		else
			return new ResponseEntity<List<CalendarTask>>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/tasks/{id}",method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CalendarTask> updateTask(@PathVariable int id, @RequestBody CalendarTask task) {
		CalendarTask t = taskService.findTask(id);
		if(t != null) {
			t.setName(task.getName());
			t.setDescription(task.getDescription());
			t.setDueDate(task.getDueDate());
			t.setStatus(task.getStatus());
			taskService.saveTask(t);
			return new ResponseEntity<CalendarTask>(t, HttpStatus.OK);
		}
		else return new ResponseEntity<CalendarTask>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/tasks/{id}/schedule",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Schedule> getTaskSchedule(@PathVariable int id){
		CalendarTask t = taskService.findTask(id);
		if(t != null && t.getSchedule() != null) 
			return new ResponseEntity<Schedule>(t.getSchedule(),HttpStatus.OK);
		else return new ResponseEntity<Schedule>(HttpStatus.NOT_FOUND);		
	}
	
	
	
}
