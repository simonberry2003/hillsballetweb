package com.hillsballetschool.pages.account;

import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.validation.validator.EmailAddressValidator;
import org.apache.wicket.validation.validator.StringValidator;

import com.google.common.base.Preconditions;
import com.hillsballetschool.dao.AccountDao;
import com.hillsballetschool.domain.Account;

@SuppressWarnings("serial")
public class AccountForm extends StatelessForm<Account> {

	private final AccountDao accountDao;
	private Account account;
	
	/**
	 * Create a {@link AccountForm} with the specified id
	 * @param id
	 * @param account optional account for editing, If null a new account is created
	 * @param accountDao the {@link AccountDao} for accessing {@link Account}s
	 */
	public AccountForm(String id, Account account, AccountDao accountDao) {
		super(id);
		this.accountDao = Preconditions.checkNotNull(accountDao);
		if (account == null) {
			account = new Account();
		}
		this.account = account;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new TextField<String>(Account.Fields.GIVEN_NAME)
				.setRequired(true)
				.add(StringValidator.maximumLength(Account.Lengths.GIVEN_NAME)));
		add(new TextField<String>(Account.Fields.SURNAME)
				.setRequired(true)
				.add(StringValidator.maximumLength(Account.Lengths.SURNAME)));
		add(new TextField<String>(Account.Fields.EMAIL_ADDRESS)
				.setRequired(true)
				.add(EmailAddressValidator.getInstance())
				.add(StringValidator.maximumLength(Account.Lengths.EMAIL_ADDRESS)));
		add(new TextField<String>(Account.Fields.PHONE)
				.setRequired(true)
				.add(StringValidator.maximumLength(Account.Lengths.PHONE)));
		add(new TextField<String>(Account.Fields.ADDRESS1)
				.setRequired(true)
				.add(StringValidator.maximumLength(Account.Lengths.ADDRESS1)));
		add(new TextField<String>(Account.Fields.ADDRESS2)
				.setRequired(true)
				.add(StringValidator.maximumLength(Account.Lengths.ADDRESS2)));
		add(new TextField<String>(Account.Fields.POSTCODE)
				.setRequired(true)
				.add(StringValidator.maximumLength(Account.Lengths.POSTCODE)));
		setModel(new CompoundPropertyModel<Account>(account));
	}
	
	@Override
	public final void onSubmit() {
		setModel(new CompoundPropertyModel<Account>(accountDao.save(getModel().getObject())));
		success("Account has been saved");
	}
}
