package com.hillsballetschool.dao;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;

import com.google.inject.Provider;
import com.hillsballetschool.domain.Level;

@Singleton
public class LevelDaoImpl extends AbstractDao<Level> implements LevelDao {

    @Inject
	public LevelDaoImpl(Provider<EntityManager> emProvider) {
    	super(emProvider, Level.GET);
	}

	@Override
	public String getSort() {
		return Level.Fields.NAME.getName();
	}

	@Override
	protected Class<Level> getEntityType() {
		return Level.class;
	}
}
