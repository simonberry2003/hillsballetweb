package com.hillsballetschool.field;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.util.convert.IConverter;
import org.apache.wicket.validation.validator.StringValidator;

import com.google.common.base.Preconditions;

@SuppressWarnings("serial")
public class FieldText<T> extends TextField<T> {
	
	private IConverter<T> converter;

	public FieldText(Field field) {
		super(field.getName());
		if (field.getLength() != null) {
			add(StringValidator.maximumLength(field.getLength()));
		}
		setRequired(true);
	}

	public FieldText<T> setConverter(IConverter<T> converter) {
		this.converter = Preconditions.checkNotNull(converter);
		return this;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <C> IConverter<C> getConverter(Class<C> type) {
		return converter != null ? (IConverter<C>)converter : super.getConverter(type);
	}
}
