package com.hillsballetschool.table;

import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.markup.html.TransparentWebMarkupContainer;

@SuppressWarnings("serial")
public class BootstrapTable<T, S> extends DefaultDataTable<T, S> {

	public BootstrapTable(String id, List<? extends IColumn<T, S>> columns, ISortableDataProvider<T, S> dataProvider, int rowsPerPage) {
		super(id, columns, dataProvider, rowsPerPage);
		TransparentWebMarkupContainer table = new TransparentWebMarkupContainer("table");
        table.add(new AttributeModifier("class", "table table-striped table-condensed"));
        add(table);
	}
}
