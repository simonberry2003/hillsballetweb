package com.hillsballetschool.pages.classs;

import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;

import com.hillsballetschool.domain.Classs;

/**
 * Marker interface for guice binding
 */
public interface ClassProvider extends ISortableDataProvider<Classs, String> {
}
