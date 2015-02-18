package com.hillsballetschool.field;

import java.sql.Time;

import org.junit.Assert;
import org.junit.Test;

public class TimeConverterTest {

	@Test
	public void test() {
		TimeConverter converter = new TimeConverter();
		Assert.assertEquals(new Time(12600000), converter.convertToObject("13:00", null));
		Assert.assertEquals("13:00", converter.convertToString(new Time(12600000), null));
	}
}
