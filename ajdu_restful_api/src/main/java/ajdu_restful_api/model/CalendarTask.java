package ajdu_restful_api.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class CalendarTask extends GenericTask {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	private Calendar date;
	
	@Temporal(TemporalType.DATE)
	private Calendar dueDate;
	
	private String location;
	
	@JsonIgnoreProperties({
		"tasks", "user"
	})
	@ManyToOne
	@JoinColumn(name="schedule_id")
	private Schedule schedule;
	
	@Enumerated(EnumType.STRING)
	private TaskStatus status;
	
	
	public CalendarTask() {}


	public CalendarTask(String name, String desc, Schedule schedule) {
		super(name, desc, TaskStatus.TODO);
		this.schedule = schedule;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Calendar getDueDate() {
		return dueDate;
	}


	public void setDueDate(Calendar dueDate) {
		this.dueDate = dueDate;
	}


	public Schedule getSchedule() {
		return schedule;
	}


	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}


	public TaskStatus getStatus() {
		return status;
	}


	public void setStatus(TaskStatus status) {
		this.status = status;
	}


	public Calendar getDate() {
		return date;
	}


	public void setDate(Calendar date) {
		this.date = date;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + ", description="
				+ ", dueDate=" + dueDate + ", schedule="
				+ schedule + ", status=" + status + super.toString() + "]";
	}
	
	
	
}
