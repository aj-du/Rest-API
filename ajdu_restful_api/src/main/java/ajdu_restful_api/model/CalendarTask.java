package ajdu_restful_api.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ajdu_restful_api.config.GlobalProperties;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class CalendarTask extends GenericTask {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern=GlobalProperties.DATETIME_PATTERN, timezone="CET")
	private Calendar start;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern=GlobalProperties.DATETIME_PATTERN, timezone="CET")
	private Calendar end;
	
	@Column(columnDefinition="boolean default false")
	private boolean allDay;
	
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


	public Calendar getEnd() {
		return end;
	}


	public void setEnd(Calendar end) {
		this.end = end;
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


	public Calendar getStart() {
		return start;
	}


	public void setStart(Calendar start) {
		this.start = start;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}
	
	


	public boolean isAllDay() {
		return allDay;
	}


	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}


	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + ", description="
				+ ", end=" + end + ", schedule="
				+ schedule + ", status=" + status + super.toString() + "]";
	}
	
	
	
}
