package ajdu_restful_api.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

import ajdu_restful_api.config.GlobalProperties;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
public class User extends Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
		
	@ManyToMany
	@JoinTable(	name="main_user_permitted_user",
		joinColumns={@JoinColumn(name="permitted_user_id")},
		inverseJoinColumns={@JoinColumn(name="main_user_id")}	
	)
	@JsonIgnoreProperties({
		"mainUser", "login","password",
		"email","partner","roles",
		"schedule","profileImage","blog",
		"pack","dateCreated","opinions",
		"comments", "active", "gender", 
		"permittedUsers", "mainUsers","marriage",
		"wedding"
	})
	private List<User> mainUsers;
	
	@ManyToMany
	@JoinTable(	name="main_user_permitted_user",
		joinColumns={@JoinColumn(name="main_user_id")},
		inverseJoinColumns={@JoinColumn(name="permitted_user_id")}	
	)
	@JsonIgnoreProperties({
		"mainUser", "login","password",
		"email","partner","roles",
		"schedule","profileImage","blog",
		"pack","dateCreated","opinions",
		"comments", "active", "gender",
		"permittedUsers", "mainUsers", "marriage",
		"wedding"
	})
	private List<User> permittedUsers = new ArrayList<User>();
	
	private String login;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	private String email;

	@OneToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="partner_id")
	@JsonIgnoreProperties({"user"})
	private Partner partner;
	
	@ElementCollection(targetClass=Role.class)
	@Enumerated(EnumType.STRING)
	@CollectionTable(name="user_role")
	@Column(name="role")
	private List<Role> roles;
	
	@JsonIgnoreProperties({"user"})
	@OneToOne(mappedBy="user", cascade=CascadeType.REMOVE)
	private Package pack;

	@JsonIgnoreProperties({
		"user", "title", "description",
		"dateCreated", "posts", "image"
	})
	@OneToOne(mappedBy="user")
	private Blog blog;
	
	@JsonIgnoreProperties({"user", "tasks"})
	@OneToOne(mappedBy="user", cascade=CascadeType.REMOVE)
	private Schedule schedule;
	
	@OneToOne(mappedBy="user", cascade=CascadeType.REMOVE)
	@JsonIgnoreProperties({
		"blog","post","user","service"
	})
	private Media profileImage;	

	@Column(columnDefinition="boolean default false")
	private boolean active;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="timestamp default CURRENT_TIMESTAMP")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern=GlobalProperties.DATETIME_PATTERN)
	private Date dateCreated;
	
	@OneToMany(mappedBy="user")
	@JsonIgnoreProperties({
		"rate","content",
		"dateCreated", "service",
		"user"
	})
	private List<Opinion> opinions;
	
	@OneToMany(mappedBy="user")
	@JsonIgnoreProperties({
		"content", "dateCreated", "post", "user"
	})
	private List<Comment> comments;
	
	@JsonIgnoreProperties({"user"})
	@OneToMany(mappedBy="user")
	private List<TodoTask> todoTasks;
	
	@JsonIgnoreProperties({"user"})
	@OneToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="marriage_id")
	private Marriage marriage;
	
	@JsonIgnoreProperties({"user"})
	@OneToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="wedding_id")
	private Wedding wedding;

	
	
	public User() {}

	public User(String firstName, String lastName, Gender gender, String login,
			String password, String email, Date dateCreated) {
		super(firstName,lastName, gender);
		this.login = login;
		this.password = password;
		this.email = email;
		this.dateCreated = dateCreated;
		this.roles = new ArrayList<Role>();
	}

	public User(String firstName, String lastName, String login,
			String password, String email, Gender gender, Partner partner,
			List<Role> roles, Package pack, Blog blog, Schedule schedule,
			Media profileImage, boolean active, Date dateCreated,
			List<Opinion> opinions, List<Comment> comments) {
		super(firstName,lastName,gender);
		this.login = login;
		this.password = password;
		this.email = email;
		this.partner = partner;
		this.roles = roles;
		this.pack = pack;
		this.blog = blog;
		this.schedule = schedule;
		this.profileImage = profileImage;
		this.active = active;
		this.dateCreated = dateCreated;
		this.opinions = opinions;
		this.comments = comments;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	

	public Media getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(Media profileImage) {
		this.profileImage = profileImage;
	}
	

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}


	public List<User> getMainUsers() {
		return mainUsers;
	}

	public void setMainUser(List<User> mainUsers) {
		this.mainUsers = mainUsers;
	}

	public List<User> getPermittedUsers() {
		return permittedUsers;
	}

	public void setPermittedUsers(List<User> permittedUsers) {
		this.permittedUsers = permittedUsers;
	}

	public Marriage getMarriage() {
		return marriage;
	}

	public void setMarriage(Marriage marriage) {
		this.marriage = marriage;
	}

	public Wedding getWedding() {
		return wedding;
	}

	public void setWedding(Wedding wedding) {
		this.wedding = wedding;
	}

	public void setMainUsers(List<User> mainUsers) {
		this.mainUsers = mainUsers;
	}
	

	public List<TodoTask> getTodoTasks() {
		return todoTasks;
	}

	public void setTodoTasks(List<TodoTask> todoTasks) {
		this.todoTasks = todoTasks;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password
				+ ", email=" + email + ", partner=" + partner + ", roles="
				+ roles + ", pack=" + pack + ", blog=" + blog + ", schedule="
				+ schedule + ", profileImage=" + profileImage + ", active="
				+ active + ", dateCreated=" + dateCreated + ", opinions="
				+ opinions + ", comments=" + comments + "]";
	}
	



	
	

}
