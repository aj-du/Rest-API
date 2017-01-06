package ajdu_restful_api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Movie {

	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	private String fileURL;
	
	@ManyToOne
	@JoinColumn(name="service_id")
	private Service service;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(String title, String fileURL, Service service) {
		super();
		this.title = title;
		this.fileURL = fileURL;
		this.service = service;
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

	public void setFile(String file) {
		this.fileURL = file;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", file=" + fileURL
				+ ", service=" + service + "]";
	}
	
	
	
}


