package com.hillsballetschool.pages.period.edit;

import javax.inject.Inject;

import org.apache.wicket.Component;

import com.hillsballetschool.dao.Dao;
import com.hillsballetschool.dao.PeriodDao;
import com.hillsballetschool.domain.Period;
import com.hillsballetschool.pages.edit.AbstractEditPage;

/**
 * The {@link EditPeriodPage} is for creating or updating levels
 */
@SuppressWarnings("serial")
public class EditPeriodPage extends AbstractEditPage<Period> {

	@Inject
	private PeriodDao dao;

	@Override
	protected Dao<Period> getDao() {
		return dao;
	}

	@Override
	protected Component createForm(Period period) {
		return new PeriodForm("periodForm", period, dao);
	}

	@Override
	protected String getIdParamName() {
		return Period.PERIOD_ID;
	}
}
