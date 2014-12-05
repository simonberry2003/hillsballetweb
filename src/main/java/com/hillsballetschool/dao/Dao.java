package com.hillsballetschool.dao;

import java.util.List;

public interface Dao<T> {
	List<T> get(long first, long count);
	long getCount();
	T get(long id);
	T save(T o);
	String getSort();
}
