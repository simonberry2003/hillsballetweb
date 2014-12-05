package com.hillsballetschool.pages.account;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.hillsballetschool.dao.AccountDao;
import com.hillsballetschool.domain.Account;
import com.hillsballetschool.provider.Provider;

@SuppressWarnings("serial")
@Singleton
public class AccountProviderImpl extends Provider<Account> implements AccountProvider {
	@Inject
	public AccountProviderImpl(AccountDao dao) {
		super(dao);
	}
}
