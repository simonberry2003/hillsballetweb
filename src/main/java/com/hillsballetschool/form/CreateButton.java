package com.hillsballetschool.form;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import com.google.common.base.Preconditions;
import com.hillsballetschool.session.SessionParams;

@SuppressWarnings("serial")
public class CreateButton<T> extends BookmarkablePageLink<T> {

	private final SessionParams sessionParams;
	private final String idParamName;

	public <C extends Page> CreateButton(String id, Class<C> pageClass, SessionParams sessionParams, String idParamName) {
		super(id, pageClass);
		this.sessionParams = Preconditions.checkNotNull(sessionParams);
		this.idParamName = Preconditions.checkNotNull(idParamName);
	}

	@Override
	protected CharSequence getURL() {
		sessionParams.clear(idParamName);
		return super.getURL();
	}
}
