package ajdu_restful_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ajdu_restful_api.model.Schedule;
import ajdu_restful_api.model.User;
import ajdu_restful_api.service.ScheduleService;
import ajdu_restful_api.service.UserService;

@RestController
public class ScheduleRestController {

	@Autowired
	ScheduleService scheduleService;
	@Autowired
	UserService userService;
	
	@GetMapping("/schedule")
	public Schedule findSchedule(@RequestParam int id) {
		return scheduleService.findSchedule(id);
	}
	
	@GetMapping("/allschedules")
	public List<Schedule> findAllSchedules() {
		return scheduleService.findSchedules();
	}
	
	@GetMapping("/saveschedule")
	public ResponseEntity<Schedule> saveSchedule(@RequestParam int userid) {
		Schedule s = new Schedule();
		User u = userService.findUser(userid);
			if(u != null && u.getSchedule()==null) {
				s.setUser(u);
				scheduleService.save(s);
				return new ResponseEntity<Schedule>(s,HttpStatus.CREATED);
			} else {
				return new ResponseEntity<Schedule>(HttpStatus.UNPROCESSABLE_ENTITY);
			}
	}
	
	@GetMapping("/deleteschedule")
	public String deleteSchedule(@RequestParam int id){
		scheduleService.delete(id);
		return "Schedule with id "+id+" has been removed.";
	}
	
	
}
