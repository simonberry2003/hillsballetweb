package com.hillsballetschool.pages.classtime;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.hillsballetschool.dao.ClassTimeDao;
import com.hillsballetschool.domain.ClassTime;
import com.hillsballetschool.provider.Provider;

@SuppressWarnings("serial")
@Singleton
public class ClassTimeProviderImpl extends Provider<ClassTime> implements ClassTimeProvider {
	@Inject
	public ClassTimeProviderImpl(ClassTimeDao dao) {
		super(dao);
	}
}
