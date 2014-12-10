package com.hillsballetschool.pages.edit;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.model.CompoundPropertyModel;

import com.google.common.base.Preconditions;
import com.hillsballetschool.dao.Dao;

@SuppressWarnings("serial")
public abstract class AbstractStatelessForm<T> extends StatelessForm<T> {

	private final Dao<T> dao;
	private T model;

	public AbstractStatelessForm(String id, T model, Dao<T> dao) {
		super(id);
		this.dao = Preconditions.checkNotNull(dao);
		if (model == null) {
			model = createModel();
		}
		this.model = model;
	}

	protected abstract T createModel();

	@Override
	protected void onInitialize() {
		super.onInitialize();
		setModel(new CompoundPropertyModel<T>(model));
		addFields();
	}
	
	protected abstract void addFields();
	
	@Override
	public void onSubmit() {
		setModel(new CompoundPropertyModel<T>(dao.save(getModel().getObject())));
		setResponsePage(getResponsePage());
	}

	protected abstract Class<? extends WebPage> getResponsePage();
}
