package com.hillsballetschool.menu;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import com.hillsballetschool.pages.account.AccountPage;
import com.hillsballetschool.pages.classs.ClassPage;
import com.hillsballetschool.pages.level.LevelPage;
import com.hillsballetschool.pages.menu.MenuWebPage;
import com.hillsballetschool.pages.period.PeriodPage;
import com.hillsballetschool.pages.venue.VenuePage;

import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.INavbarComponent;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.Navbar;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.Navbar.Position;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarButton;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarComponents;

/**
 * Main menu panel that contains all the menu links. The {@link Menu} is included in all pages that extend {@link MenuWebPage}.
 */
@SuppressWarnings("serial")
public class Menu extends Panel {
	
	public Menu(String id) {
		super(id);
		Navbar navbar = new Navbar("navbar")
			.setBrandName(Model.of("HBS"))
			.setPosition(Position.TOP)
			.addComponents(makePageComponent(AccountPage.class, "Accounts"))
			.addComponents(makePageComponent(LevelPage.class, "Levels"))
			.addComponents(makePageComponent(PeriodPage.class, "Periods"))
			.addComponents(makePageComponent(VenuePage.class, "Venues"))
			.addComponents(makePageComponent(ClassPage.class, "Classes"));
		add(navbar);
	}

	private INavbarComponent makePageComponent(Class<? extends MenuWebPage> pageClass, String title) {
		return NavbarComponents.transform(Navbar.ComponentPosition.LEFT, new NavbarButton<String>(pageClass, Model.of(title))).get(0);
	}
}
