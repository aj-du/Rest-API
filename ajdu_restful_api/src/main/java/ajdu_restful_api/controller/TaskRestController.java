package ajdu_restful_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ajdu_restful_api.model.Task;
import ajdu_restful_api.service.ScheduleService;
import ajdu_restful_api.service.TaskService;

@RestController
public class TaskRestController {
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	ScheduleService scheduleService;
	
	@GetMapping("/task")
	public Task findTask(@RequestParam int id) {
		return taskService.findTask(id);
	}
	
	@GetMapping("/alltasks")
	public List<Task> findAll(@RequestParam int scheduleID){
		return taskService.findAllTaskBySchedule(scheduleID);
	}
	
	@GetMapping("/savetask")
	public ResponseEntity<Task> saveTask(@RequestParam String name, @RequestParam int scheduleId) {
		Task t = new Task(name, scheduleService.findSchedule(scheduleId));
		taskService.saveTask(t);
		return new ResponseEntity<Task>(t,HttpStatus.CREATED);
	}
	
	@GetMapping("/deletetask")
	public String deleteTask(@RequestParam int id){
		taskService.deleteTask(id);
		return "Task with id "+id+" has been removed.";
	}
}
