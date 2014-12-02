package com.hillsballetschool.pages.account;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.StringResourceModel;

import com.google.common.collect.ImmutableList;
import com.hillsballetschool.domain.Account;
import com.hillsballetschool.pages.menu.MenuWebPage;

/**
 * The {@link AccountPage} is for creating or updating accounts
 */
@SuppressWarnings("serial")
public class AccountPage extends MenuWebPage {

	@Inject
	private AccountProvider accountProvider;
	
	public AccountPage() {
        List<PropertyColumn<Account, String>> columns = ImmutableList.of(
        	new PropertyColumn<Account, String>(new StringResourceModel("givenNameTableHeaderLabel", this, null), "givenName", "givenName"),
        	new PropertyColumn<Account, String>(new Model<String>("Surname"), "surname", "surname"),
        	new PropertyColumn<Account, String>(new Model<String>("Email"), "email", "email"),
        	new PropertyColumn<Account, String>(new Model<String>("Phone"), "phone", "phone"),
        	new PropertyColumn<Account, String>(new Model<String>("Address1"), "address1", "address1"),
        	new PropertyColumn<Account, String>(new Model<String>("Address2"), "address2", "address2"),
        	new PropertyColumn<Account, String>(new Model<String>("Postcode"), "postcode", "postcode")
        );
        add(new DefaultDataTable<Account, String>("datatable", columns, accountProvider, 10));
    }
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
	}
}
