package com.hillsballetschool.pages.classperiod;

import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;

import com.hillsballetschool.domain.ClassPeriod;

/**
 * Marker interface for guice binding
 */
public interface ClassPeriodProvider extends ISortableDataProvider<ClassPeriod, String> {
}
