package ajdu_restful_api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	
	@ManyToMany
	@JoinTable(
			name="service_category",
			joinColumns={@JoinColumn(name="category_id")},
			inverseJoinColumns={@JoinColumn(name="service_id")}
			)
	private List<Service> services;
	
	public Category(){};
	public Category(String name) {
		super();
		this.name = name;
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
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
}
