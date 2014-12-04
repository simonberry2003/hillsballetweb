package com.hillsballetschool.pages.table;

import org.apache.wicket.model.AbstractReadOnlyModel;

import com.google.common.base.Preconditions;

@SuppressWarnings("serial")
public class ReadOnlyModel<T> extends AbstractReadOnlyModel<T> {

	private final T object;

	public ReadOnlyModel(T object) {
		this.object = Preconditions.checkNotNull(object);
	}

	@Override
	public T getObject() {
		return object;
	}
}
