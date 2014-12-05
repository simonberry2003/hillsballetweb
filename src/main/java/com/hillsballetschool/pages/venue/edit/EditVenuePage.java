package com.hillsballetschool.pages.venue.edit;

import javax.inject.Inject;

import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;

import com.google.common.base.Preconditions;
import com.hillsballetschool.dao.VenueDao;
import com.hillsballetschool.domain.Venue;
import com.hillsballetschool.pages.menu.MenuWebPage;
import com.hillsballetschool.pages.venue.VenueForm;

/**
 * The {@link EditVenuePage} is for creating or updating venues
 */
@SuppressWarnings("serial")
public class EditVenuePage extends MenuWebPage {

	@Inject
	private VenueDao venueDao;
	
	private final PageParameters params;

	public EditVenuePage(PageParameters params) {
		this.params = Preconditions.checkNotNull(params);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		Venue venue = null;
		if (!params.isEmpty()) {
			StringValue venueParam = params.get(Venue.Fields.ID.getName());
			long venueId = venueParam.toLong();
			venue = venueDao.get(venueId);
		}
		
		add(new FeedbackPanel("feedbackPanel"));
		add(new VenueForm("venueForm", venue, venueDao));
	}
}
