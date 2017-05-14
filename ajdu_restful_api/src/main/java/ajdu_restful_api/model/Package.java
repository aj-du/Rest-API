package ajdu_restful_api.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Package {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Formula(value = "(select sum(s.cost) from service s where s.organization_id = id)")
	private BigDecimal totalCost;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="timestamp default CURRENT_TIMESTAMP")
	private Date dateCreated;
	
	@OneToOne
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
	
	@ManyToMany
	@JoinTable(	name="package_service",
				joinColumns={@JoinColumn(name="package_id")},
				inverseJoinColumns={@JoinColumn(name="service_id")}	)
	@JsonIgnoreProperties({
		"organization", "description", "movie", "image", "categories", 
		"opinions", "distinct"
	})
	private List<Service> services;
	
	
	public Package(){
		this.totalCost = BigDecimal.ZERO;
	}


	public Package(BigDecimal totalCost, Date dateCreated,
			User user, List<Service> services) {
		super();
		this.totalCost = totalCost;
		this.dateCreated = dateCreated;
		this.user = user;
		this.services = services;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	
	public BigDecimal getTotalCost() {
		return totalCost;
	}


	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}


	public Date getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public List<Service> getServices() {
		return services;
	}


	public void setServices(List<Service> services) {
		this.services = services;
	}
	
	


	@Override
	public String toString() {
		return "Package [id=" + id + ", totalCost="
				+ totalCost + ", dateCreated=" + dateCreated + ", user=" + user
				+ ", services=" + services + "]";
	}
	
	
	
}
