package com.hillsballetschool.pages.client.edit;

import javax.inject.Inject;

import org.apache.wicket.Component;

import com.hillsballetschool.dao.ClientDao;
import com.hillsballetschool.dao.Dao;
import com.hillsballetschool.domain.Client;
import com.hillsballetschool.pages.edit.AbstractEditPage;

@SuppressWarnings("serial")
public class EditClientPage extends AbstractEditPage<Client> {

	@Inject private ClientDao clientDao;

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

	@Override
	protected String getIdSessionParamName() {
		return Client.CLIENT_ID;
	}
}
