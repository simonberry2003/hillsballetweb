package com.hillsballetschool.pages.classs.edit;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.hillsballetschool.dao.ClassDao;
import com.hillsballetschool.dao.Dao;
import com.hillsballetschool.dao.LevelDao;
import com.hillsballetschool.dao.VenueDao;
import com.hillsballetschool.domain.ClassPeriod;
import com.hillsballetschool.domain.Classs;
import com.hillsballetschool.pages.classperiod.ClassPeriodProvider;
import com.hillsballetschool.pages.classperiod.edit.EditClassPeriodPage;
import com.hillsballetschool.pages.edit.AbstractEditPage;
import com.hillsballetschool.provider.ColumnBuilder;

@SuppressWarnings("serial")
public class EditClassPage extends AbstractEditPage<Classs> {

	@Inject private ClassDao dao;
	@Inject private VenueDao venueDao;
	@Inject private LevelDao levelDao;
	@Inject private ClassPeriodProvider classPeriodProvider;

	// TODO: Move to base class
	public EditClassPage(PageParameters pageParameters) {
		if (pageParameters.get("id").isNull()) {
			sessionParams.clear(getIdSessionParamName());
		}
	}

	@Override
	protected Dao<Classs> getDao() {
		return dao;
	}

	@Override
	protected Component createForm(Classs classs) {
		return new ClassForm("classForm", classs, dao, venueDao, levelDao);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		BookmarkablePageLink<Void> createClientPeriodLink = new BookmarkablePageLink<Void>("createClientPeriodLink", EditClassPeriodPage.class);
		Long classId = getModelId();
		if (classId != null) {
			createClientPeriodLink.getPageParameters().add("classId", classId);
		}
		add(createClientPeriodLink.setVisible(classId != null));
		
		List<IColumn<ClassPeriod, String>> columns = new ColumnBuilder<ClassPeriod>(ClassPeriod.Fields.ID, ClassPeriod.Fields.VALUES, this, EditClassPeriodPage.class).build();
		add(new DefaultDataTable<ClassPeriod, String>("datatable", columns, classPeriodProvider, Integer.MAX_VALUE).setVisible(classId != null));
	}

	@Override
	protected String getIdSessionParamName() {
		return Classs.CLASS_ID;
	}
}
