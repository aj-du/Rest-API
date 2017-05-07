package ajdu_restful_api.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class GenericTask {

	private String name;
	private String description;
	@Enumerated(EnumType.STRING)
	private TaskStatus status;
	
	public GenericTask(){}
	
	public GenericTask(String name, String description, TaskStatus status) {
		super();
		this.name = name;
		this.description = description;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "GenericTask [name=" + name + ", description=" + description
				+ ", status=" + status + "]";
	}
	
}
