package com.hillsballetschool.pages.classtime;

import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;

import com.hillsballetschool.domain.ClassTime;

/**
 * Marker interface for guice binding
 */
public interface ClassTimeProvider extends ISortableDataProvider<ClassTime, String> {
}
