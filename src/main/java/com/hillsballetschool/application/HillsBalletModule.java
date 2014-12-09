package com.hillsballetschool.application;

import com.google.inject.AbstractModule;
import com.hillsballetschool.dao.AccountDao;
import com.hillsballetschool.dao.AccountDaoImpl;
import com.hillsballetschool.dao.LevelDao;
import com.hillsballetschool.dao.LevelDaoImpl;
import com.hillsballetschool.dao.VenueDao;
import com.hillsballetschool.dao.VenueDaoImpl;
import com.hillsballetschool.pages.account.AccountProvider;
import com.hillsballetschool.pages.account.AccountProviderImpl;
import com.hillsballetschool.pages.level.LevelProvider;
import com.hillsballetschool.pages.level.LevelProviderImpl;
import com.hillsballetschool.pages.venue.VenueProvider;
import com.hillsballetschool.pages.venue.VenueProviderImpl;

public class HillsBalletModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(AccountProvider.class).to(AccountProviderImpl.class);
		bind(AccountDao.class).to(AccountDaoImpl.class);
		bind(LevelProvider.class).to(LevelProviderImpl.class);
		bind(LevelDao.class).to(LevelDaoImpl.class);
		bind(VenueProvider.class).to(VenueProviderImpl.class);
		bind(VenueDao.class).to(VenueDaoImpl.class);
	}
}
