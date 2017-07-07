package ajdu_restful_api.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class GenericTask {

	private String title;
	private String description;
	@Enumerated(EnumType.STRING)
	private TaskStatus status;
	
	public GenericTask(){}
	
	public GenericTask(String title, String description, TaskStatus status) {
		super();
		this.title = title;
		this.description = description;
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
		return "GenericTask [title=" + title + ", description=" + description
				+ ", status=" + status + "]";
	}
	
}
