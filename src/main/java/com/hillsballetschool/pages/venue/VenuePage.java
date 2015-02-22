package com.hillsballetschool.pages.venue;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;

import com.hillsballetschool.domain.Venue;
import com.hillsballetschool.form.CreateButton;
import com.hillsballetschool.pages.menu.MenuWebPage;
import com.hillsballetschool.pages.venue.edit.EditVenuePage;
import com.hillsballetschool.provider.ColumnBuilder;
import com.hillsballetschool.table.BootstrapTable;

@SuppressWarnings("serial")
public class VenuePage extends MenuWebPage {

	@Inject private VenueProvider venueProvider;
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		List<IColumn<Venue, String>> columns = new ColumnBuilder<Venue>(Venue.Fields.ID, Venue.Fields.VALUES, this, EditVenuePage.class).build();
		add(new CreateButton<Void>("createLink", EditVenuePage.class, sessionParams, Venue.VENUE_ID));
        add(new BootstrapTable<Venue, String>("datatable", columns, venueProvider, Integer.MAX_VALUE));
	}
}
