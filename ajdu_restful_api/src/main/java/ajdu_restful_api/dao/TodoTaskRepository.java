package ajdu_restful_api.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ajdu_restful_api.model.TodoTask;
import ajdu_restful_api.model.User;

public interface TodoTaskRepository extends CrudRepository<TodoTask, Integer>{
	public List<TodoTask> findTodoTasksByUser(User user);
	public List<TodoTask> findTodoTasksByIsUserDefined(boolean userDefined);
}
