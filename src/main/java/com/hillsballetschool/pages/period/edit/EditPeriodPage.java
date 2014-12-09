package com.hillsballetschool.pages.period.edit;

import javax.inject.Inject;

import org.apache.wicket.Component;
import org.apache.wicket.request.mapper.parameter.PageParameters;

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
	
	public EditPeriodPage(PageParameters params) {
		super(params);
	}

	@Override
	protected Dao<Period> getDao() {
		return dao;
	}

	@Override
	protected Component createForm(Period period) {
		return new PeriodForm("periodForm", period, dao);
	}
}
