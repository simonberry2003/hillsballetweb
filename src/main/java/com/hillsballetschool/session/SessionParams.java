package com.hillsballetschool.session;

import java.io.Serializable;

import org.apache.wicket.protocol.http.WebSession;

import com.hillsballetschool.pages.ParameterProvider;

public interface SessionParams {
	/**
	 * Gets a parameter of specified type from either the {@link ParameterProvider} or the existing {@link WebSession}.
	 * <p>If the value is found as a parameter it is stored on the {@link WebSession}. If it is not found, it is assumed
	 * that the value has already been stored and is retrieved from the {@link WebSession} 
	 * @param type the param value type
	 * @param provider the {@link ParameterProvider}
	 * @param paramId the id of the paramter
	 * @param sessionId the is used on the {@link WebSession}
	 * @return the param value
	 */
	<T extends Serializable> T get(Class<T> type, ParameterProvider provider, String paramId, String sessionId);

	<T extends Serializable> T get(String name);

	void clear(String paramId);
}
