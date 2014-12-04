package com.hillsballetschool.pages.account;

import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.validation.validator.EmailAddressValidator;

import com.hillsballetschool.domain.Account;

@SuppressWarnings("serial")
public class AccountForm extends StatelessForm<Account> {

	/**
	 * Create a {@link AccountForm} with the specified id
	 * @param id
	 */
	public AccountForm(String id) {
		super(id);
		add(new TextField<String>(Account.Fields.GIVEN_NAME).setRequired(true));
		add(new TextField<String>(Account.Fields.SURNAME).setRequired(true));
		add(new TextField<String>(Account.Fields.EMAIL_ADDRESS).setRequired(true).add(EmailAddressValidator.getInstance()));
		add(new TextField<String>(Account.Fields.PHONE).setRequired(true));
		add(new TextField<String>(Account.Fields.ADDRESS1).setRequired(true));
		add(new TextField<String>(Account.Fields.ADDRESS2).setRequired(true));
		add(new TextField<String>(Account.Fields.POSTCODE).setRequired(true));
		setModel(new CompoundPropertyModel<Account>(new Account()));
	}

	@Override
	public final void onSubmit() {
		Account account = getModel().getObject();
		System.out.println(account);
	}
}
