package ajdu_restful_api.model;

import java.util.Date;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Event {

	private String place;
	private Date date;
	private int numberOfGuests;
	

	public Event() {
		super();
	}

	public Event(String place, Date date, int numberOfGuests) {
		super();
		this.place = place;
		this.date = date;
		this.numberOfGuests = numberOfGuests;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	@Override
	public String toString() {
		return "Event [place=" + place + ", date=" + date + ", numberOfGuests="
				+ numberOfGuests + "]";
	}
	
	
}
