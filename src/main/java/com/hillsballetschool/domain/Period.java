package com.hillsballetschool.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.common.base.Preconditions;
import com.hillsballetschool.field.Field;

@Entity
@Table(name="period")
@NamedQueries({
	@NamedQuery(name = Period.GET, query = "SELECT p FROM Period p order by p.start")
})
@SuppressWarnings("serial")
public class Period implements Serializable {

	public static final String GET = "getPeriod";
	
	public enum Fields implements Field {

		ID("id", 50),
		NAME("name", 50),
		START("start"),
		END("end");

		private final String name;
		private final Integer length;
		
		Fields(String name, Integer length) {
			this.name = Preconditions.checkNotNull(name);
			this.length = length;
		}
		
		Fields(String name) {
			this(name, null);
		}

		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public Integer getLength() {
			return length;
		}
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	@Temporal(TemporalType.DATE)
	private Date start;
	
	@Temporal(TemporalType.DATE)
	private Date end;

	@Override
	public String toString() {
		return EntityToStringHelper.toString(this, Fields.values());
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
}
