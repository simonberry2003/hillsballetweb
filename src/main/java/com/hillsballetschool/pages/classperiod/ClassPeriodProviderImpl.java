package com.hillsballetschool.pages.classperiod;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.hillsballetschool.dao.ClassPeriodDao;
import com.hillsballetschool.domain.ClassPeriod;
import com.hillsballetschool.provider.Provider;

@SuppressWarnings("serial")
@Singleton
public class ClassPeriodProviderImpl extends Provider<ClassPeriod> implements ClassPeriodProvider {
	@Inject
	public ClassPeriodProviderImpl(ClassPeriodDao dao) {
		super(dao);
	}
}
