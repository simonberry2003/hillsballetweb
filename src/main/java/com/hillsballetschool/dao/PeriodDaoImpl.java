package com.hillsballetschool.dao;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;

import com.google.inject.Provider;
import com.hillsballetschool.domain.Period;

@Singleton
public class PeriodDaoImpl extends AbstractDao<Period> implements PeriodDao {

    @Inject
	public PeriodDaoImpl(Provider<EntityManager> emProvider) {
    	super(emProvider, Period.GET);
	}

	@Override
	public String getSort() {
		return Period.Fields.START.getName();
	}

	@Override
	protected Class<Period> getEntityType() {
		return Period.class;
	}
}
