package com.hillsballetschool.pages.period.edit;

import java.util.Date;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.FormComponent;

import com.hillsballetschool.dao.PeriodDao;
import com.hillsballetschool.domain.Period;
import com.hillsballetschool.pages.edit.AbstractStatelessForm;
import com.hillsballetschool.pages.period.PeriodPage;

import de.agilecoders.wicket.core.markup.html.bootstrap.form.FormGroup;

@SuppressWarnings("serial")
public class PeriodForm extends AbstractStatelessForm<Period> {

	public PeriodForm(String id, Period period, PeriodDao dao) {
		super(id, period, dao);
	}

	@Override
	protected Period createModel() {
		return new Period();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addFields() {
		addGroup("groupName", "Name", Period.Fields.NAME);
		FormGroup startDateGroup = addGroup("groupStart", "Start", Period.Fields.START);
		FormGroup endDateGroup = addGroup("groupEnd", "End", Period.Fields.END);
		FormComponent<Date> startDateField = (FormComponent<Date>) startDateGroup.getBodyContainer().get("start");
		FormComponent<Date> endDateField = (FormComponent<Date>) startDateGroup.getBodyContainer().get(endDateGroup.getBodyContainer().size()-1);
		add(new StartEndDateValidator(startDateField, endDateField));
	}

	@Override
	protected Class<? extends WebPage> getResponsePage() {
		return PeriodPage.class;
	}
	
	@Override
	protected String getEntityName() {
		return "Period";
	}
}
