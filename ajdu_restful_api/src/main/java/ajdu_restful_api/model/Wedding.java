package ajdu_restful_api.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Wedding extends Event {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@OneToOne(mappedBy="wedding")
	private User user;

	public Wedding() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wedding(String place, Date date, int numberOfGuests, User user) {
		super(place, date, numberOfGuests);
		this.user = user;
	}
	
	
	
}
