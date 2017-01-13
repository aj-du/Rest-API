package ajdu_restful_api.dao;

import org.springframework.data.repository.CrudRepository;

import ajdu_restful_api.model.TaskStatus;

public interface TaskStatusRepository extends CrudRepository<TaskStatus, Integer>{

}
