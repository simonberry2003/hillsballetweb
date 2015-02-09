package com.hillsballetschool.pages.client.edit;

import org.apache.wicket.markup.html.WebPage;

import com.hillsballetschool.dao.ClientDao;
import com.hillsballetschool.domain.Client;
import com.hillsballetschool.field.FieldText;
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
		add(new FieldText<String>(Client.Fields.GIVEN_NAME));
		add(new FieldText<String>(Client.Fields.SURNAME));
		add(new FieldText<String>(Client.Fields.MEDICAL));
	}

	@Override
	protected Class<? extends WebPage> getResponsePage() {
		return EditAccountPage.class;
	}
}
