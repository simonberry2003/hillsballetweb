package com.hillsballetschool.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.google.common.base.Preconditions;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

public abstract class AbstractDao<T> implements Dao<T> {
	
	protected final Provider<EntityManager> emProvider;
	
	protected AbstractDao(Provider<EntityManager> emProvider) {
		this.emProvider = Preconditions.checkNotNull(emProvider);
	}

	@Override
	@Transactional
	public long getCount() {
		TypedQuery<Number> query = emProvider.get().createQuery("select count(e) from " + getEntityType().getSimpleName() + " e", Number.class);
		return query.getSingleResult().longValue();  
	}

	@Override
	@Transactional
	public T save(T o) {
		return emProvider.get().merge(o);
	}

	@Override
	@Transactional
	public T get(long id) {
		return emProvider.get().find(getEntityType(), id);
	}

	protected abstract Class<T> getEntityType();
}
