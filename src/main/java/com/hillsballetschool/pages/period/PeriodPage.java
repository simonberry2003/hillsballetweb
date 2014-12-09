package com.hillsballetschool.pages.period;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import com.hillsballetschool.domain.Period;
import com.hillsballetschool.pages.menu.MenuWebPage;
import com.hillsballetschool.pages.period.edit.EditPeriodPage;
import com.hillsballetschool.provider.ColumnBuilder;

/**
 * The {@link PeriodPage} is for creating or updating {@link Period}s
 */
@SuppressWarnings("serial")
public class PeriodPage extends MenuWebPage {

	@Inject
	private PeriodProvider periodProvider;
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		List<IColumn<Period, String>> columns = new ColumnBuilder<Period>(Period.Fields.ID, Period.Fields.values(), this, EditPeriodPage.class).build();
		add(new BookmarkablePageLink<Void>("createPeriodLink", EditPeriodPage.class));
        add(new DefaultDataTable<Period, String>("datatable", columns, periodProvider, Integer.MAX_VALUE));
	}
}
