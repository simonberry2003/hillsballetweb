package com.hillsballetschool.pages.classtime.edit;

import javax.inject.Inject;

import org.apache.wicket.Component;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.hillsballetschool.dao.ClassTimeDao;
import com.hillsballetschool.dao.Dao;
import com.hillsballetschool.domain.ClassTime;
import com.hillsballetschool.pages.edit.AbstractEditPage;

/**
 * The {@link EditClassTimePage} is for creating or updating class times
 */
@SuppressWarnings("serial")
public class EditClassTimePage extends AbstractEditPage<ClassTime> {

	@Inject
	private ClassTimeDao dao;
	
	public EditClassTimePage(PageParameters params) {
		super(params);
	}

	@Override
	protected Dao<ClassTime> getDao() {
		return dao;
	}

	@Override
	protected Component createForm(ClassTime classTime) {
		return new ClassTimeForm("classTimeForm", classTime, dao);
	}
}
