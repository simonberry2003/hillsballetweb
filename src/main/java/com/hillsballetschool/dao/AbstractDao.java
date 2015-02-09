package com.hillsballetschool.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.google.common.base.Preconditions;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

public abstract class AbstractDao<T> implements Dao<T> {
	
	protected final Provider<EntityManager> emProvider;
	private final String getQueryName;
	
	protected AbstractDao(Provider<EntityManager> emProvider, String getQueryName) {
		this.emProvider = Preconditions.checkNotNull(emProvider);
		this.getQueryName = Preconditions.checkNotNull(getQueryName);
	}

	@Override
	@Transactional
	public long getCount() {
		String sql = "select count(e) from " + getEntityType().getSimpleName() + " e " + getWhere();
		TypedQuery<Number> query = emProvider.get().createQuery(sql, Number.class);
		addParams(query);
		return query.getSingleResult().longValue();  
	}

	protected String getWhere() {
		return "";
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

	@Override
	@Transactional
	public List<T> getAll() {
	    return get(0, Integer.MAX_VALUE);
	}

	@Override
	@Transactional
	public List<T> get(long first, long count) {
		TypedQuery<T> query = emProvider.get().createNamedQuery(getQueryName, getEntityType());
		addParams(query);
		query.setFirstResult((int)first);
		query.setMaxResults((int)count);
	    return query.getResultList();
	}

	protected void addParams(TypedQuery<?> query) {
	}

	protected abstract Class<T> getEntityType();
}
