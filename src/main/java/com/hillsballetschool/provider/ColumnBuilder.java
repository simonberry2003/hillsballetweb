package com.hillsballetschool.provider;

import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.model.Model;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.hillsballetschool.domain.Account.Fields;
import com.hillsballetschool.field.Field;
import com.hillsballetschool.pages.link.LinkColumn;
import com.hillsballetschool.pages.table.ResourcePropertyColumn;

public class ColumnBuilder<T> {

	private final Field idField;
	private final Field[] fields;
	private final Component component;
	
	public ColumnBuilder(Field idField, Fields[] fields, Component component) {
		this.idField = Preconditions.checkNotNull(idField);
		this.fields = Preconditions.checkNotNull(fields);
		this.component = Preconditions.checkNotNull(component);
	}

	public List<IColumn<T, String>> build() {
        Builder<IColumn<T, String>> columns = ImmutableList.builder();
		for (Field f : fields) {
			columns.add(new ResourcePropertyColumn<T>(f, component));
		}
        columns.add(new LinkColumn<T>(new Model<String>(""), idField, "Edit"));
		return columns.build();
	}
}
