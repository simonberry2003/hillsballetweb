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
@Table(name="venue")
@NamedQueries({
	@NamedQuery(name = Venue.GET, query = "SELECT v FROM Venue v order by v.name")
})
public class Venue {

	public static final String GET = "getVenue";
	
	public enum Fields implements Field {

		ID("id", 50),
		NAME("name", 50),
		PHONE("phone", 50),
		ADDRESS1("address1", 50),
		ADDRESS2("address2", 50),
		POSTCODE("postcode", 4);

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
	private String phone;
	private String address1;
	private String address2;
	private String postcode;

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
}
