package com.hillsballetschool.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.hillsballetschool.field.Field;

@Entity
@Table(name="level")
@NamedQueries({
	@NamedQuery(name = Level.GET, query = "SELECT l FROM Level l order by l.name")
})
@SuppressWarnings("serial")
public class Level extends AbstractEntity {

	public static final String GET = "getLevel";
	public static final String LEVEL_ID = "levelId";

	public interface Fields {
		static Field ID = new Field("id", 50); 
		static Field NAME = new Field("name", 50);
		static Field[] VALUES = new Field[] {Fields.ID, Fields.NAME};
	}

	private String name;

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
}
