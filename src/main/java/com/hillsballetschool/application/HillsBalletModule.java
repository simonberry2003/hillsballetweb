package com.hillsballetschool.application;

import com.google.inject.AbstractModule;
import com.hillsballetschool.dao.AccountDao;
import com.hillsballetschool.dao.AccountDaoImpl;
import com.hillsballetschool.dao.ClassTimeDao;
import com.hillsballetschool.dao.ClassTimeDaoImpl;
import com.hillsballetschool.dao.LevelDao;
import com.hillsballetschool.dao.LevelDaoImpl;
import com.hillsballetschool.dao.PeriodDao;
import com.hillsballetschool.dao.PeriodDaoImpl;
import com.hillsballetschool.dao.VenueDao;
import com.hillsballetschool.dao.VenueDaoImpl;
import com.hillsballetschool.pages.account.AccountProvider;
import com.hillsballetschool.pages.account.AccountProviderImpl;
import com.hillsballetschool.pages.classtime.ClassTimeProvider;
import com.hillsballetschool.pages.classtime.ClassTimeProviderImpl;
import com.hillsballetschool.pages.level.LevelProvider;
import com.hillsballetschool.pages.level.LevelProviderImpl;
import com.hillsballetschool.pages.period.PeriodProvider;
import com.hillsballetschool.pages.period.PeriodProviderImpl;
import com.hillsballetschool.pages.venue.VenueProvider;
import com.hillsballetschool.pages.venue.VenueProviderImpl;

public class HillsBalletModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(AccountProvider.class).to(AccountProviderImpl.class);
		bind(AccountDao.class).to(AccountDaoImpl.class);
		bind(ClassTimeProvider.class).to(ClassTimeProviderImpl.class);
		bind(ClassTimeDao.class).to(ClassTimeDaoImpl.class);
		bind(LevelProvider.class).to(LevelProviderImpl.class);
		bind(LevelDao.class).to(LevelDaoImpl.class);
		bind(PeriodProvider.class).to(PeriodProviderImpl.class);
		bind(PeriodDao.class).to(PeriodDaoImpl.class);
		bind(VenueProvider.class).to(VenueProviderImpl.class);
		bind(VenueDao.class).to(VenueDaoImpl.class);
	}
}
