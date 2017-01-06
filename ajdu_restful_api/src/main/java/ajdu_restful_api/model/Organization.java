package ajdu_restful_api.model;

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
public class Organization {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	private String login;
	private String password;
	private String email;
	private boolean active;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	
	@OneToOne
	@JoinColumn(name="address_id")
	private Address address;
	
	@ManyToMany
	@JoinTable(name="organization_category",
				joinColumns={@JoinColumn(name="organization_id")},
				inverseJoinColumns={@JoinColumn(name="category_id")})
	private List<Category> categories;

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
		this.categories = categories;
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

	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + ", login=" + login
				+ ", password=" + password + ", email=" + email + ", active="
				+ active + ", dateCreated=" + dateCreated + ", address="
				+ address + ", categories=" + categories + "]";
	}
	
	

}