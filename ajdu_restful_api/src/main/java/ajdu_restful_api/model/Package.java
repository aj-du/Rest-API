package ajdu_restful_api.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Package {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private BigDecimal totalCost;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToMany
	@JoinTable(	name="package_service",
				joinColumns={@JoinColumn(name="package_id")},
				inverseJoinColumns={@JoinColumn(name="service_id")}	)
	private List<Service> services;
	
	
	public Package(){
		this.totalCost = BigDecimal.ZERO;
	}


	public Package(String name, BigDecimal totalCost, Date dateCreated,
			User user, List<Service> services) {
		super();
		this.name = name;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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
		return "Package [id=" + id + ", name=" + name + ", totalCost="
				+ totalCost + ", dateCreated=" + dateCreated + ", user=" + user
				+ ", services=" + services + "]";
	}
	
	
	
}
