package com.hillsballetschool.pages.classtime;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import com.hillsballetschool.domain.ClassTime;
import com.hillsballetschool.domain.Period;
import com.hillsballetschool.pages.classtime.edit.EditClassTimePage;
import com.hillsballetschool.pages.menu.MenuWebPage;
import com.hillsballetschool.provider.ColumnBuilder;

/**
 * The {@link ClassTimePage} is for creating or updating {@link Period}s
 */
@SuppressWarnings("serial")
public class ClassTimePage extends MenuWebPage {

	@Inject
	private ClassTimeProvider classTimeProvider;
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		List<IColumn<ClassTime, String>> columns = new ColumnBuilder<ClassTime>(ClassTime.Fields.ID, ClassTime.Fields.VALUES, this, EditClassTimePage.class).build();
		add(new BookmarkablePageLink<Void>("createClassTimeLink", EditClassTimePage.class));
        add(new DefaultDataTable<ClassTime, String>("datatable", columns, classTimeProvider, Integer.MAX_VALUE));
	}
}
