package ajdu_restful_api.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Service {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String description;
	private BigDecimal cost;
	@Column(columnDefinition="boolean default false")
	private boolean isDistinct;
	
	@ManyToOne
	@JoinColumn(name="organization_id")
	private Organization organization;
	
	@OneToMany(mappedBy="service")
	private List<Movie> movie;
	
	@OneToMany(mappedBy="service")
	private List<Image> image;
	
	@ManyToMany
	@JoinTable(
				name="service_category",
				joinColumns={@JoinColumn(name="service_id")},
				inverseJoinColumns={@JoinColumn(name="category_id")}
				)
	private List<Category> category;
	
	@OneToMany(mappedBy="service")
	private List<Opinion> opinions;
	
	@ManyToMany
	@JoinTable(	name="package_service",
				joinColumns={@JoinColumn(name="service_id")},
				inverseJoinColumns={@JoinColumn(name="package_id")}	)
	private List<Package> packages;
	

	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Service(String name, String description, BigDecimal cost,
			boolean isDistinct, Organization organization, List<Movie> movie,
			List<Image> image, List<Category> category, List<Opinion> opinions) {
		super();
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.isDistinct = isDistinct;
		this.organization = organization;
		this.movie = movie;
		this.image = image;
		this.category = category;
		this.opinions = opinions;
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public BigDecimal getCost() {
		return cost;
	}


	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}


	public boolean isDistinct() {
		return isDistinct;
	}


	public void setDistinct(boolean isDistinct) {
		this.isDistinct = isDistinct;
	}


	public Organization getOrganization() {
		return organization;
	}


	public void setOrganization(Organization organization) {
		this.organization = organization;
	}


	public List<Movie> getMovie() {
		return movie;
	}


	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}


	public List<Image> getImage() {
		return image;
	}


	public void setImage(List<Image> image) {
		this.image = image;
	}


	public List<Category> getCategory() {
		return category;
	}


	public void setCategory(List<Category> category) {
		this.category = category;
	}


	public List<Opinion> getOpinions() {
		return opinions;
	}


	public void setOpinions(List<Opinion> opinions) {
		this.opinions = opinions;
	}

	
	public List<Package> getPackages() {
		return packages;
	}


	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}



	@Override
	public String toString() {
		return "Service [id=" + id + ", name=" + name + ", description="
				+ description + ", cost=" + cost + ", isDistinct=" + isDistinct
				+ ", organization=" + organization + ", movie=" + movie
				+ ", image=" + image + ", category=" + category + ", opinions="
				+ opinions + "]";
	}

	
	
	
}
