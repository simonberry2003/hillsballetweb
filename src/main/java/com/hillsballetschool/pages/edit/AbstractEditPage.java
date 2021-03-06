package com.hillsballetschool.pages.edit;

import javax.inject.Inject;

import org.apache.wicket.Component;
import org.apache.wicket.feedback.ComponentFeedbackMessageFilter;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.util.string.StringValue;

import com.hillsballetschool.dao.Dao;
import com.hillsballetschool.pages.menu.MenuWebPage;
import com.hillsballetschool.session.SessionParams;

@SuppressWarnings("serial")
public abstract class AbstractEditPage<T> extends MenuWebPage {

	@Inject protected SessionParams sessionParams;

	protected AbstractEditPage() {
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
		
		Component form = createForm(model);
		add(form);
		add(new FeedbackPanel("feedbackPanel", new ComponentFeedbackMessageFilter(form)));
	}

	protected Long getModelId() {
		return sessionParams.get(Long.class, this, "id", getIdSessionParamName());
	}

	protected abstract String getIdSessionParamName();
	protected abstract Dao<T> getDao();
	protected abstract Component createForm(T model);
}
