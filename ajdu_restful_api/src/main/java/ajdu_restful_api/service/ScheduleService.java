package ajdu_restful_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ajdu_restful_api.dao.ScheduleRepository;
import ajdu_restful_api.model.Schedule;
import ajdu_restful_api.model.User;

@Transactional
@Service
public class ScheduleService {
	
	private final ScheduleRepository scheduleRepository;
	
	@Autowired
	private UserService userService;
	
	public ScheduleService(ScheduleRepository scheduleRepository) {
		super();
		this.scheduleRepository = scheduleRepository;
	}
	
	public List<Schedule> findSchedules(){
		List<Schedule> schedules = new ArrayList<Schedule>();
		for(Schedule s: scheduleRepository.findAll())
			schedules.add(s);
		return schedules;
	}
	
	public Schedule findSchedule(int id){
		return scheduleRepository.findOne(id);
	}
	
	public Schedule findScheduleByUser(int id){
		User user = userService.findUser(id);
		return scheduleRepository.findScheduleByUser(user);
	}
	
	public void save(Schedule schedule) {
		scheduleRepository.save(schedule);
	}
	
	public void delete(int id) {
		scheduleRepository.delete(id);
	}
	
}
