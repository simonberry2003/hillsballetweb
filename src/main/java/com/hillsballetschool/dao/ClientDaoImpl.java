package com.hillsballetschool.dao;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.google.common.base.Preconditions;
import com.google.inject.Provider;
import com.hillsballetschool.domain.Account;
import com.hillsballetschool.domain.Client;
import com.hillsballetschool.session.SessionParams;

@Singleton
public class ClientDaoImpl extends AbstractDao<Client> implements ClientDao {

	private final SessionParams sessionParams;
	
    @Inject
	public ClientDaoImpl(Provider<EntityManager> emProvider, SessionParams sessionParams) {
    	super(emProvider, Client.GET);
    	this.sessionParams = Preconditions.checkNotNull(sessionParams);
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
		return "WHERE account_id = ?1";
	}
	
	@Override
	protected void addParams(TypedQuery<?> query) {
		query.setParameter(1, sessionParams.get(Account.ACCOUNT_ID));
	}
}
