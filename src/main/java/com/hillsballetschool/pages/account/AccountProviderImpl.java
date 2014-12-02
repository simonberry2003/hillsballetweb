package com.hillsballetschool.pages.account;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import com.hillsballetschool.dao.AccountDao;
import com.hillsballetschool.domain.Account;

@SuppressWarnings("serial")
@Singleton
public class AccountProviderImpl extends SortableDataProvider<Account, String> implements AccountProvider {
	
	private final AccountDao dao;

	@Inject
	public AccountProviderImpl(AccountDao dao) {
		this.dao = dao;
        setSort("givenName", SortOrder.ASCENDING);
	}
	
	private class SortableDataProviderComparator implements Comparator<Account>, Serializable {
        @Override
		public int compare(final Account o1, final Account o2) {
            PropertyModel<String> model1 = new PropertyModel<String>(o1, getSort().getProperty());
            PropertyModel<String> model2 = new PropertyModel<String>(o2, getSort().getProperty());
 
            int result = model1.getObject().compareTo(model2.getObject());
 
            if (!getSort().isAscending()) {
                result = -result;
            }
            return result;
        }
    }
 
    private SortableDataProviderComparator comparator = new SortableDataProviderComparator();
 
    @Override
	public Iterator<Account> iterator(final long first, final long count) {
    	List<Account> accounts = dao.getAccounts();
        Collections.sort(accounts, comparator);
        return accounts.subList((int)first, (int)(first + count)).iterator();
    }
 
	@Override
	public IModel<Account> model(final Account object) {
        return new AbstractReadOnlyModel<Account>() {
            @Override
            public Account getObject() {
                return object;
            }
        };
    }
 
    @Override
	public long size() {
        return dao.getAccounts().size();
    }
}
