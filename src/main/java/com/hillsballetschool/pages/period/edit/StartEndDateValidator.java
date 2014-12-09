package com.hillsballetschool.pages.period.edit;

import java.util.Date;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.validation.IFormValidator;

import com.google.common.base.Preconditions;

@SuppressWarnings("serial")
public class StartEndDateValidator implements IFormValidator {

	private FormComponent<Date> startDateField;
	private FormComponent<Date> endDateField;

	public StartEndDateValidator(FormComponent<Date> startDateField, FormComponent<Date> endDateField) {
    	this.startDateField = Preconditions.checkNotNull(startDateField);
    	this.endDateField = Preconditions.checkNotNull(endDateField);
	}

	@Override
	public FormComponent<?>[] getDependentFormComponents() {
        return new FormComponent[] { 
        	startDateField, 
        	endDateField 
        };
    }

    @Override
	public void validate(Form<?> form) {
        Date startDate = startDateField.getConvertedInput();
        Date endDate = endDateField.getConvertedInput();

        if (endDate.before(startDate)){
            form.error("Start date must be before end date");
        }
    }
}
