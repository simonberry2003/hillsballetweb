package com.hillsballetschool.domain;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.hillsballetschool.field.Field;

@Entity
@Table(name="class")
@NamedQueries({
	@NamedQuery(name = Classs.GET, query = "SELECT c FROM Classs c order by c.start")
})
@SuppressWarnings("serial")
public class Classs implements Serializable {

	public static final String GET = "getClasss";

	public interface Fields {
		static Field ID = new Field("id", 50); 
		static Field DAY = new Field("day", 50);
		static Field VENUE = new Field("venueName");
		static Field VENUE2 = new Field("venue");
		static Field LEVEL = new Field("levelName");
		static Field START = new Field("start");
		static Field END = new Field("end");
		static Field[] VALUES = new Field[] {ID, DAY, VENUE, LEVEL, START, END};
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private Day day;
	
	@OneToOne
	@JoinColumn(name="venueId")
	private Venue venue;

	@OneToOne
	@JoinColumn(name="levelId")
	private Level level;

	//@Temporal(TemporalType.TIME)
	private Time start;
	
	//@Temporal(TemporalType.TIME)
	private Time end;

	@Override
	public String toString() {
		return EntityToStringHelper.toString(this, Fields.VALUES);
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public Time getStart() {
		return start;
	}

	public void setStart(Time start) {
		this.start = start;
	}

	public Time getEnd() {
		return end;
	}

	public void setEnd(Time end) {
		this.end = end;
	}
	
	public String getVenueName() {
		return venue.getName();
	}

	public String getLevelName() {
		return level.getName();
	}
}
