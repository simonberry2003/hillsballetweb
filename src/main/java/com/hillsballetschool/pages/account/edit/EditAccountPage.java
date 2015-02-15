package com.hillsballetschool.pages.account.edit;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import com.hillsballetschool.dao.AccountDao;
import com.hillsballetschool.dao.Dao;
import com.hillsballetschool.domain.Account;
import com.hillsballetschool.domain.Client;
import com.hillsballetschool.pages.client.ClientProvider;
import com.hillsballetschool.pages.client.edit.EditClientPage;
import com.hillsballetschool.pages.edit.AbstractEditPage;
import com.hillsballetschool.provider.ColumnBuilder;

/**
 * The {@link EditAccountPage} is for creating or updating accounts
 */
@SuppressWarnings("serial")
public class EditAccountPage extends AbstractEditPage<Account> {

	@Inject private AccountDao accountDao;
	@Inject private ClientProvider clientProvider;
	
	@Override
	protected Component createForm(Account account) {
		return new AccountForm("accountForm", account, accountDao);
	}

	@Override
	protected Dao<Account> getDao() {
		return accountDao;
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		BookmarkablePageLink<Void> createClientLink = new BookmarkablePageLink<Void>("createClientLink", EditClientPage.class);
		Long accountId = getModelId();
		if (accountId != null) {
			createClientLink.getPageParameters().add("accountId", accountId);
		}
		add(createClientLink.setVisible(accountId != null));
		
		List<IColumn<Client, String>> columns = new ColumnBuilder<Client>(Client.Fields.ID, Client.Fields.VALUES, this, EditClientPage.class).build();
		add(new DefaultDataTable<Client, String>("datatable", columns, clientProvider, Integer.MAX_VALUE).setVisible(accountId != null));
	}

	@Override
	protected String getIdSessionParamName() {
		return Account.ACCOUNT_ID;
	}
}
