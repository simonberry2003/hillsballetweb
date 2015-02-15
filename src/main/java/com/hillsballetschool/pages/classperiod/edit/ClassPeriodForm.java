package com.hillsballetschool.pages.classperiod.edit;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.protocol.http.WebSession;

import com.google.common.base.Preconditions;
import com.hillsballetschool.dao.ClassPeriodDao;
import com.hillsballetschool.dao.PeriodDao;
import com.hillsballetschool.domain.ClassPeriod;
import com.hillsballetschool.domain.Classs;
import com.hillsballetschool.domain.Period;
import com.hillsballetschool.pages.classs.edit.EditClassPage;
import com.hillsballetschool.pages.edit.AbstractStatelessForm;

@SuppressWarnings("serial")
public class ClassPeriodForm extends AbstractStatelessForm<ClassPeriod> {

	private final PeriodDao periodDao;
	
	public ClassPeriodForm(String id, ClassPeriod classPeriod, ClassPeriodDao dao, PeriodDao periodDao) {
		super(id, classPeriod, dao);
		this.periodDao = Preconditions.checkNotNull(periodDao);
	}

	@Override
	protected ClassPeriod createModel() {
		Classs classs = (Classs) WebSession.get().getAttribute("class");
		return new ClassPeriod(classs);
	}

	@Override
	protected void addFields() {
		ClassPeriod classPeriod = getModel().getObject();
		add(new DropDownChoice<Period>("period", new PropertyModel<Period>(classPeriod, ClassPeriod.Fields.PERIOD.getName()), periodDao.getAll()).setRequired(true));
	}

	@Override
	protected Class<? extends WebPage> getResponsePage() {
		return EditClassPage.class;
	}
	
	@Override
	protected String getEntityName() {
		return "ClassPeriod";
	}
}
