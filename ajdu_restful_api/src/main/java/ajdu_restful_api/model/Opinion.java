package ajdu_restful_api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import ajdu_restful_api.config.GlobalProperties;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Opinion {

	@Id
	@GeneratedValue
	private Integer id;
	@Min(value=1)
	@Max(value=5)
	private int rate;
	private String content;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="timestamp default CURRENT_TIMESTAMP")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern=GlobalProperties.DATETIME_PATTERN)
	private Date dateCreated;
	
	@ManyToOne
	@JoinColumn(name="service_id")
	@JsonIgnoreProperties({
		"organization", "description",
		"cost", "distinct",
		"movie", "image",
		"categories", "opinions",
		"packages"
		})
	private Service service;
	
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

	public Opinion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Opinion(int rate, String content, Date dateCreated, Service service,
			User user) {
		super();
		this.rate = rate;
		this.content = content;
		this.dateCreated = dateCreated;
		this.service = service;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Opinion [id=" + id + ", rate=" + rate + ", content=" + content
				+ ", dateCreated=" + dateCreated + ", service=" + service
				+ ", user=" + user + "]";
	}
	
	
}
