package com.hillsballetschool.application;

import org.apache.wicket.Page;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.guice.GuiceComponentInjector;
import org.apache.wicket.guice.GuiceInjectorHolder;
import org.apache.wicket.protocol.http.WebApplication;

import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.hillsballetschool.pages.home.HomePage;

public class HillsBalletSchoolApplication extends WebApplication {
	
	@Override
	public Class<? extends Page> getHomePage() {
		return HomePage.class;
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
	}		
	
	@Override
	public RuntimeConfigurationType getConfigurationType() {
		// TODO: Configure for deployment
		return super.getConfigurationType();
	}
}
