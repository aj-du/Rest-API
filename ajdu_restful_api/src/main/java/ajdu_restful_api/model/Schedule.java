package ajdu_restful_api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Schedule {

	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToMany(mappedBy="schedule")
	private List<Task> tasks;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	
	
}
