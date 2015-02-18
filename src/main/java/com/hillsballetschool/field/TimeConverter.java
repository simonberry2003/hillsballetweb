package com.hillsballetschool.field;

import java.sql.Time;
import java.util.Locale;

import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.util.convert.IConverter;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

@SuppressWarnings("serial")
public class TimeConverter implements IConverter<Time> {

	private final DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");
	
	@Override
	public Time convertToObject(String value, Locale locale) throws ConversionException {
		return new Time(formatter.parseDateTime(value).toDate().getTime());
	}

	@Override
	public String convertToString(Time value, Locale locale) {
		return formatter.print(value.getTime());
	}
}
