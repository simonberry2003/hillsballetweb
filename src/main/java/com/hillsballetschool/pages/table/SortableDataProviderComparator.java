package com.hillsballetschool.pages.table;

import java.io.Serializable;
import java.util.Comparator;

import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.model.PropertyModel;

import com.google.common.base.Preconditions;

@SuppressWarnings("serial")
public class SortableDataProviderComparator<T> implements Comparator<T>, Serializable {
	
	private final SortParam<String> sort;

	public SortableDataProviderComparator(SortParam<String> sort) {
		this.sort = Preconditions.checkNotNull(sort);
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int compare(final T o1, final T o2) {
        PropertyModel<Comparable> m1 = new PropertyModel<Comparable>(o1, sort.getProperty());
        PropertyModel<Comparable> m2 = new PropertyModel<Comparable>(o2, sort.getProperty());
        int result = m1.getObject().compareTo(m2.getObject());
        if (!sort.isAscending()) {
            result = -result;
        }
        return result;
    }
}
