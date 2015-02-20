package com.hillsballetschool.pages.venue.edit;

import javax.inject.Inject;

import org.apache.wicket.Component;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.hillsballetschool.dao.Dao;
import com.hillsballetschool.dao.VenueDao;
import com.hillsballetschool.domain.Venue;
import com.hillsballetschool.pages.edit.AbstractEditPage;

@SuppressWarnings("serial")
public class EditVenuePage extends AbstractEditPage<Venue> {

	@Inject private VenueDao venueDao;
	
	// TODO: Move to base class
	public EditVenuePage(PageParameters pageParameters) {
		if (pageParameters.get("id").isNull()) {
			sessionParams.clear(getIdSessionParamName());
		}
	}
	
	@Override
	protected Dao<Venue> getDao() {
		return venueDao;
	}

	@Override
	protected Component createForm(Venue venue) {
		return new VenueForm("venueForm", venue, venueDao);
	}

	@Override
	protected String getIdSessionParamName() {
		return Venue.VENUE_ID;
	}
}
