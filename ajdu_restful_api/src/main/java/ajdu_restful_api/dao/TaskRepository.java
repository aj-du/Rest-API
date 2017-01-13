package ajdu_restful_api.dao;

import org.springframework.data.repository.CrudRepository;

import ajdu_restful_api.model.Task;

public interface TaskRepository extends CrudRepository<Task, Integer>{

}
