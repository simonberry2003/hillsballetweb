package com.hillsballetschool.pages.level;

import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;

import com.hillsballetschool.domain.Level;

/**
 * Marker interface for guice binding
 */
public interface LevelProvider extends ISortableDataProvider<Level, String> {
}
