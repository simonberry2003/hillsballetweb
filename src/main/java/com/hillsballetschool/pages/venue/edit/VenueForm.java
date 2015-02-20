package com.hillsballetschool.pages.venue.edit;

import org.apache.wicket.markup.html.WebPage;

import com.hillsballetschool.dao.VenueDao;
import com.hillsballetschool.domain.Venue;
import com.hillsballetschool.pages.edit.AbstractStatelessForm;
import com.hillsballetschool.pages.venue.VenuePage;

@SuppressWarnings("serial")
public class VenueForm extends AbstractStatelessForm<Venue> {

	public VenueForm(String id, Venue venue, VenueDao venueDao) {
		super(id, venue, venueDao);
	}

	@Override
	protected Venue createModel() {
		return new Venue();
	}

	@Override
	protected void addFields() {
		addGroup("groupName", "Name", Venue.Fields.NAME);
		addGroup("groupPhone", "Phone", Venue.Fields.PHONE);
		addGroup("groupAddress", "Address", Venue.Fields.ADDRESS1, Venue.Fields.ADDRESS2);
		addGroup("groupPostcode", "Postcode", Venue.Fields.POSTCODE);
	}

	@Override
	protected Class<? extends WebPage> getResponsePage() {
		return VenuePage.class;
	}
	
	@Override
	protected String getEntityName() {
		return "Venue";
	}
}
