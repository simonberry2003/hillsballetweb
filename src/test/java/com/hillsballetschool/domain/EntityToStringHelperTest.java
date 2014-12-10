package com.hillsballetschool.domain;

import org.junit.Assert;
import org.junit.Test;

import com.hillsballetschool.field.Field;

public class EntityToStringHelperTest {

	private static class TestClass {

		interface Fields {
			static Field FIELD1 = new Field("field1"); 
			static Field FIELD2 = new Field("field2");
		}
		
		@SuppressWarnings("unused")
		private String field1 = "1";
		
		@SuppressWarnings("unused")
		public String getField2() {
			return "2";
		}
	}
	
	@Test
	public void test() {
		Assert.assertEquals("TestClass{field1=1, field2=2}", EntityToStringHelper.toString(new TestClass(), TestClass.Fields.FIELD1, TestClass.Fields.FIELD2));
	}
}
