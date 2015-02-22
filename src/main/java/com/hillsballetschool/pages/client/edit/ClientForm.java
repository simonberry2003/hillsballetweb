package com.hillsballetschool.pages.client.edit;

import org.apache.wicket.markup.html.WebPage;

import com.hillsballetschool.dao.ClientDao;
import com.hillsballetschool.domain.Client;
import com.hillsballetschool.pages.account.edit.EditAccountPage;
import com.hillsballetschool.pages.edit.AbstractStatelessForm;

@SuppressWarnings("serial")
public class ClientForm extends AbstractStatelessForm<Client> {
	
	public ClientForm(String id, Client client, ClientDao clientDao) {
		super(id, client, clientDao);
	}

	@Override
	protected Client createModel() {
		return new Client();
	}

	@Override
	protected void addFields() {
		addGroup("groupGivenName", "Given Name", Client.Fields.GIVEN_NAME);
		addGroup("groupSurname", "Surname", Client.Fields.SURNAME);
		addGroup("groupMedical", "Medical", Client.Fields.MEDICAL);
	}

	@Override
	protected Class<? extends WebPage> getResponsePage() {
		return EditAccountPage.class;
	}

	@Override
	protected String getEntityName() {
		return "Client";
	}
}
