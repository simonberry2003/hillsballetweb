package com.hillsballetschool.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.hillsballetschool.field.Field;

@Entity
@Table(name="account")
@NamedQueries({
	@NamedQuery(name = Account.GET, query = "SELECT a FROM Account a order by a.surname, a.givenName")
})
@SuppressWarnings("serial")
public class Account extends AbstractEntity {

	public static final String GET = "getAccount";
	public static final String ACCOUNT_ID = "accountId";

	public interface Fields {
		static Field ID = new Field("id", 50); 
		static Field GIVEN_NAME = new Field("givenName", 50);
		static Field SURNAME = new Field("surname", 50);
		static Field EMAIL_ADDRESS = new Field("emailAddress", 50);
		static Field PHONE = new Field("phone", 50);
		static Field ADDRESS1 = new Field("address1", 50);
		static Field ADDRESS2 = new Field("address2", 50);
		static Field POSTCODE = new Field("postcode", 4);
		static Field[] VALUES = new Field[] {ID, GIVEN_NAME, SURNAME, EMAIL_ADDRESS, PHONE, ADDRESS1, ADDRESS2, POSTCODE};
	}

	private String givenName;
	private String surname;
	private String emailAddress;
	private String phone;
	private String address1;
	private String address2;
	private String postcode;

	@Override
	public String toString() {
		return EntityToStringHelper.toString(this, Fields.VALUES);
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
