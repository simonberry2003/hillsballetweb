package com.hillsballetschool.pages.classs.edit;

import java.util.Date;

import org.apache.wicket.markup.html.WebPage;

import com.hillsballetschool.dao.ClassDao;
import com.hillsballetschool.domain.Classs;
import com.hillsballetschool.field.FieldText;
import com.hillsballetschool.pages.classs.ClassPage;
import com.hillsballetschool.pages.edit.AbstractStatelessForm;
import com.hillsballetschool.pages.period.edit.StartEndDateValidator;

@SuppressWarnings("serial")
public class ClassForm extends AbstractStatelessForm<Classs> {

	public ClassForm(String id, Classs classs, ClassDao dao) {
		super(id, classs, dao);
	}

	@Override
	protected Classs createModel() {
		return new Classs();
	}

	@Override
	protected void addFields() {
		
		add(new FieldText<String>(Classs.Fields.DAY));
		add(new FieldText<String>(Classs.Fields.VENUE));
		add(new FieldText<String>(Classs.Fields.LEVEL));
		
		FieldText<Date> startDateField = new FieldText<Date>(Classs.Fields.START);
		add(startDateField);
		
		FieldText<Date> endDateField = new FieldText<Date>(Classs.Fields.END);
		add(endDateField);
		
		add(new StartEndDateValidator(startDateField, endDateField));
	}

	@Override
	protected Class<? extends WebPage> getResponsePage() {
		return ClassPage.class;
	}
}
