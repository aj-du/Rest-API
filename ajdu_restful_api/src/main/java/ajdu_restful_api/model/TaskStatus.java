package ajdu_restful_api.model;

import java.util.ArrayList;
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
	
	private String name;
	
	@OneToMany(mappedBy="status")
	private List<Task> tasks;
	
	public TaskStatus(){
		this.tasks = new ArrayList<Task>();
	}

	public TaskStatus(String name, List<Task> tasks) {
		super();
		this.name = name;
		this.tasks = tasks;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "TaskStatus [id=" + id + ", name=" + name + ", tasks=" + tasks
				+ "]";
	}

	
	
}
