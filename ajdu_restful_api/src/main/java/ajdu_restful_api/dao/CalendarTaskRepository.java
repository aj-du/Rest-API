package ajdu_restful_api.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ajdu_restful_api.model.CalendarTask;
import ajdu_restful_api.model.Schedule;

public interface CalendarTaskRepository extends CrudRepository<CalendarTask, Integer>{
	public List<CalendarTask> findTasksBySchedule(Schedule schedule);
}
