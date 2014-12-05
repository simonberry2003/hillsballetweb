package com.hillsballetschool.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.google.inject.Provider;
import com.google.inject.persist.Transactional;
import com.hillsballetschool.domain.Account;

@Singleton
public class AccountDaoImpl extends AbstractDao<Account> implements AccountDao {

    @Inject
	public AccountDaoImpl(Provider<EntityManager> emProvider) {
    	super(emProvider);
	}

	@Override
	@Transactional
	public List<Account> get(long first, long count) {
		TypedQuery<Account> query = emProvider.get().createNamedQuery(Account.GET, Account.class);
		query.setFirstResult((int)first);
		query.setMaxResults((int)count);
	    return query.getResultList();
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
