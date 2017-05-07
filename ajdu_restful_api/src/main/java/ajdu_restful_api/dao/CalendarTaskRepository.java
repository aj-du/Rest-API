package ajdu_restful_api.dao;

import org.springframework.data.repository.CrudRepository;

import ajdu_restful_api.model.CalendarTask;

public interface CalendarTaskRepository extends CrudRepository<CalendarTask, Integer>{

}
