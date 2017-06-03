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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	@JsonIgnoreProperties({
		"login", "password", 
		"active", "dateCreated",
		"address","services",
		"categories"
		})
	private Organization organization;
	
	@OneToMany(mappedBy="service")
	@JsonIgnoreProperties({
		"blog","post","user","service"
	})
	private List<Media> media;
	
	@ManyToMany
	@JoinTable(
				name="service_category",
				joinColumns={@JoinColumn(name="service_id")},
				inverseJoinColumns={@JoinColumn(name="category_id")}
				)
	private List<Category> categories;
	
	@OneToMany(mappedBy="service")
	@JsonIgnoreProperties({
		"service"
	})
	private List<Opinion> opinions;
	
	@ManyToMany
	@JoinTable(	name="package_service",
				joinColumns={@JoinColumn(name="service_id")},
				inverseJoinColumns={@JoinColumn(name="package_id")}	)
	/*@JsonIgnoreProperties({"user", "totalCost","services", "dateCreated"})*/
	@JsonIgnore
	private List<Package> packages;
	

	public Service() {
		super();
	}


	public Service(String name, String description, BigDecimal cost,
			boolean isDistinct, Organization organization, List<Media> media,
			List<Category> categories, List<Opinion> opinions) {
		super();
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.isDistinct = isDistinct;
		this.organization = organization;
		this.media = media;
		this.categories = categories;
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


	public List<Media> getMedia() {
		return media;
	}


	public void setMedia(List<Media> media) {
		this.media = media;
	}


	public List<Category> getCategories() {
		return categories;
	}


	public void setCategories(List<Category> categories) {
		this.categories = categories;
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
				+ ", organization=" + organization + ", media=" + media
				+ ", categories=" + categories + ", opinions=" + opinions
				+ ", packages=" + packages + "]";
	}
	
	
	
}
