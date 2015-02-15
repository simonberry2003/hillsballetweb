package com.hillsballetschool.domain;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Classs extends AbstractEntity {

	public static final String GET = "getClasss";
	public static final String CLASS_ID = "class_id";

	public interface Fields {
		static Field ID = new Field("id", 50); 
		static Field DAY = new Field("day", 50);
		static Field VENUE = new Field("venue");
		static Field LEVEL = new Field("level");
		static Field START = new Field("start");
		static Field END = new Field("end");
		static Field[] VALUES = new Field[] {ID, DAY, VENUE, LEVEL, START, END};
	}

	@Enumerated(EnumType.STRING)
	private Day day;
	
	@OneToOne
	@JoinColumn(name="venueId")
	private Venue venue;

	@OneToOne
	@JoinColumn(name="levelId")
	private Level level;

	private Time start;
	private Time end;

	@Override
	public String toString() {
		return day + "-" + venue + "-" + level + "-" + start;
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
}
