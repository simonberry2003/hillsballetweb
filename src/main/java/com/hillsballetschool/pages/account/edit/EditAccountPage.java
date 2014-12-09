package com.hillsballetschool.pages.account.edit;

import javax.inject.Inject;

import org.apache.wicket.Component;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.hillsballetschool.dao.AccountDao;
import com.hillsballetschool.dao.Dao;
import com.hillsballetschool.domain.Account;
import com.hillsballetschool.pages.edit.AbstractEditPage;

/**
 * The {@link EditAccountPage} is for creating or updating accounts
 */
@SuppressWarnings("serial")
public class EditAccountPage extends AbstractEditPage<Account> {

	@Inject
	private AccountDao accountDao;
	
	public EditAccountPage(PageParameters params) {
		super(params);
	}
	
	@Override
	protected Component createForm(Account account) {
		return new AccountForm("accountForm", account, accountDao);
	}

	@Override
	protected Dao<Account> getDao() {
		return accountDao;
	}
}
