package com.hillsballetschool.menu;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import com.hillsballetschool.pages.account.AccountPage;
import com.hillsballetschool.pages.classs.ClassPage;
import com.hillsballetschool.pages.level.LevelPage;
import com.hillsballetschool.pages.menu.MenuWebPage;
import com.hillsballetschool.pages.period.PeriodPage;
import com.hillsballetschool.pages.venue.VenuePage;

import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.Navbar;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarButton;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarComponents;

/**
 * Main menu panel that contains all the menu links. The {@link Menu} is included in all pages that extend {@link MenuWebPage}.
 */
@SuppressWarnings("serial")
public class Menu extends Panel {
	
	public Menu(String id) {
		super(id);
		Navbar navbar = new Navbar("navbar");
		navbar.addComponents(NavbarComponents.transform(Navbar.ComponentPosition.LEFT, new NavbarButton<String>(AccountPage.class, Model.of("Accounts"))));
		navbar.addComponents(NavbarComponents.transform(Navbar.ComponentPosition.LEFT, new NavbarButton<String>(LevelPage.class, Model.of("Levels"))));
		navbar.addComponents(NavbarComponents.transform(Navbar.ComponentPosition.LEFT, new NavbarButton<String>(PeriodPage.class, Model.of("Periods"))));
		navbar.addComponents(NavbarComponents.transform(Navbar.ComponentPosition.LEFT, new NavbarButton<String>(VenuePage.class, Model.of("Venues"))));
		navbar.addComponents(NavbarComponents.transform(Navbar.ComponentPosition.LEFT, new NavbarButton<String>(ClassPage.class, Model.of("Classes"))));
		add(navbar);
	}
}
