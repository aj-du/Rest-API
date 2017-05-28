package ajdu_restful_api.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Blog {

	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	@Column(columnDefinition="LONGTEXT")
	private String description;
	
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
	
	@OneToMany(mappedBy="blog")
	@JsonIgnoreProperties({"blog","coments", "image", "dateCreated", "content", "comments"})
	private List<Post> posts;
	
	@OneToOne(mappedBy="blog")
	private Image image;
	
	public Blog(){}

	public Blog(String title, String description, Date dateCreated, User user,
			List<Post> posts, Image image) {
		super();
		this.title = title;
		this.description = description;
		this.dateCreated = dateCreated;
		this.user = user;
		this.posts = posts;
		this.image = image;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", description="
				+ description + ", dateCreated=" + dateCreated + ", user="
				+ user + ", posts=" + posts + ", image=" + image + "]";
	}


	
	
}
