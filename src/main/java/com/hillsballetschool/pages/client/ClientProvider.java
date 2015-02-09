package com.hillsballetschool.pages.client;

import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;

import com.hillsballetschool.domain.Client;

/**
 * Marker interface for guice binding
 */
public interface ClientProvider extends ISortableDataProvider<Client, String> {
}
