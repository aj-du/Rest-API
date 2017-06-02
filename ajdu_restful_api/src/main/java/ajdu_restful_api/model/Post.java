package ajdu_restful_api.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ajdu_restful_api.config.GlobalProperties;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	@Column(columnDefinition="LONGTEXT")
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="timestamp default CURRENT_TIMESTAMP")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern=GlobalProperties.DATETIME_PATTERN)
	private Date dateCreated;
	
	@ManyToOne
	@JoinColumn(name="blog_id")
	@JsonIgnoreProperties({
		"title", "description",
		"dateCreated", "user",
		"posts", "media"
	})
	private Blog blog;
	
	@OneToOne(mappedBy="post")
	private Media media;
	
	@OneToMany(mappedBy="post")
	@JsonIgnoreProperties({"post", "user"})
	private List<Comment> comments;
	
	public Post(){}


	public Post(String title, String content, Date dateCreated, Blog blog,
			Media media, List<Comment> comments) {
		super();
		this.title = title;
		this.content = content;
		this.dateCreated = dateCreated;
		this.blog = blog;
		this.media = media;
		this.comments = comments;
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
	
	

	public Media getMedia() {
		return media;
	}


	public void setMedia(Media media) {
		this.media = media;
	}


	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content
				+ ", dateCreated=" + dateCreated + ", blog=" + blog
				+ ", media=" + media + ", comments=" + comments + "]";
	}	
	
}
