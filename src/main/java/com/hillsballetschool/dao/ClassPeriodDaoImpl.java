package com.hillsballetschool.dao;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.google.common.base.Preconditions;
import com.google.inject.Provider;
import com.hillsballetschool.domain.ClassPeriod;
import com.hillsballetschool.domain.Classs;
import com.hillsballetschool.session.SessionParams;

@Singleton
public class ClassPeriodDaoImpl extends AbstractDao<ClassPeriod> implements ClassPeriodDao {

	private final SessionParams sessionParams;

    @Inject
	public ClassPeriodDaoImpl(Provider<EntityManager> emProvider, SessionParams sessionParams) {
    	super(emProvider, ClassPeriod.GET);
    	this.sessionParams = Preconditions.checkNotNull(sessionParams);
	}

	@Override
	public String getSort() {
		return ClassPeriod.Fields.PERIOD.getName();
	}

	@Override
	protected Class<ClassPeriod> getEntityType() {
		return ClassPeriod.class;
	}
	
	@Override
	protected String getWhere() {
		return "WHERE classId = ?1";
	}
	
	@Override
	protected void addParams(TypedQuery<?> query) {
		query.setParameter(1, sessionParams.get(Classs.CLASS_ID));
	}
}
