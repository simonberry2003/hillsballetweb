package com.hillsballetschool.pages.level;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.hillsballetschool.dao.LevelDao;
import com.hillsballetschool.domain.Level;
import com.hillsballetschool.provider.Provider;

@SuppressWarnings("serial")
@Singleton
public class LevelProviderImpl extends Provider<Level> implements LevelProvider {
	@Inject
	public LevelProviderImpl(LevelDao dao) {
		super(dao);
	}
}
