package com.hillsballetschool.pages.account;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import com.hillsballetschool.domain.Account;
import com.hillsballetschool.pages.account.edit.EditAccountPage;
import com.hillsballetschool.pages.menu.MenuWebPage;
import com.hillsballetschool.provider.ColumnBuilder;

/**
 * The {@link AccountPage} is for creating or updating accounts
 */
@SuppressWarnings("serial")
public class AccountPage extends MenuWebPage {

	@Inject
	private AccountProvider accountProvider;
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		List<IColumn<Account, String>> columns = new ColumnBuilder<Account>(Account.Fields.ID, Account.Fields.values(), this).build();
		add(new BookmarkablePageLink<Void>("createAccountLink", EditAccountPage.class));
        add(new DefaultDataTable<Account, String>("datatable", columns, accountProvider, Integer.MAX_VALUE));
	}
}
