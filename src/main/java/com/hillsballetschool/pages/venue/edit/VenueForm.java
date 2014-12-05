package com.hillsballetschool.pages.venue.edit;

import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.model.CompoundPropertyModel;

import com.google.common.base.Preconditions;
import com.hillsballetschool.dao.VenueDao;
import com.hillsballetschool.domain.Venue;
import com.hillsballetschool.field.FieldText;
import com.hillsballetschool.pages.venue.VenuePage;

@SuppressWarnings("serial")
public class VenueForm extends StatelessForm<Venue> {

	private final VenueDao venueDao;
	private Venue venue;
	
	/**
	 * Create a {@link VenueForm} with the specified id
	 * @param id
	 * @param venue optional venue for editing, If null a new venue is created
	 * @param venueDao the {@link VenueDao} for accessing {@link Venue}s
	 */
	public VenueForm(String id, Venue venue, VenueDao venueDao) {
		super(id);
		this.venueDao = Preconditions.checkNotNull(venueDao);
		if (venue == null) {
			venue = new Venue();
		}
		this.venue = venue;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new FieldText<String>(Venue.Fields.NAME));
		add(new FieldText<String>(Venue.Fields.PHONE));
		add(new FieldText<String>(Venue.Fields.ADDRESS1));
		add(new FieldText<String>(Venue.Fields.ADDRESS2));
		add(new FieldText<String>(Venue.Fields.POSTCODE));
		setModel(new CompoundPropertyModel<Venue>(venue));
	}
	
	@Override
	public final void onSubmit() {
		setModel(new CompoundPropertyModel<Venue>(venueDao.save(getModel().getObject())));
		setResponsePage(VenuePage.class);
	}
}
