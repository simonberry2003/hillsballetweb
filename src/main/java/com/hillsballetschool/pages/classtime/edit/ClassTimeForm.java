package com.hillsballetschool.pages.classtime.edit;

import java.util.Date;

import org.apache.wicket.markup.html.WebPage;

import com.hillsballetschool.dao.ClassTimeDao;
import com.hillsballetschool.domain.ClassTime;
import com.hillsballetschool.field.FieldText;
import com.hillsballetschool.pages.classtime.ClassTimePage;
import com.hillsballetschool.pages.edit.AbstractStatelessForm;
import com.hillsballetschool.pages.period.edit.StartEndDateValidator;

@SuppressWarnings("serial")
public class ClassTimeForm extends AbstractStatelessForm<ClassTime> {

	public ClassTimeForm(String id, ClassTime classTime, ClassTimeDao dao) {
		super(id, classTime, dao);
	}

	@Override
	protected ClassTime createModel() {
		return new ClassTime();
	}

	@Override
	protected void addFields() {
		
		add(new FieldText<String>(ClassTime.Fields.DAY));
		add(new FieldText<String>(ClassTime.Fields.VENUE));
		add(new FieldText<String>(ClassTime.Fields.LEVEL));
		
		FieldText<Date> startDateField = new FieldText<Date>(ClassTime.Fields.START);
		add(startDateField);
		
		FieldText<Date> endDateField = new FieldText<Date>(ClassTime.Fields.END);
		add(endDateField);
		
		add(new StartEndDateValidator(startDateField, endDateField));
	}

	@Override
	protected Class<? extends WebPage> getResponsePage() {
		return ClassTimePage.class;
	}
}
