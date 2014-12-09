package com.hillsballetschool.pages.period;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.hillsballetschool.dao.PeriodDao;
import com.hillsballetschool.domain.Period;
import com.hillsballetschool.provider.Provider;

@SuppressWarnings("serial")
@Singleton
public class PeriodProviderImpl extends Provider<Period> implements PeriodProvider {
	@Inject
	public PeriodProviderImpl(PeriodDao dao) {
		super(dao);
	}
}
