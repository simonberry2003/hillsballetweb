package com.hillsballetschool.pages.level.edit;

import javax.inject.Inject;

import org.apache.wicket.Component;

import com.hillsballetschool.dao.Dao;
import com.hillsballetschool.dao.LevelDao;
import com.hillsballetschool.domain.Level;
import com.hillsballetschool.pages.edit.AbstractEditPage;

/**
 * The {@link EditLevelPage} is for creating or updating levels
 */
@SuppressWarnings("serial")
public class EditLevelPage extends AbstractEditPage<Level> {

	@Inject
	private LevelDao levelDao;
	
	@Override
	protected Dao<Level> getDao() {
		return levelDao;
	}

	@Override
	protected Component createForm(Level level) {
		return new LevelForm("levelForm", level, levelDao);
	}

	@Override
	protected String getIdParamName() {
		return Level.LEVEL_ID;
	}
}
