package com.hillsballetschool.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Base {@link WebPage} class for all web pages. Has the addition of some useful methods.
 */
@SuppressWarnings("serial")
public abstract class HillsBalletSchoolWebPage extends WebPage implements ParameterProvider {

	public HillsBalletSchoolWebPage(PageParameters parameters) {
		super(parameters);
	}

	protected String getUrl(Class<? extends WebPage> pageClass, PageParameters parameters) {
		return getRequestCycle().getUrlRenderer().renderFullUrl(Url.parse(urlFor(pageClass, parameters).toString()));
	}

	public String getUrl(Class<? extends WebPage> pageClass) {
		return getUrl(pageClass, null);
	}
	
	@Override
	public String getParameter(String parameterName) {
		return getPageParameters().get(parameterName).toString();
	}
}
