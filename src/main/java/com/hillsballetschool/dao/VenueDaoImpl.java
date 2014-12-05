package com.hillsballetschool.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.google.inject.Provider;
import com.google.inject.persist.Transactional;
import com.hillsballetschool.domain.Venue;

@Singleton
public class VenueDaoImpl extends AbstractDao<Venue> implements VenueDao {

    @Inject
	public VenueDaoImpl(Provider<EntityManager> emProvider) {
    	super(emProvider);
	}

    // TOOD: Move into base dao
	@Override
	@Transactional
	public List<Venue> get(long first, long count) {
		TypedQuery<Venue> query = emProvider.get().createNamedQuery(Venue.GET, Venue.class);
		query.setFirstResult((int)first);
		query.setMaxResults((int)count);
	    return query.getResultList();
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
