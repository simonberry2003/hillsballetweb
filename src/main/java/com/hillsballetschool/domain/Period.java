package com.hillsballetschool.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.hillsballetschool.field.Field;

@Entity
@Table(name="period")
@NamedQueries({
	@NamedQuery(name = Period.GET, query = "SELECT p FROM Period p order by p.start")
})
@SuppressWarnings("serial")
public class Period extends AbstractEntity implements Comparable<Period> {

	public static final String GET = "getPeriod";
	public static final String PERIOD_ID = "period_id";
	
	public interface Fields {
		static Field ID = new Field("id", 50); 
		static Field NAME = new Field("name", 50);
		static Field START = new Field("start");
		static Field END = new Field("end");
		static Field[] VALUES = new Field[] {ID, NAME, START, END};
	}

	private String name;
	
	@Temporal(TemporalType.DATE)
	private Date start;
	
	@Temporal(TemporalType.DATE)
	private Date end;

	@Override
	public String toString() {
		return name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	@Override
	public int compareTo(Period o) {
		return start.compareTo(o.start);
	}
}
