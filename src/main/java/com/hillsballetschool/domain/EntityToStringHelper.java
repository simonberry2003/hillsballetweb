package com.hillsballetschool.domain;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.base.Throwables;
import com.hillsballetschool.domain.Account.Fields;
import com.hillsballetschool.field.Field;

public class EntityToStringHelper {
	public static String toString(Object o, Fields[] fields) {
		ToStringHelper helper = Objects.toStringHelper(o);
		for (Field f : fields) {
			try {
				java.lang.reflect.Field field = Account.class.getDeclaredField(f.getName());
				field.setAccessible(true);
				helper.add(f.getName(), field.get(o));
			} catch (Exception e) {
				throw Throwables.propagate(e);
			}
		}
		return helper.toString();
	}
}
