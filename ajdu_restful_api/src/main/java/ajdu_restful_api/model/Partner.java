package ajdu_restful_api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Partner extends Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;

	public Partner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Partner(String firstName, String lastName, Gender gender, User user) {
		super(firstName, lastName, gender);
		this.user = user;
	}

	public Partner(User user) {
		super();
		this.user = user;
	}
	
	
}
