package com.hillsballetschool.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.google.common.base.Preconditions;
import com.hillsballetschool.field.Field;

@Entity
@Table(name="level")
@NamedQueries({
	@NamedQuery(name = Level.GET, query = "SELECT l FROM Level l order by l.name")
})
public class Level {

	public static final String GET = "getLevel";
	
	public enum Fields implements Field {

		ID("id", 50),
		NAME("name", 50);

		private final String name;
		private final int length;
		
		Fields(String name, int length) {
			this.name = Preconditions.checkNotNull(name);
			this.length = length;
		}
		
		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public int getLength() {
			return length;
		}
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;

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
}
