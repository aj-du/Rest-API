package ajdu_restful_api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class TodoTask extends GenericTask {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(columnDefinition="boolean default false")
	private boolean isUserDefined;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonIgnoreProperties({
		"pack", "firstName", 
		"lastName", "password",
		"email","roles",
		"blog","schedule",
		"opinions","comments",
		"dateCreated", "gender",
		"mainUsers", "permittedUsers",
		"profileImage", "active", "partner",
		"marriage", "wedding", "todoTasks"
		})
	private User user;	
	
	
	public TodoTask(){}
	

	public TodoTask(String name, String desc, boolean isUserDefined) {
		super(name, desc, TaskStatus.TODO);
		this.isUserDefined = isUserDefined;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isUserDefined() {
		return isUserDefined;
	}

	public void setUserDefined(boolean isUserDefined) {
		this.isUserDefined = isUserDefined;
	}
	

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "TodoTask [id=" + id + ", isUserDefined=" + isUserDefined + super.toString() +"]";
	}
	
	
	
}
