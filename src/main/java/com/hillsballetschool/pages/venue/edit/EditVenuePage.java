package com.hillsballetschool.pages.venue.edit;

import javax.inject.Inject;

import org.apache.wicket.Component;

import com.hillsballetschool.dao.Dao;
import com.hillsballetschool.dao.VenueDao;
import com.hillsballetschool.domain.Venue;
import com.hillsballetschool.pages.edit.AbstractEditPage;

/**
 * The {@link EditVenuePage} is for creating or updating venues
 */
@SuppressWarnings("serial")
public class EditVenuePage extends AbstractEditPage<Venue> {

	@Inject
	private VenueDao venueDao;
	
	@Override
	protected Dao<Venue> getDao() {
		return venueDao;
	}

	@Override
	protected Component createForm(Venue venue) {
		return new VenueForm("venueForm", venue, venueDao);
	}

	@Override
	protected String getIdParamName() {
		return Venue.VENUE_ID;
	}
}
