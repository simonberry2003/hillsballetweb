package com.hillsballetschool.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.hillsballetschool.field.Field;

@Entity
@Table(name="client")
@NamedQueries({
	@NamedQuery(name = Client.GET, query = "SELECT c FROM Client c WHERE c.accountId = ?1 ORDER BY c.surname, c.givenName")
})
@SuppressWarnings("serial")
public class Client extends AbstractEntity {

	public static final String GET = "getClient";
	public static final String CLIENT_ID = "clientId";
	
	public interface Fields {
		static Field ID = new Field("id", 50); 
		static Field GIVEN_NAME = new Field("givenName", 50);
		static Field SURNAME = new Field("surname", 50);
		static Field MEDICAL = new Field("medical", 1000);
		static Field[] VALUES = new Field[] {ID, GIVEN_NAME, SURNAME, MEDICAL};
	}

	private String givenName;
	private String surname;
	private String medical;

	@Column(name = "account_id")
	private Long accountId;
	
	public Client() {
	}
	
	public Client(long accountId) {
		this.accountId = accountId;
	}

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
	
	public String getMedical() {
		return medical;
	}
	
	public void setMedical(String medical) {
		this.medical = medical;
	}
}
