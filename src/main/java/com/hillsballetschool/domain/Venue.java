package com.hillsballetschool.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.hillsballetschool.field.Field;

@Entity
@Table(name="venue")
@NamedQueries({
	@NamedQuery(name = Venue.GET, query = "SELECT v FROM Venue v order by v.name")
})
@SuppressWarnings("serial")
public class Venue implements Serializable {

	public static final String GET = "getVenue";
	
	public interface Fields {
		static Field ID = new Field("id", 50); 
		static Field NAME = new Field("name", 50);
		static Field PHONE = new Field("phone", 50);
		static Field ADDRESS1 = new Field("address1", 50);
		static Field ADDRESS2 = new Field("address2", 50);
		static Field POSTCODE = new Field("postcode", 4);
		static Field[] VALUES = new Field[] {ID, NAME, PHONE, ADDRESS1, ADDRESS2, POSTCODE};
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String phone;
	private String address1;
	private String address2;
	private String postcode;

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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAddress1() {
		return address1;
	}
	
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	public String getAddress2() {
		return address2;
	}
	
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	public String getPostcode() {
		return postcode;
	}
	
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venue other = (Venue) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
