package com.hillsballetschool.pages.account.edit;

import javax.inject.Inject;

import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;

import com.google.common.base.Preconditions;
import com.hillsballetschool.dao.AccountDao;
import com.hillsballetschool.domain.Account;
import com.hillsballetschool.pages.account.AccountForm;
import com.hillsballetschool.pages.menu.MenuWebPage;

/**
 * The {@link EditAccountPage} is for creating or updating accounts
 */
@SuppressWarnings("serial")
public class EditAccountPage extends MenuWebPage {

	@Inject
	private AccountDao accountDao;
	
	private final PageParameters params;

	public EditAccountPage(PageParameters params) {
		this.params = Preconditions.checkNotNull(params);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		Account account = null;
		if (!params.isEmpty()) {
			StringValue accountParam = params.get(Account.Fields.ID);
			long accountId = accountParam.toLong();
			account = accountDao.get(accountId);
		}
		
		add(new FeedbackPanel("feedbackPanel"));
		add(new AccountForm("accountForm", account, accountDao));
	}
}
