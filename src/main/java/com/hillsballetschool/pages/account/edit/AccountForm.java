package com.hillsballetschool.pages.account.edit;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.validation.validator.EmailAddressValidator;

import com.hillsballetschool.dao.AccountDao;
import com.hillsballetschool.domain.Account;
import com.hillsballetschool.field.FieldText;
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
		add(new FieldText<String>(Account.Fields.GIVEN_NAME));
		add(new FieldText<String>(Account.Fields.SURNAME));
		add(new FieldText<String>(Account.Fields.EMAIL_ADDRESS)
			.add(EmailAddressValidator.getInstance()));
		add(new FieldText<String>(Account.Fields.PHONE));
		add(new FieldText<String>(Account.Fields.ADDRESS1));
		add(new FieldText<String>(Account.Fields.ADDRESS2));
		add(new FieldText<String>(Account.Fields.POSTCODE));
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
