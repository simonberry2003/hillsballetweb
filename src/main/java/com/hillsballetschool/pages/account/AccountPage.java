package com.hillsballetschool.pages.account;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.StringResourceModel;

import com.google.common.collect.ImmutableList;
import com.hillsballetschool.domain.Account;
import com.hillsballetschool.pages.account.edit.EditAccountPage;
import com.hillsballetschool.pages.link.LinkColumn;
import com.hillsballetschool.pages.menu.MenuWebPage;

/**
 * The {@link AccountPage} is for creating or updating accounts
 */
@SuppressWarnings("serial")
public class AccountPage extends MenuWebPage {

	@Inject
	private AccountProvider accountProvider;
	
	public AccountPage() {
        List<? extends IColumn<Account, String>> columns = ImmutableList.of(
           	new PropertyColumn<Account, String>(new Model<String>("Number"), Account.Fields.ID, Account.Fields.ID),
        	new PropertyColumn<Account, String>(new StringResourceModel("givenNameTableHeaderLabel", this, null), Account.Fields.GIVEN_NAME, Account.Fields.GIVEN_NAME),
        	new PropertyColumn<Account, String>(new Model<String>("Surname"), Account.Fields.SURNAME, Account.Fields.SURNAME),
        	new PropertyColumn<Account, String>(new Model<String>("Email Address"), Account.Fields.EMAIL_ADDRESS, Account.Fields.EMAIL_ADDRESS),
        	new PropertyColumn<Account, String>(new Model<String>("Phone"), Account.Fields.PHONE, Account.Fields.PHONE),
        	new PropertyColumn<Account, String>(new Model<String>("Address1"), Account.Fields.ADDRESS1, Account.Fields.ADDRESS1),
        	new PropertyColumn<Account, String>(new Model<String>("Address2"), Account.Fields.ADDRESS2, Account.Fields.ADDRESS2),
        	new PropertyColumn<Account, String>(new Model<String>("Postcode"), Account.Fields.POSTCODE, Account.Fields.POSTCODE),
        	new LinkColumn<Account>(new Model<String>(""), Account.Fields.ID, "Edit")
        );
		add(new BookmarkablePageLink<Void>("createAccountLink", EditAccountPage.class));
        add(new DefaultDataTable<Account, String>("datatable", columns, accountProvider, Integer.MAX_VALUE));
    }
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
	}
}
