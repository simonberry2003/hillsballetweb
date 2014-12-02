package com.hillsballetschool.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.google.common.base.Preconditions;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;
import com.hillsballetschool.domain.Account;

@Singleton
public class AccountDaoImpl implements AccountDao {

	private final Provider<EntityManager> emProvider;
	
    @Inject
	public AccountDaoImpl(Provider<EntityManager> emProvider) {
		this.emProvider = Preconditions.checkNotNull(emProvider);
	}

	@Override
	@Transactional
	public List<Account> getAccounts() {
		TypedQuery<Account> query = emProvider.get().createQuery("SELECT e FROM Account e", Account.class);
	    return query.getResultList();
	}
}
