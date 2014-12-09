package com.hillsballetschool.field;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.validation.validator.StringValidator;

@SuppressWarnings("serial")
public class FieldText<T> extends TextField<T> {
	public FieldText(Field field) {
		super(field.getName());
		if (field.getLength() != null) {
			add(StringValidator.maximumLength(field.getLength()));
		}
		setRequired(true);
	}
}
