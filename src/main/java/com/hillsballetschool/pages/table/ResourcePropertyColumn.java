package com.hillsballetschool.pages.table;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.StringResourceModel;

import com.hillsballetschool.field.Field;

/**
 * Wraps a {@link PropertyColumn} that gets the label from a property file using {@link StringResourceModel}
 * 
 * @param <T>
 */
@SuppressWarnings("serial")
public class ResourcePropertyColumn<T> extends PropertyColumn<T, String> {
	public ResourcePropertyColumn(Field field, Component component) {
		super(new StringResourceModel(field.getName(), component, null), field.getName(), field.getName());
	}
}
