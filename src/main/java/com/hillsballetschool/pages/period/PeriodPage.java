package com.hillsballetschool.pages.period;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;

import com.hillsballetschool.domain.Period;
import com.hillsballetschool.form.CreateButton;
import com.hillsballetschool.pages.menu.MenuWebPage;
import com.hillsballetschool.pages.period.edit.EditPeriodPage;
import com.hillsballetschool.provider.ColumnBuilder;
import com.hillsballetschool.table.BootstrapTable;

@SuppressWarnings("serial")
public class PeriodPage extends MenuWebPage {

	@Inject private PeriodProvider periodProvider;
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		List<IColumn<Period, String>> columns = new ColumnBuilder<Period>(Period.Fields.ID, Period.Fields.VALUES, this, EditPeriodPage.class).build();
		add(new CreateButton<Void>("createLink", EditPeriodPage.class, sessionParams, Period.PERIOD_ID));
        add(new BootstrapTable<Period, String>("datatable", columns, periodProvider, Integer.MAX_VALUE));
	}
}
