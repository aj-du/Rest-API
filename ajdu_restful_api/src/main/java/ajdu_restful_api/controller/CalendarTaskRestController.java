package ajdu_restful_api.controller;

import java.util.ArrayList;
import java.util.List;

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

import ajdu_restful_api.model.CalendarTask;
import ajdu_restful_api.model.Schedule;
import ajdu_restful_api.model.TaskStatus;
import ajdu_restful_api.model.User;
import ajdu_restful_api.service.CalendarTaskService;
import ajdu_restful_api.service.ScheduleService;
import ajdu_restful_api.service.UserService;

@RestController
public class CalendarTaskRestController extends AuthenticatedRestController {
	
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
	
	@RequestMapping(value="/tasks",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CalendarTask> saveNewTask(@RequestBody CalendarTask task, Authentication auth) {
		if(task.getStart() != null && 
				task.getTitle() != null && 
				task.getSchedule() !=null && 
				task.getSchedule().getId() != null) {
			Schedule s = scheduleService.findSchedule(task.getSchedule().getId());		
			if(s != null) {				
				if(hasPermission(auth, s.getUser().getLogin())) {
					if(task.getStatus() == null) task.setStatus(TaskStatus.TODO); 
					
					if(s.getTasks() != null) s.getTasks().add(task);
					else {
						List<CalendarTask> tasks = new ArrayList<CalendarTask>();
						tasks.add(task);
						s.setTasks(tasks);
					}
					
					taskService.saveTask(task);
					scheduleService.save(s);
					
					return new ResponseEntity<CalendarTask>(task, HttpStatus.CREATED);
				} else return new ResponseEntity<CalendarTask>(HttpStatus.FORBIDDEN);
			} else return new ResponseEntity<CalendarTask>(HttpStatus.NOT_FOUND);
		} else return new ResponseEntity<CalendarTask>(HttpStatus.BAD_REQUEST);
	}
	
	
	@RequestMapping(value="/tasks/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CalendarTask> getTask(@PathVariable int id, Authentication auth) {
		CalendarTask task = taskService.findTask(id);
		if(task != null)
			if(hasPermission(auth, task.getSchedule().getUser().getLogin())) {
				return new ResponseEntity<CalendarTask>(taskService.findTask(id),HttpStatus.OK);
			} else return new ResponseEntity<CalendarTask>(HttpStatus.FORBIDDEN);
		else return new ResponseEntity<CalendarTask>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value="/tasks/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<CalendarTask> deleteTask(@PathVariable int id, Authentication auth) {
		CalendarTask task = taskService.findTask(id);
		if(task != null) {
			if(hasPermission(auth, task.getSchedule().getUser().getLogin())) {
				taskService.deleteTask(id);
				return new ResponseEntity<CalendarTask>(HttpStatus.NO_CONTENT);
			} else return new ResponseEntity<CalendarTask>(HttpStatus.FORBIDDEN);
		}
		else return new ResponseEntity<CalendarTask>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/tasks/by/user",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<CalendarTask>> getTasksByUser(@RequestParam int userid, Authentication auth) {
		User user = userService.findUser(userid);
		if(user != null) 
			if(hasPermission(auth, user.getLogin())) {
				return new ResponseEntity<List<CalendarTask>>(taskService.findTaskBySchedule(user.getSchedule()), HttpStatus.OK);
			} else return new ResponseEntity<List<CalendarTask>>(HttpStatus.FORBIDDEN);
		else
			return new ResponseEntity<List<CalendarTask>>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/tasks/{id}",method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CalendarTask> updateTask(@PathVariable int id, @RequestBody CalendarTask task, Authentication auth) {
		CalendarTask t = taskService.findTask(id);
		if(t != null) {
			if(hasPermission(auth, t.getSchedule().getUser().getLogin())) {
				t.setTitle(task.getTitle());
				t.setDescription(task.getDescription());
				t.setStart(task.getStart());
				t.setEnd(task.getEnd());
				t.setStatus(task.getStatus());
				taskService.saveTask(t);
				return new ResponseEntity<CalendarTask>(t, HttpStatus.OK);
			} else return new ResponseEntity<CalendarTask>(HttpStatus.FORBIDDEN);
		}
		else return new ResponseEntity<CalendarTask>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/tasks/{id}/schedule",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Schedule> getTaskSchedule(@PathVariable int id, Authentication auth){
		CalendarTask t = taskService.findTask(id);
		if(t != null && t.getSchedule() != null) 
			if(hasPermission(auth, t.getSchedule().getUser().getLogin())) {
				return new ResponseEntity<Schedule>(t.getSchedule(),HttpStatus.OK);
			} else return new ResponseEntity<Schedule>(HttpStatus.FORBIDDEN);
		else return new ResponseEntity<Schedule>(HttpStatus.NOT_FOUND);		
	}
	
	
	
}
