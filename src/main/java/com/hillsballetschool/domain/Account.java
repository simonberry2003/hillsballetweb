package com.hillsballetschool.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.google.common.base.Objects;

@Entity
@Table(name="account")
@NamedQueries({
	@NamedQuery(name = Account.GET, query = "SELECT a FROM Account a order by a.surname, a.givenName"),
	@NamedQuery(name = Account.COUNT, query="select count(a) from Account a")  
})
public class Account {

	public static final String GET = "get";
	public static final String COUNT = "count";
	
	public interface Fields {
		public static final String ID = "id";
		public static final String GIVEN_NAME = "givenName";
		public static final String SURNAME = "surname";
		public static final String EMAIL_ADDRESS = "emailAddress";
		public static final String PHONE = "phone";
		public static final String ADDRESS1 = "address1";
		public static final String ADDRESS2 = "address2";
		public static final String POSTCODE = "postcode";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String givenName;
	private String surname;
	private String emailAddress;
	private String phone;
	private String address1;
	private String address2;
	private String postcode;

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
			.add(Fields.ID, id)
			.add(Fields.GIVEN_NAME, givenName)
			.add(Fields.SURNAME, surname)
			.add(Fields.EMAIL_ADDRESS, emailAddress)
			.add(Fields.PHONE, phone)
			.add(Fields.ADDRESS1, address1)
			.add(Fields.ADDRESS2, address2)
			.add(Fields.POSTCODE, postcode)
			.toString();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getGivenName() {
		return givenName;
	}
	
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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
