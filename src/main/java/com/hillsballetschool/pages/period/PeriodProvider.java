package com.hillsballetschool.pages.period;

import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;

import com.hillsballetschool.domain.Period;

/**
 * Marker interface for guice binding
 */
public interface PeriodProvider extends ISortableDataProvider<Period, String> {
}
