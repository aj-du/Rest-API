package ajdu_restful_api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TaskStatus {

	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToMany(mappedBy="status")
	private List<Task> tasks;
	
	public TaskStatus(){}

	public TaskStatus(List<Task> tasks) {
		super();
		this.tasks = tasks;
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

	@Override
	public String toString() {
		return "TaskStatus [id=" + id + ", tasks=" + tasks + "]";
	}
	
	
}
