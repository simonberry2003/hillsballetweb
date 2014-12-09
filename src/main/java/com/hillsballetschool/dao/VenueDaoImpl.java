package com.hillsballetschool.dao;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;

import com.google.inject.Provider;
import com.hillsballetschool.domain.Venue;

@Singleton
public class VenueDaoImpl extends AbstractDao<Venue> implements VenueDao {

    @Inject
	public VenueDaoImpl(Provider<EntityManager> emProvider) {
    	super(emProvider, Venue.GET);
	}

	@Override
	public String getSort() {
		return Venue.Fields.NAME.getName();
	}

	@Override
	protected Class<Venue> getEntityType() {
		return Venue.class;
	}
}
