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
	public List<Account> get(long first, long count) {
		TypedQuery<Account> query = emProvider.get().createNamedQuery(Account.GET, Account.class);
		query.setFirstResult((int)first);
		query.setMaxResults((int)count);
	    return query.getResultList();
	}

	@Override
	@Transactional
	public long getCount() {
		TypedQuery<Number> query = emProvider.get().createNamedQuery(Account.COUNT, Number.class);
		return query.getSingleResult().longValue();  
	}

	@Override
	@Transactional
	public Account get(long id) {
		return emProvider.get().find(Account.class, id);
	}

	@Override
	@Transactional
	public Account save(Account account) {
		return emProvider.get().merge(account);
	}
}
