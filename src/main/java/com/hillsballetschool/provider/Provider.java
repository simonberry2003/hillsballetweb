package com.hillsballetschool.provider;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;

import com.google.common.base.Preconditions;
import com.hillsballetschool.dao.Dao;
import com.hillsballetschool.pages.table.ReadOnlyModel;
import com.hillsballetschool.pages.table.SortableDataProviderComparator;

/**
 * Generic provider for {@link DefaultDataTable}
 *
 * @param <T> the type to provide
 */
@SuppressWarnings("serial")
public abstract class Provider<T> extends SortableDataProvider<T, String> {
	
	private final Dao<T> dao;

	public Provider(Dao<T> dao) {
		this.dao = Preconditions.checkNotNull(dao);
        setSort(dao.getSort(), SortOrder.ASCENDING);
	}
	
    @Override
	public Iterator<T> iterator(long first, long count) {
    	List<T> data = dao.get(first, count);
        Collections.sort(data, new SortableDataProviderComparator<T>(getSort()));
        return data.iterator();
    }
 
	@Override
	public IModel<T> model(final T o) {
        return new ReadOnlyModel<T>(o);
    }
 
    @Override
	public long size() {
        return dao.getCount();
    }
}
