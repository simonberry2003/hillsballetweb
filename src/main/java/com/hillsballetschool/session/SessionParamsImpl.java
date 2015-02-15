package com.hillsballetschool.session;

import java.io.Serializable;
import java.lang.reflect.Constructor;

import javax.inject.Singleton;

import org.apache.wicket.protocol.http.WebSession;

import com.google.common.base.Throwables;
import com.hillsballetschool.pages.ParameterProvider;

@Singleton
public class SessionParamsImpl implements SessionParams {

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Serializable> T get(Class<T> type, ParameterProvider provider, String paramId, String sessionId) {

		String paramValue = provider.getParameter(paramId);
		if (paramValue == null) {
			return (T) WebSession.get().getAttribute(sessionId);
		}

		try {
			Constructor<T> constructor = type.getConstructor(String.class);
			T value = constructor.newInstance(paramValue);
			WebSession.get().setAttribute(sessionId, value);
			return value;
		} catch (Exception e) {
			throw Throwables.propagate(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Serializable> T get(String name) {
		return (T) WebSession.get().getAttribute(name);
	}

	@Override
	public void clear(String paramId) {
		WebSession.get().setAttribute(paramId, null);
	}
}
