package ajdu_restful_api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Image {

	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	private String fileURL;
	
	@ManyToOne
	@JoinColumn(name="service_id")
	private Service service;
	
	@OneToOne
	@JoinColumn(name="blog_id")
	private Blog blog;
	
	@OneToOne
	@JoinColumn(name="post_id")
	private Post post;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;

	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Image(String title, String fileURL, Service service, Blog blog,
			Post post, User user) {
		super();
		this.title = title;
		this.fileURL = fileURL;
		this.service = service;
		this.blog = blog;
		this.post = post;
		this.user = user;
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

	public String getFile() {
		return fileURL;
	}

	public void setFile(String fileURL) {
		this.fileURL = fileURL;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}


	public String getFileURL() {
		return fileURL;
	}


	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
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


	@Override
	public String toString() {
		return "Image [id=" + id + ", title=" + title + ", fileURL=" + fileURL
				+ ", service=" + service + ", blog=" + blog + ", post=" + post
				+ ", user=" + user + "]";
	}
	
	
}


