package com.hillsballetschool.dao;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.wicket.protocol.http.WebSession;

import com.google.inject.Provider;
import com.hillsballetschool.domain.Client;

@Singleton
public class ClientDaoImpl extends AbstractDao<Client> implements ClientDao {

    @Inject
	public ClientDaoImpl(Provider<EntityManager> emProvider) {
    	super(emProvider, Client.GET);
	}

	@Override
	public String getSort() {
		return Client.Fields.SURNAME.getName();
	}

	@Override
	protected Class<Client> getEntityType() {
		return Client.class;
	}
	
	@Override
	protected String getWhere() {
		return "where account_id = ?1";
	}
	
	@Override
	protected void addParams(TypedQuery<?> query) {
		query.setParameter(1, WebSession.get().getAttribute("account_id"));
	}
}
