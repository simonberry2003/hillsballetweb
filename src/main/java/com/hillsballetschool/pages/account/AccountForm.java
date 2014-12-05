package com.hillsballetschool.pages.account;

import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.validation.validator.EmailAddressValidator;

import com.google.common.base.Preconditions;
import com.hillsballetschool.dao.AccountDao;
import com.hillsballetschool.domain.Account;
import com.hillsballetschool.field.FieldText;

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
		add(new FieldText<String>(Account.Fields.GIVEN_NAME));
		add(new FieldText<String>(Account.Fields.SURNAME));
		add(new FieldText<String>(Account.Fields.EMAIL_ADDRESS)
			.add(EmailAddressValidator.getInstance()));
		add(new FieldText<String>(Account.Fields.PHONE));
		add(new FieldText<String>(Account.Fields.ADDRESS1));
		add(new FieldText<String>(Account.Fields.ADDRESS2));
		add(new FieldText<String>(Account.Fields.POSTCODE));
		setModel(new CompoundPropertyModel<Account>(account));
	}
	
	@Override
	public final void onSubmit() {
		setModel(new CompoundPropertyModel<Account>(accountDao.save(getModel().getObject())));
		success("Account has been saved");
	}
}
