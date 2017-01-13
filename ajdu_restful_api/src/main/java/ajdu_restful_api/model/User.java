package ajdu_restful_api.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private String email;
	
	@ManyToMany
	@JoinTable(name="user_role",
				joinColumns={@JoinColumn(name="user_id")},
				inverseJoinColumns={@JoinColumn(name="role_id")})
	private List<Role> roles;
	
	@OneToOne(mappedBy="user")
	private Package pack;

	@OneToOne(mappedBy="user")
	private Blog blog;
	
	@OneToOne(mappedBy="user")
	private Schedule schedule;
	

	@Column(columnDefinition="boolean default false")
	private boolean active;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="datetime default CURRENT_TIMESTAMP")
	private Date dateCreated;
	
	@OneToMany(mappedBy="user")
	private List<Opinion> opinions;
	
	@OneToMany(mappedBy="user")
	private List<Comment> comments;
	
	public User() {}

	public User(String firstName, String lastName, String login,
			String password, String email, Date dateCreated) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.email = email;
		this.dateCreated = dateCreated;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
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

	public List<Opinion> getOpinions() {
		return opinions;
	}

	public void setOpinions(List<Opinion> opinions) {
		this.opinions = opinions;
	}
	

	public Package getPack() {
		return pack;
	}

	public void setPack(Package pack) {
		this.pack = pack;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", login=" + login + ", password=" + password
				+ ", email=" + email + ", roles=" + roles + ", active="
				+ active + ", dateCreated=" + dateCreated + ", opinions="
				+ opinions + "]";
	}
	
	

}
