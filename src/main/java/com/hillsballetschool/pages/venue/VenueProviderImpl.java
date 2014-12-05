package com.hillsballetschool.pages.venue;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.hillsballetschool.dao.VenueDao;
import com.hillsballetschool.domain.Venue;
import com.hillsballetschool.provider.Provider;

@SuppressWarnings("serial")
@Singleton
public class VenueProviderImpl extends Provider<Venue> implements VenueProvider {
	@Inject
	public VenueProviderImpl(VenueDao dao) {
		super(dao);
	}
}
