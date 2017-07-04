package ajdu_restful_api.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ajdu_restful_api.config.GlobalProperties;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@JsonIgnoreProperties({"services"})
public class Organization {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	private String login;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	private String email;
	private String phoneNumber;
	
	@Column(columnDefinition="boolean default false")
	private boolean active;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="timestamp default CURRENT_TIMESTAMP")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern=GlobalProperties.DATETIME_PATTERN)
	private Date dateCreated;
	
	@OneToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="address_id")
	private Address address;
		
	@ManyToMany
	@JoinTable(
				name="organization_category",
				joinColumns={@JoinColumn(name="organization_id")},
				inverseJoinColumns={@JoinColumn(name="category_id")}
				)
	private List<Category> categories;

	@OneToMany(mappedBy="organization", cascade=CascadeType.REMOVE)
	@JsonIgnoreProperties({"organization"})
	private List<Service> services;
	
	public Organization() {}

	public Organization(String name, String login, String password,
			String email, boolean active, Date dateCreated, Address address,
			List<Category> categories) {
		super();
		this.name = name;
		this.login = login;
		this.password = password;
		this.email = email;
		this.active = active;
		this.dateCreated = dateCreated;
		this.address = address;
		/*this.categories = categories;*/
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + ", login=" + login
				+ ", password=" + password + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", active=" + active
				+ ", dateCreated=" + dateCreated + ", address=" + address
				+ /*", categories=" + categories+*/ ", services=" + services + "]";
	}


	
	

}
