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

@Entity
public class Schedule {

	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToMany(mappedBy="schedule", cascade=CascadeType.REMOVE)
	private List<Task> tasks;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;

	
	public Schedule(){
		this.tasks = new ArrayList<Task>();
	};
	public Schedule(List<Task> tasks, User user) {
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

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
