package com.hillsballetschool.pages.venue;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import com.hillsballetschool.domain.Venue;
import com.hillsballetschool.pages.menu.MenuWebPage;
import com.hillsballetschool.pages.venue.edit.EditVenuePage;
import com.hillsballetschool.provider.ColumnBuilder;

/**
 * The {@link VenuePage} is for creating or updating venues
 */
@SuppressWarnings("serial")
public class VenuePage extends MenuWebPage {

	@Inject
	private VenueProvider venueProvider;
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		List<IColumn<Venue, String>> columns = new ColumnBuilder<Venue>(Venue.Fields.ID, Venue.Fields.values(), this, EditVenuePage.class).build();
		add(new BookmarkablePageLink<Void>("createVenueLink", EditVenuePage.class));
        add(new DefaultDataTable<Venue, String>("datatable", columns, venueProvider, Integer.MAX_VALUE));
	}
}
