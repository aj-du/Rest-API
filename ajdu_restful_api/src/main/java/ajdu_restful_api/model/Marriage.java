package ajdu_restful_api.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Marriage extends Event {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private MarriageType marriageType;
	
	@OneToOne(mappedBy="marriage")
	private User user;

	public Marriage() {
		super();
	}

	public Marriage(String place, Date date, int numberOfGuests, User user, MarriageType marriageType) {
		super(place, date, numberOfGuests);
		this.user = user;
		this.marriageType = marriageType;
	}
	
	
}
