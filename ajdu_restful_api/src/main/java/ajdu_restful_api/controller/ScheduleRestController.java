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
import ajdu_restful_api.model.User;
import ajdu_restful_api.service.ScheduleService;
import ajdu_restful_api.service.TaskService;
import ajdu_restful_api.service.UserService;

@RestController
public class ScheduleRestController {

	@Autowired
	ScheduleService scheduleService;
	@Autowired
	UserService userService;
	@Autowired
	TaskService taskService;
	
	
	@RequestMapping(value="/schedules",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Schedule>> getAllSchedules() {
		return new ResponseEntity<List<Schedule>>(scheduleService.findSchedules(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/schedules",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Schedule> addSchedule(@RequestBody Schedule schedule) {
		User u = userService.findUser(schedule.getUser().getId());
		schedule.setUser(u);
		if(u != null && u.getSchedule() == null) {
			scheduleService.save(schedule);
			return new ResponseEntity<Schedule>(schedule,HttpStatus.CREATED);
		} 
		else if (u == null) return new ResponseEntity<Schedule>(HttpStatus.NOT_FOUND);
		else return new ResponseEntity<Schedule>(HttpStatus.CONFLICT);
		
	}
	
	@RequestMapping(value="/schedules/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Schedule> deleteSchedule(@PathVariable int id) {
		Schedule s = scheduleService.findSchedule(id);
		if(s != null) {
			scheduleService.delete(id);
			return new ResponseEntity<Schedule>(HttpStatus.OK);
		}
		return new ResponseEntity<Schedule>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/schedule/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Schedule> getSchedule(@PathVariable int id) {
		if(scheduleService.findSchedule(id) != null)
			return new ResponseEntity<Schedule>(scheduleService.findSchedule(id),HttpStatus.OK);
		else return new ResponseEntity<Schedule>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/schedules/{id}",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<Schedule> deleteSchedule(@PathVariable int id, @RequestBody Schedule schedule) {
		Schedule s = scheduleService.findSchedule(id);
		if(s != null) {
			s.setUser(schedule.getUser());
			s.setTasks(schedule.getTasks());
			return new ResponseEntity<Schedule>(s, HttpStatus.OK);
		}
		return new ResponseEntity<Schedule>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/schedules/{id}/tasks",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Task>> findAllTasksBySchedule(@PathVariable int id){
		if(scheduleService.findSchedule(id) != null) 
			return new ResponseEntity<List<Task>>(taskService.findAllTaskBySchedule(id), HttpStatus.OK);
		else 
			return new ResponseEntity<List<Task>>(HttpStatus.NOT_FOUND);
	}
	
	
}
