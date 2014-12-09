package com.hillsballetschool.dao;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;

import com.google.inject.Provider;
import com.hillsballetschool.domain.Account;

@Singleton
public class AccountDaoImpl extends AbstractDao<Account> implements AccountDao {

    @Inject
	public AccountDaoImpl(Provider<EntityManager> emProvider) {
    	super(emProvider, Account.GET);
	}

	@Override
	public String getSort() {
		return Account.Fields.SURNAME.getName();
	}

	@Override
	protected Class<Account> getEntityType() {
		return Account.class;
	}
}
