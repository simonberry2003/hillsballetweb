package com.hillsballetschool.pages.venue;

import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;

import com.hillsballetschool.domain.Venue;

/**
 * Marker interface for guice binding
 */
public interface VenueProvider extends ISortableDataProvider<Venue, String> {
}
