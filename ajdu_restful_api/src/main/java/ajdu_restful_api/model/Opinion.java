package ajdu_restful_api.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Opinion {

	@Id
	@GeneratedValue
	private Integer id;
	private int rate;
	private String content;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	
	@ManyToOne
	@JoinColumn(name="service_id")
	private Service service;
	
	@ManyToOne
	@JoinColumn(name="user_id")
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
