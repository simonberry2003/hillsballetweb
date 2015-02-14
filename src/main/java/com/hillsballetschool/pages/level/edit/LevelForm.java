package com.hillsballetschool.pages.level.edit;

import org.apache.wicket.markup.html.WebPage;

import com.hillsballetschool.dao.LevelDao;
import com.hillsballetschool.domain.Level;
import com.hillsballetschool.field.FieldText;
import com.hillsballetschool.pages.edit.AbstractStatelessForm;
import com.hillsballetschool.pages.level.LevelPage;

@SuppressWarnings("serial")
public class LevelForm extends AbstractStatelessForm<Level> {

	public LevelForm(String id, Level level, LevelDao levelDao) {
		super(id, level, levelDao);
	}

	@Override
	protected Level createModel() {
		return new Level();
	}

	@Override
	protected void addFields() {
		add(new FieldText<String>(Level.Fields.NAME));
	}

	@Override
	protected Class<? extends WebPage> getResponsePage() {
		return LevelPage.class;
	}
	
	@Override
	protected String getEntityName() {
		return "Level";
	}
}
