package com.hillsballetschool.pages.period.edit;

import javax.inject.Inject;

import org.apache.wicket.Component;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.hillsballetschool.dao.Dao;
import com.hillsballetschool.dao.PeriodDao;
import com.hillsballetschool.domain.Period;
import com.hillsballetschool.pages.edit.AbstractEditPage;

@SuppressWarnings("serial")
public class EditPeriodPage extends AbstractEditPage<Period> {

	@Inject private PeriodDao dao;

	// TODO: Move to base class
	public EditPeriodPage(PageParameters pageParameters) {
		if (pageParameters.get("id").isNull()) {
			sessionParams.clear(getIdSessionParamName());
		}
	}

	@Override
	protected Dao<Period> getDao() {
		return dao;
	}

	@Override
	protected Component createForm(Period period) {
		return new PeriodForm("periodForm", period, dao);
	}

	@Override
	protected String getIdSessionParamName() {
		return Period.PERIOD_ID;
	}
}
