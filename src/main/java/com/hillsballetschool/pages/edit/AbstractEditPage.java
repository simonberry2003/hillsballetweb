package com.hillsballetschool.pages.edit;

import javax.inject.Inject;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.util.string.StringValue;

import com.hillsballetschool.dao.Dao;
import com.hillsballetschool.pages.menu.MenuWebPage;
import com.hillsballetschool.session.SessionParams;

@SuppressWarnings("serial")
public abstract class AbstractEditPage<T> extends MenuWebPage {

	@Inject 
	private SessionParams sessionParams;

	public AbstractEditPage() {
		setStatelessHint(false);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		T model = null;
		StringValue modelParam = StringValue.valueOf(getModelId());
		if (!modelParam.isNull()) {
			long id = modelParam.toLong();
			model = getDao().get(id);
		}
		
		add(new FeedbackPanel("feedbackPanel"));
		add(createForm(model));
	}

	protected Long getModelId() {
		return sessionParams.get(Long.class, this, "id", getIdParamName());
	}

	protected abstract String getIdParamName();
	protected abstract Dao<T> getDao();
	protected abstract Component createForm(T model);
}
