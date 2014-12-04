package com.hillsballetschool.pages.account;

import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.hillsballetschool.pages.menu.MenuWebPage;

/**
 * The {@link EditAccountPage} is for creating or updating accounts
 */
@SuppressWarnings("serial")
public class EditAccountPage extends MenuWebPage {

	public EditAccountPage(PageParameters params) {
		add(new FeedbackPanel("feedbackPanel"));
		add(new AccountForm("accountForm"));
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
	}
}
