package com.hillsballetschool.pages.level.edit;

import javax.inject.Inject;

import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;

import com.google.common.base.Preconditions;
import com.hillsballetschool.dao.LevelDao;
import com.hillsballetschool.domain.Level;
import com.hillsballetschool.pages.menu.MenuWebPage;

/**
 * The {@link EditLevelPage} is for creating or updating levels
 */
@SuppressWarnings("serial")
public class EditLevelPage extends MenuWebPage {

	@Inject
	private LevelDao levelDao;
	
	private final PageParameters params;

	public EditLevelPage(PageParameters params) {
		this.params = Preconditions.checkNotNull(params);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		Level level = null;
		if (!params.isEmpty()) {
			StringValue levelParam = params.get(Level.Fields.ID.getName());
			long levelId = levelParam.toLong();
			level = levelDao.get(levelId);
		}
		
		add(new FeedbackPanel("feedbackPanel"));
		add(new LevelForm("levelForm", level, levelDao));
	}
}
