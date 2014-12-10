package com.hillsballetschool.pages.classs;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.hillsballetschool.dao.ClassDao;
import com.hillsballetschool.domain.Classs;
import com.hillsballetschool.provider.Provider;

@SuppressWarnings("serial")
@Singleton
public class ClassProviderImpl extends Provider<Classs> implements ClassProvider {
	@Inject
	public ClassProviderImpl(ClassDao dao) {
		super(dao);
	}
}
