package com.hillsballetschool.application;

import com.google.inject.AbstractModule;
import com.hillsballetschool.dao.AccountDao;
import com.hillsballetschool.dao.AccountDaoImpl;
import com.hillsballetschool.pages.account.AccountProvider;
import com.hillsballetschool.pages.account.AccountProviderImpl;

public class HillsBalletModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(AccountProvider.class).to(AccountProviderImpl.class);
		bind(AccountDao.class).to(AccountDaoImpl.class);
	}
}
