package com.hillsballetschool.dao;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;

import com.google.inject.Provider;
import com.hillsballetschool.domain.ClassTime;

@Singleton
public class ClassTimeDaoImpl extends AbstractDao<ClassTime> implements ClassTimeDao {

    @Inject
	public ClassTimeDaoImpl(Provider<EntityManager> emProvider) {
    	super(emProvider, ClassTime.GET);
	}

	@Override
	public String getSort() {
		return ClassTime.Fields.START.getName();
	}

	@Override
	protected Class<ClassTime> getEntityType() {
		return ClassTime.class;
	}
}
