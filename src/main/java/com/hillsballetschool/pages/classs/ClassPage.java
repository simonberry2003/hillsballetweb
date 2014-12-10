package com.hillsballetschool.pages.classs;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import com.hillsballetschool.domain.Classs;
import com.hillsballetschool.domain.Period;
import com.hillsballetschool.pages.classs.edit.EditClassPage;
import com.hillsballetschool.pages.menu.MenuWebPage;
import com.hillsballetschool.provider.ColumnBuilder;

/**
 * The {@link ClassPage} is for creating or updating {@link Period}s
 */
@SuppressWarnings("serial")
public class ClassPage extends MenuWebPage {

	@Inject
	private ClassProvider classProvider;
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		List<IColumn<Classs, String>> columns = new ColumnBuilder<Classs>(Classs.Fields.ID, Classs.Fields.VALUES, this, EditClassPage.class).build();
		add(new BookmarkablePageLink<Void>("createClassLink", EditClassPage.class));
        add(new DefaultDataTable<Classs, String>("datatable", columns, classProvider, Integer.MAX_VALUE));
	}
}
