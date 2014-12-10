package com.hillsballetschool.dao;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;

import com.google.inject.Provider;
import com.hillsballetschool.domain.Classs;

@Singleton
public class ClassDaoImpl extends AbstractDao<Classs> implements ClassDao {

    @Inject
	public ClassDaoImpl(Provider<EntityManager> emProvider) {
    	super(emProvider, Classs.GET);
	}

	@Override
	public String getSort() {
		return Classs.Fields.START.getName();
	}

	@Override
	protected Class<Classs> getEntityType() {
		return Classs.class;
	}
}
