package com.hillsballetschool.application;

import org.apache.wicket.Page;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.guice.GuiceComponentInjector;
import org.apache.wicket.guice.GuiceInjectorHolder;
import org.apache.wicket.protocol.http.WebApplication;

import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.hillsballetschool.pages.account.AccountPage;
import com.hillsballetschool.pages.account.edit.EditAccountPage;
import com.hillsballetschool.pages.classperiod.edit.EditClassPeriodPage;
import com.hillsballetschool.pages.classs.ClassPage;
import com.hillsballetschool.pages.classs.edit.EditClassPage;
import com.hillsballetschool.pages.client.edit.EditClientPage;
import com.hillsballetschool.pages.level.LevelPage;
import com.hillsballetschool.pages.level.edit.EditLevelPage;
import com.hillsballetschool.pages.period.PeriodPage;
import com.hillsballetschool.pages.period.edit.EditPeriodPage;
import com.hillsballetschool.pages.venue.VenuePage;
import com.hillsballetschool.pages.venue.edit.EditVenuePage;

import de.agilecoders.wicket.core.Bootstrap;

public class HillsBalletSchoolApplication extends WebApplication {
	
	@Override
	public Class<? extends Page> getHomePage() {
		return AccountPage.class;
	}

	@Override
	protected void init() {
		super.init();

		// Initialise guice
		GuiceComponentInjector injector = new GuiceComponentInjector(this, new JpaPersistModule("hillsballet"), new HillsBalletModule());
		getComponentInstantiationListeners().add(injector);
		
		// Start guice JPA service
		getMetaData(GuiceInjectorHolder.INJECTOR_KEY)
			.getInjector()
			.getInstance(PersistService.class)
			.start();
		
		getRequestCycleSettings().setGatherExtendedBrowserInfo(true);

		mountPage("/account", AccountPage.class);
		mountPage("/editAccount", EditAccountPage.class);
		mountPage("/level", LevelPage.class);
		mountPage("/editLevel", EditLevelPage.class);
		mountPage("/period", PeriodPage.class);
		mountPage("/editPeriod", EditPeriodPage.class);
		mountPage("/venue", VenuePage.class);
		mountPage("/editVenue", EditVenuePage.class);
		mountPage("/class", ClassPage.class);
		mountPage("/editClass", EditClassPage.class);
		mountPage("/editClassPeriod", EditClassPeriodPage.class);
		mountPage("/editClient", EditClientPage.class);
		
		Bootstrap.install(this);
	}		
	
	@Override
	public RuntimeConfigurationType getConfigurationType() {
		// TODO: Configure for deployment
		return super.getConfigurationType();
	}
}
