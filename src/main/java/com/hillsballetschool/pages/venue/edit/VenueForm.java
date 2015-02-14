package com.hillsballetschool.pages.venue.edit;

import org.apache.wicket.markup.html.WebPage;

import com.hillsballetschool.dao.VenueDao;
import com.hillsballetschool.domain.Venue;
import com.hillsballetschool.field.FieldText;
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
		add(new FieldText<String>(Venue.Fields.NAME));
		add(new FieldText<String>(Venue.Fields.PHONE));
		add(new FieldText<String>(Venue.Fields.ADDRESS1));
		add(new FieldText<String>(Venue.Fields.ADDRESS2));
		add(new FieldText<String>(Venue.Fields.POSTCODE));
	}

	@Override
	protected Class<? extends WebPage> getResponsePage() {
		return VenuePage.class;
	}
	
	@Override
	protected String getName() {
		return "Venue";
	}
}
