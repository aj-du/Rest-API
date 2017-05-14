
package ajdu_restful_api.service;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ajdu_restful_api.dao.TodoTaskRepository;
import ajdu_restful_api.model.TodoTask;
import ajdu_restful_api.model.User;

@Service
@Transactional
public class TodoTaskService {

	private final TodoTaskRepository taskRepository;
	

	public TodoTaskService(TodoTaskRepository taskRepository) {
		super();
		this.taskRepository = taskRepository;
	}
	
	public TodoTask findTask(int id) {
		return taskRepository.findOne(id);
	}
	
	public List<TodoTask> findAll(){
		return (List<TodoTask>)taskRepository.findAll();
	}
	
	public List<TodoTask> findAllTasksOfUser(User user) {
		return (List<TodoTask>) taskRepository.findTodoTasksByUser(user);
	}
	
	public List<TodoTask> findAllTasksByUserDefined(boolean userDefined) {
		return (List<TodoTask>) taskRepository.findTodoTasksByIsUserDefined(userDefined);
	}
	
	
	public void saveTask(TodoTask task) {
		taskRepository.save(task);
	}
	
	public void deleteTask(int id) {
		taskRepository.delete(id);
	}
	
}
