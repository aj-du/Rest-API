package ajdu_restful_api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;	
	
	@Column(unique=true)
	private String roleName;
	
	@ManyToMany
	@JoinTable(name = "user_role",
				joinColumns={@JoinColumn(name="role_id")},
				inverseJoinColumns={@JoinColumn(name="user_id")})
	private List<User> users;
	
	
	public Role() {}
	public Role(String rn) {
		this.roleName=rn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + "]";
	}

	
	
}
