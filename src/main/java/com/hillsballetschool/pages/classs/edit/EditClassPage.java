package com.hillsballetschool.pages.classs.edit;

import javax.inject.Inject;

import org.apache.wicket.Component;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.hillsballetschool.dao.ClassDao;
import com.hillsballetschool.dao.Dao;
import com.hillsballetschool.domain.Classs;
import com.hillsballetschool.pages.edit.AbstractEditPage;

/**
 * The {@link EditClassPage} is for creating or updating class times
 */
@SuppressWarnings("serial")
public class EditClassPage extends AbstractEditPage<Classs> {

	@Inject
	private ClassDao dao;
	
	public EditClassPage(PageParameters params) {
		super(params);
	}

	@Override
	protected Dao<Classs> getDao() {
		return dao;
	}

	@Override
	protected Component createForm(Classs classs) {
		return new ClassForm("classForm", classs, dao);
	}
}
