package com.hillsballetschool.pages.account;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;

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
        	new ResourcePropertyColumn<Account>(Account.Fields.ID, this),
        	new ResourcePropertyColumn<Account>(Account.Fields.GIVEN_NAME, this),
        	new ResourcePropertyColumn<Account>(Account.Fields.SURNAME, this),
        	new ResourcePropertyColumn<Account>(Account.Fields.EMAIL_ADDRESS, this),
        	new ResourcePropertyColumn<Account>(Account.Fields.PHONE, this),
        	new ResourcePropertyColumn<Account>(Account.Fields.ADDRESS1, this),
        	new ResourcePropertyColumn<Account>(Account.Fields.ADDRESS2, this),
        	new ResourcePropertyColumn<Account>(Account.Fields.POSTCODE, this),
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
