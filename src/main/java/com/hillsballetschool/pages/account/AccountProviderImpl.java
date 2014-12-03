package com.hillsballetschool.pages.account;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;

import com.google.common.base.Preconditions;
import com.hillsballetschool.dao.AccountDao;
import com.hillsballetschool.domain.Account;
import com.hillsballetschool.pages.ReadOnlyModel;
import com.hillsballetschool.pages.SortableDataProviderComparator;

@SuppressWarnings("serial")
@Singleton
public class AccountProviderImpl extends SortableDataProvider<Account, String> implements AccountProvider {
	
	private final AccountDao dao;

	@Inject
	public AccountProviderImpl(AccountDao dao) {
		this.dao = Preconditions.checkNotNull(dao);
        setSort("surname", SortOrder.ASCENDING);
	}
	
    @Override
	public Iterator<Account> iterator(long first, long count) {
    	List<Account> accounts = dao.get(first, count);
        Collections.sort(accounts, new SortableDataProviderComparator<Account>(getSort()));
        return accounts.iterator();
    }
 
	@Override
	public IModel<Account> model(final Account account) {
        return new ReadOnlyModel<Account>(account);
    }
 
    @Override
	public long size() {
        return dao.getCount();
    }
}
