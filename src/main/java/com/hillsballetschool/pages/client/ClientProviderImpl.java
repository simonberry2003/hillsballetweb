package com.hillsballetschool.pages.client;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.hillsballetschool.dao.ClientDao;
import com.hillsballetschool.domain.Client;
import com.hillsballetschool.provider.Provider;

@SuppressWarnings("serial")
@Singleton
public class ClientProviderImpl extends Provider<Client> implements ClientProvider {
	@Inject
	public ClientProviderImpl(ClientDao dao) {
		super(dao);
	}
}
