package com.hillsballetschool.pages.client.edit;

import javax.inject.Inject;

import org.apache.wicket.Component;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.hillsballetschool.dao.ClientDao;
import com.hillsballetschool.dao.Dao;
import com.hillsballetschool.domain.Client;
import com.hillsballetschool.pages.edit.AbstractEditPage;

/**
 * The {@link EditClientPage} is for creating or updating {@link Client}s
 */
@SuppressWarnings("serial")
public class EditClientPage extends AbstractEditPage<Client> {

	@Inject
	private ClientDao clientDao;
	
	public EditClientPage(PageParameters params) {
		super(params);
	}
	
	@Override
	protected Component createForm(Client client) {
		if (client == null) {
			client = new Client(getPageParameters().get("accountId").toLongObject());
		}
		return new ClientForm("clientForm", client, clientDao);
	}

	@Override
	protected Dao<Client> getDao() {
		return clientDao;
	}
}
