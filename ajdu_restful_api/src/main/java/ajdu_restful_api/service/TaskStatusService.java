package ajdu_restful_api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ajdu_restful_api.dao.TaskStatusRepository;
import ajdu_restful_api.model.TaskStatus;

@Transactional
@Service
public class TaskStatusService {
	
	private final TaskStatusRepository tsRepo;

	public TaskStatusService(TaskStatusRepository tsRepo) {
		super();
		this.tsRepo = tsRepo;
	}
	
	public TaskStatus findTask(int id) {
		return tsRepo.findOne(id);
	}
	
	public TaskStatus findTaskStatusByName(String name) {
		return tsRepo.findTaskStatusByName(name.toUpperCase());
	}
	
	public List<TaskStatus> findAll(){
		return (List<TaskStatus>)tsRepo.findAll();
	}
	
	public void saveTask(TaskStatus ts) {
		tsRepo.save(ts);
	}
	
	public void deleteTaskStatus(int id) {
		tsRepo.delete(id);
	}
}
