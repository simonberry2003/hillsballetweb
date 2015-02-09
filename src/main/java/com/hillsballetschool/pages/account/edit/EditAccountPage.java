package com.hillsballetschool.pages.account.edit;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;

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

	@Inject
	private AccountDao accountDao;

	@Inject
	private ClientProvider clientProvider;

	public EditAccountPage(PageParameters params) {
		super(params);
	}
	
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
		List<IColumn<Client, String>> columns = new ColumnBuilder<Client>(Client.Fields.ID, Client.Fields.VALUES, this, EditClientPage.class).build();
		
		String accountIdParam = getParameter("id");
		Long accountId = accountIdParam != null ? Long.valueOf(accountIdParam) : (Long) WebSession.get().getAttribute("account_id");

		BookmarkablePageLink<Void> createClientLink = new BookmarkablePageLink<Void>("createClientLink", EditClientPage.class);
		createClientLink.getPageParameters().add("accountId", accountId);
		add(createClientLink);
        
		WebSession.get().setAttribute("account_id", accountId);
		
		add(new DefaultDataTable<Client, String>("datatable", columns, clientProvider, Integer.MAX_VALUE));
	}
	
	@Override
	protected StringValue getModelId() {
		StringValue modelId = super.getModelId();
		return !modelId.isNull() ? modelId : StringValue.valueOf(WebSession.get().getAttribute("account_id"));
	}
}
