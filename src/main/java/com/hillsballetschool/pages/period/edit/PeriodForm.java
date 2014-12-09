package com.hillsballetschool.pages.period.edit;

import java.util.Date;

import org.apache.wicket.markup.html.WebPage;

import com.hillsballetschool.dao.PeriodDao;
import com.hillsballetschool.domain.Period;
import com.hillsballetschool.field.FieldText;
import com.hillsballetschool.pages.edit.AbstractStatelessForm;
import com.hillsballetschool.pages.period.PeriodPage;

@SuppressWarnings("serial")
public class PeriodForm extends AbstractStatelessForm<Period> {

	public PeriodForm(String id, Period period, PeriodDao dao) {
		super(id, period, dao);
	}

	@Override
	protected Period createModel() {
		return new Period();
	}

	@Override
	protected void addFields() {
		add(new FieldText<String>(Period.Fields.NAME));
		add(new FieldText<Date>(Period.Fields.START));
		add(new FieldText<Date>(Period.Fields.END));
	}

	@Override
	protected Class<? extends WebPage> getResponsePage() {
		return PeriodPage.class;
	}
}
