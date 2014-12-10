package com.hillsballetschool.pages.classs.edit;

import java.sql.Time;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.model.PropertyModel;

import com.google.common.collect.ImmutableList;
import com.hillsballetschool.dao.ClassDao;
import com.hillsballetschool.domain.Classs;
import com.hillsballetschool.domain.Day;
import com.hillsballetschool.field.FieldText;
import com.hillsballetschool.pages.classs.ClassPage;
import com.hillsballetschool.pages.edit.AbstractStatelessForm;

@SuppressWarnings("serial")
public class ClassForm extends AbstractStatelessForm<Classs> {

	private DropDownChoice<String> venues;
	private DropDownChoice<Day> days;
	
	public ClassForm(String id, Classs classs, ClassDao dao) {
		super(id, classs, dao);
	}

	@Override
	protected Classs createModel() {
		return new Classs();
	}

	@Override
	protected void addFields() {
		
		days = new DropDownChoice<Day>("day", new PropertyModel<Day>(getModel().getObject(), Classs.Fields.DAY.getName()), ImmutableList.<Day>copyOf(Day.values()));
		add(days);
		
		venues = new DropDownChoice<String>("venue", new PropertyModel<String>(getModel().getObject(), Classs.Fields.VENUE.getName()), ImmutableList.of("Stirling Scout Hut", "Stirling Scout Hut2", "Stirling Scout Hut3"));
		add(venues);
		
		add(new FieldText<String>(Classs.Fields.LEVEL));
		
		FieldText<Time> startDateField = new FieldText<Time>(Classs.Fields.START);
		add(startDateField);
		
		FieldText<Time> endDateField = new FieldText<Time>(Classs.Fields.END);
		add(endDateField);
		
		//add(new StartEndDateValidator(startDateField, endDateField));
	}

	@Override
	protected Class<? extends WebPage> getResponsePage() {
		return ClassPage.class;
	}

	@Override
	public void onSubmit() {
		super.onSubmit();
	}
}
