package ajdu_restful_api.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Schedule {

	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToMany(mappedBy="schedule", cascade=CascadeType.REMOVE)
	private List<CalendarTask> tasks;
	
	@OneToOne
	@JoinColumn(name="user_id")
	@JsonIgnoreProperties({
		"pack", "firstName", 
		"lastName", "password",
		"email","roles",
		"blog","schedule",
		"opinions","comments",
		"dateCreated", "profileImage",
		"mainUsers", "permittedUsers",
		"partner", "profileImage", "active",
		"gender"
		})
	private User user;

	
	public Schedule(){
		this.tasks = new ArrayList<CalendarTask>();
	};
	public Schedule(List<CalendarTask> tasks, User user) {
		super();
		this.tasks = tasks;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<CalendarTask> getTasks() {
		return tasks;
	}

	public void setTasks(List<CalendarTask> tasks) {
		this.tasks = tasks;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
