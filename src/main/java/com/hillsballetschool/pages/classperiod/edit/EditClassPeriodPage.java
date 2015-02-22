package com.hillsballetschool.pages.classperiod.edit;

import javax.inject.Inject;

import org.apache.wicket.Component;
import org.apache.wicket.protocol.http.WebSession;

import com.hillsballetschool.dao.ClassDao;
import com.hillsballetschool.dao.ClassPeriodDao;
import com.hillsballetschool.dao.Dao;
import com.hillsballetschool.dao.PeriodDao;
import com.hillsballetschool.domain.ClassPeriod;
import com.hillsballetschool.domain.Classs;
import com.hillsballetschool.pages.edit.AbstractEditPage;

@SuppressWarnings("serial")
public class EditClassPeriodPage extends AbstractEditPage<ClassPeriod> {

	@Inject private ClassPeriodDao classPeriodDao;
	@Inject private PeriodDao periodDao;
	@Inject private ClassDao classDao;
	
	@Override
	protected String getIdSessionParamName() {
		return ClassPeriod.CLASS_PERIOD_ID;
	}

	@Override
	protected Dao<ClassPeriod> getDao() {
		return classPeriodDao;
	}

	@Override
	protected Component createForm(ClassPeriod classPeriod) {
		Classs classs = classDao.get(sessionParams.<Long>get(Classs.CLASS_ID));
		WebSession.get().setAttribute("class", classs);
		return new ClassPeriodForm("classPeriodForm", classPeriod, classPeriodDao, periodDao);
	}
}
