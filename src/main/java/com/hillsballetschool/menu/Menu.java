package com.hillsballetschool.menu;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

import com.hillsballetschool.pages.account.AccountPage;
import com.hillsballetschool.pages.level.LevelPage;
import com.hillsballetschool.pages.menu.MenuWebPage;
import com.hillsballetschool.pages.venue.VenuePage;

/**
 * Main menu panel that contains all the menu links. The {@link Menu} is included in all pages that extend {@link MenuWebPage}.
 */
@SuppressWarnings("serial")
public class Menu extends Panel {
	
	public Menu(String id) {
		super(id);
		add(new BookmarkablePageLink<Void>("accountLink", AccountPage.class));
		add(new BookmarkablePageLink<Void>("levelLink", LevelPage.class));
		add(new BookmarkablePageLink<Void>("venueLink", VenuePage.class));
	}
}
