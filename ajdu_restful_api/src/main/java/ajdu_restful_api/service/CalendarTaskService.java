package ajdu_restful_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import ajdu_restful_api.dao.TaskRepository;
import ajdu_restful_api.model.Task;

@Service
@Transactional
public class TaskService {

	private final TaskRepository taskRepository;
	
	@Autowired
	private ScheduleService scheduleService;
	
	public TaskService(TaskRepository taskRepository) {
		super();
		this.taskRepository = taskRepository;
	}
	
	public Task findTask(int id) {
		return taskRepository.findOne(id);
	}
	
	public List<Task> findAll(){
		return (List<Task>)taskRepository.findAll();
	}
	
	public List<Task> findAllTaskBySchedule(@RequestParam int scheduleID){
		return scheduleService.findSchedule(scheduleID).getTasks();
	}
	
	public void saveTask(Task task) {
		taskRepository.save(task);
	}
	
	public void deleteTask(int id) {
		taskRepository.delete(id);
	}
	
}
