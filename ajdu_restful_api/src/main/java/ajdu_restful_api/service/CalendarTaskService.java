
package ajdu_restful_api.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import ajdu_restful_api.dao.CalendarTaskRepository;
import ajdu_restful_api.model.CalendarTask;
import ajdu_restful_api.model.Schedule;

@Service
@Transactional
public class CalendarTaskService {

	private final CalendarTaskRepository taskRepository;
	
	@Autowired
	private ScheduleService scheduleService;
	
	public CalendarTaskService(CalendarTaskRepository taskRepository) {
		super();
		this.taskRepository = taskRepository;
	}
	
	public CalendarTask findTask(int id) {
		return taskRepository.findOne(id);
	}
	
	public List<CalendarTask> findTaskBySchedule(Schedule schedule) {
		return (List<CalendarTask>) taskRepository.findTasksBySchedule(schedule);
	}
	
	public List<CalendarTask> findAll(){
		return (List<CalendarTask>)taskRepository.findAll();
	}
	
	public List<CalendarTask> findAllTaskBySchedule(@RequestParam int scheduleID){
		return scheduleService.findSchedule(scheduleID).getTasks();
	}
	
	public void saveTask(CalendarTask task) {
		taskRepository.save(task);
	}
	
	public void deleteTask(int id) {
		taskRepository.delete(id);
	}
	
}
