package com.hillsballetschool.pages.account.edit;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.validation.validator.EmailAddressValidator;

import com.hillsballetschool.dao.AccountDao;
import com.hillsballetschool.domain.Account;
import com.hillsballetschool.pages.account.AccountPage;
import com.hillsballetschool.pages.edit.AbstractStatelessForm;

@SuppressWarnings("serial")
public class AccountForm extends AbstractStatelessForm<Account> {

	public AccountForm(String id, Account account, AccountDao accountDao) {
		super(id, account, accountDao);
	}

	@Override
	protected Account createModel() {
		return new Account();
	}

	@Override
	protected void addFields() {
		addGroup("groupGivenName", "Given Name", Account.Fields.GIVEN_NAME);
		addGroup("groupSurname", "Surname", Account.Fields.SURNAME);
		addGroup("groupEmailAddress", "Email", Account.Fields.EMAIL_ADDRESS)
			.addValidator(Account.Fields.EMAIL_ADDRESS, EmailAddressValidator.getInstance());
		addGroup("groupPhone", "Phone", Account.Fields.PHONE);
		addGroup("groupAddress", "Address", Account.Fields.ADDRESS1, Account.Fields.ADDRESS2);
		addGroup("groupPostcode", "Postcode", Account.Fields.POSTCODE);
	}

	@Override
	protected Class<? extends WebPage> getResponsePage() {
		return AccountPage.class;
	}
	@Override
	protected String getEntityName() {
		return "Account";
	}
}
