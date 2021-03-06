package com.hillsballetschool.pages.account;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;

import com.hillsballetschool.domain.Account;
import com.hillsballetschool.form.CreateButton;
import com.hillsballetschool.pages.account.edit.EditAccountPage;
import com.hillsballetschool.pages.menu.MenuWebPage;
import com.hillsballetschool.provider.ColumnBuilder;
import com.hillsballetschool.table.BootstrapTable;

/**
 * The {@link AccountPage} is for creating or updating accounts
 */
@SuppressWarnings("serial")
public class AccountPage extends MenuWebPage {

	@Inject private AccountProvider accountProvider;
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		List<IColumn<Account, String>> columns = new ColumnBuilder<Account>(Account.Fields.ID, Account.Fields.VALUES, this, EditAccountPage.class).build();
		add(new CreateButton<Void>("createLink", EditAccountPage.class, sessionParams, Account.ACCOUNT_ID));
        add(new BootstrapTable<Account, String>("datatable", columns, accountProvider, Integer.MAX_VALUE));
	}
}
