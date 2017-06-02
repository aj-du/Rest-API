package ajdu_restful_api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ajdu_restful_api.config.GlobalProperties;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Media {
	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	private String fileURL;
	@Enumerated(EnumType.STRING)
	private MediaType mediaType;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="timestamp default CURRENT_TIMESTAMP")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern=GlobalProperties.DATETIME_PATTERN)
	private Date dateAdded;
	
	@OneToOne
	@JoinColumn(name="blog_id")
	@JsonIgnoreProperties({
		"title", "description",
		"dateCreated", "user",
		"posts", "media"
	})
	Blog blog;
	
	@OneToOne
	@JoinColumn(name="post_id")
	@JsonIgnoreProperties({
		"blog","coments", "media", 
		"dateCreated", "content", "comments"
	})
	private Post post;
	
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
	
	@ManyToOne
	@JoinColumn(name="service_id")
	@JsonIgnoreProperties({
		"organization", "description",
		"cost", "distinct",
		"movie", "image",
		"categories", "opinions",
		"packages", "name"
		})
	private Service service;
	
	public Media() {
		super();
	}

	
	public Media(String title, String fileURL, MediaType mediaType,
			Date dateAdded) {
		super();
		this.title = title;
		this.fileURL = fileURL;
		this.mediaType = mediaType;
		this.dateAdded = dateAdded;
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

	public String getFileURL() {
		return fileURL;
	}

	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public MediaType getMediaType() {
		return mediaType;
	}


	public void setMediaType(MediaType mediaType) {
		this.mediaType = mediaType;
	}


	public Blog getBlog() {
		return blog;
	}


	public void setBlog(Blog blog) {
		this.blog = blog;
	}


	public Post getPost() {
		return post;
	}


	public void setPost(Post post) {
		this.post = post;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Service getService() {
		return service;
	}


	public void setService(Service service) {
		this.service = service;
	}


	@Override
	public String toString() {
		return "Media [id=" + id + ", title=" + title + ", fileURL=" + fileURL
				+ ", mediaType=" + mediaType + ", dateAdded=" + dateAdded + "]";
	}
	
	
}
