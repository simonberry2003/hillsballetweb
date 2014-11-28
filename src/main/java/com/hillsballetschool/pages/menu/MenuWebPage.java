package com.hillsballetschool.pages.menu;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.hillsballetschool.menu.Menu;
import com.hillsballetschool.pages.HillsBalletSchoolWebPage;

/**
 * A {@link MenuWebPage} is a base class for all {@link WebPage}s that need to display the main menu.
 * <p>The menu items are defined in the {@link Menu} class. If you want to add a new menu item, add it there.
 */
@SuppressWarnings("serial")
public abstract class MenuWebPage extends HillsBalletSchoolWebPage {

	public MenuWebPage() {
		this(null);
	}

	public MenuWebPage(PageParameters parameters) {
		super(parameters);
		add(new Menu("mainMenu"));
	}
}
