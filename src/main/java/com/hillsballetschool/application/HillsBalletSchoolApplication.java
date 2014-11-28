package com.hillsballetschool.application;

import org.apache.wicket.Page;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.protocol.http.WebApplication;

import com.hillsballetschool.pages.home.HomePage;

public class HillsBalletSchoolApplication extends WebApplication {
	
	@Override
	public Class<? extends Page> getHomePage() {
		return HomePage.class;
	}

	@Override
	protected void init() {
		super.init();

//		// Initialise guice
//		GuiceComponentInjector injector = new GuiceComponentInjector(this, new JpaPersistModule("gordolytics"), new GordolyticsModule());
//		getComponentInstantiationListeners().add(injector);
//		
//		// Start guice JPA service
//		getMetaData(GuiceInjectorHolder.INJECTOR_KEY)
//			.getInjector()
//			.getInstance(PersistService.class)
//			.start();
//		
//		getRequestCycleSettings().setGatherExtendedBrowserInfo(true);
	}		
	
	@Override
	public RuntimeConfigurationType getConfigurationType() {
		// TODO: Configure for deployment
		return super.getConfigurationType();
	}
}
