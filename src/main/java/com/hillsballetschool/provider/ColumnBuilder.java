package com.hillsballetschool.provider;

import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.hillsballetschool.field.Field;
import com.hillsballetschool.pages.link.LinkColumn;
import com.hillsballetschool.pages.table.ResourcePropertyColumn;

public class ColumnBuilder<T> {

	private final Field idField;
	private final Field[] fields;
	private final Component component;
	private final Class<? extends WebPage> responsePage;

	public ColumnBuilder(Field idField, Field[] fields, Component component, Class<? extends WebPage> responsePage) {
		this.idField = Preconditions.checkNotNull(idField);
		this.fields = Preconditions.checkNotNull(fields);
		this.component = Preconditions.checkNotNull(component);
		this.responsePage = Preconditions.checkNotNull(responsePage);
	}

	public List<IColumn<T, String>> build() {
        List<IColumn<T, String>> columns = Lists.newArrayList();
		for (Field f : fields) {
			columns.add(new ResourcePropertyColumn<T>(f, component));
		}
        columns.add(new LinkColumn<T>(new Model<String>(""), idField, "Edit", responsePage));
		return columns;
	}
}
