package ajdu_restful_api.dao;

import org.springframework.data.repository.CrudRepository;

import ajdu_restful_api.model.Schedule;
import ajdu_restful_api.model.User;

public interface ScheduleRepository extends CrudRepository<Schedule, Integer>{

	public Schedule findScheduleByUser(User user);
}
