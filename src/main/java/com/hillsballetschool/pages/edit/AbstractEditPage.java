package com.hillsballetschool.pages.edit;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;

import com.google.common.base.Preconditions;
import com.hillsballetschool.dao.Dao;
import com.hillsballetschool.pages.menu.MenuWebPage;

@SuppressWarnings("serial")
public abstract class AbstractEditPage<T> extends MenuWebPage {

	private final PageParameters params;

	public AbstractEditPage(PageParameters params) {
		this.params = Preconditions.checkNotNull(params);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		T model = null;
		if (!params.isEmpty()) {
			StringValue modelParam = params.get("id");
			long id = modelParam.toLong();
			model = getDao().get(id);
		}
		
		add(new FeedbackPanel("feedbackPanel"));
		add(createForm(model));
	}

	protected abstract Dao<T> getDao();

	protected abstract Component createForm(T model);
}
