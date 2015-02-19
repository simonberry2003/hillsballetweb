package com.hillsballetschool.pages.level;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import com.hillsballetschool.domain.Level;
import com.hillsballetschool.pages.level.edit.EditLevelPage;
import com.hillsballetschool.pages.menu.MenuWebPage;
import com.hillsballetschool.provider.ColumnBuilder;
import com.hillsballetschool.table.BootstrapTable;

/**
 * The {@link LevelPage} is for creating or updating levels
 */
@SuppressWarnings("serial")
public class LevelPage extends MenuWebPage {

	@Inject
	private LevelProvider levelProvider;
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		List<IColumn<Level, String>> columns = new ColumnBuilder<Level>(Level.Fields.ID, Level.Fields.VALUES, this, EditLevelPage.class).build();
		add(new BookmarkablePageLink<Void>("createLevelLink", EditLevelPage.class));
        add(new BootstrapTable<Level, String>("datatable", columns, levelProvider, Integer.MAX_VALUE));
	}
}
