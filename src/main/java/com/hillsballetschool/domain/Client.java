package com.hillsballetschool.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Client implements Serializable {

	public static final String GET = "getClient";
	
	public interface Fields {
		static Field ID = new Field("id", 50); 
		static Field GIVEN_NAME = new Field("givenName", 50);
		static Field SURNAME = new Field("surname", 50);
		static Field MEDICAL = new Field("medical", 1000);
		static Field[] VALUES = new Field[] {ID, GIVEN_NAME, SURNAME, MEDICAL};
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

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
	
	public String getMedical() {
		return medical;
	}
	
	public void setMedical(String medical) {
		this.medical = medical;
	}
}
