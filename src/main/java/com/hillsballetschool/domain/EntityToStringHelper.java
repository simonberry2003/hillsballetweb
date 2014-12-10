package com.hillsballetschool.domain;

import java.lang.reflect.Method;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.base.Throwables;
import com.hillsballetschool.field.Field;

public class EntityToStringHelper {
	public static String toString(Object o, Field...fields) {
		ToStringHelper helper = Objects.toStringHelper(o);
		for (Field f : fields) {
			try {
				java.lang.reflect.Field field = o.getClass().getDeclaredField(f.getName());
				field.setAccessible(true);
				helper.add(f.getName(), field.get(o));
			} catch (NoSuchFieldException e) {
				try {
					String methodName = "get" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
					Method method = o.getClass().getMethod(methodName);
					method.setAccessible(true);
					helper.add(f.getName(), method.invoke(o));
				} catch (Exception e2) {
					throw Throwables.propagate(e2);
				}
			} catch (Exception e) {
				throw Throwables.propagate(e);
			}
		}
		return helper.toString();
	}
}
