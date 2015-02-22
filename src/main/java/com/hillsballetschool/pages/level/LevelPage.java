package com.hillsballetschool.pages.level;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;

import com.hillsballetschool.domain.Level;
import com.hillsballetschool.form.CreateButton;
import com.hillsballetschool.pages.level.edit.EditLevelPage;
import com.hillsballetschool.pages.menu.MenuWebPage;
import com.hillsballetschool.provider.ColumnBuilder;
import com.hillsballetschool.table.BootstrapTable;

@SuppressWarnings("serial")
public class LevelPage extends MenuWebPage {

	@Inject private LevelProvider levelProvider;
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		List<IColumn<Level, String>> columns = new ColumnBuilder<Level>(Level.Fields.ID, Level.Fields.VALUES, this, EditLevelPage.class).build();
		add(new CreateButton<Void>("createLink", EditLevelPage.class, sessionParams, Level.LEVEL_ID));
        add(new BootstrapTable<Level, String>("datatable", columns, levelProvider, Integer.MAX_VALUE));
	}
}
