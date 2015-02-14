package com.hillsballetschool.pages.classs.edit;

import java.sql.Time;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.model.PropertyModel;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.hillsballetschool.dao.ClassDao;
import com.hillsballetschool.dao.LevelDao;
import com.hillsballetschool.dao.VenueDao;
import com.hillsballetschool.domain.Classs;
import com.hillsballetschool.domain.Day;
import com.hillsballetschool.domain.Level;
import com.hillsballetschool.domain.Venue;
import com.hillsballetschool.field.FieldText;
import com.hillsballetschool.pages.classs.ClassPage;
import com.hillsballetschool.pages.edit.AbstractStatelessForm;

@SuppressWarnings("serial")
public class ClassForm extends AbstractStatelessForm<Classs> {

	private final VenueDao venueDao;
	private final LevelDao levelDao;
	
	public ClassForm(String id, Classs classs, ClassDao dao, VenueDao venueDao, LevelDao levelDao) {
		super(id, classs, dao);
		this.venueDao = Preconditions.checkNotNull(venueDao);
		this.levelDao = Preconditions.checkNotNull(levelDao);
	}

	@Override
	protected Classs createModel() {
		return new Classs();
	}

	@Override
	protected void addFields() {
		Classs classs = getModel().getObject();
		add(new DropDownChoice<Day>("day", new PropertyModel<Day>(classs, Classs.Fields.DAY.getName()), ImmutableList.<Day>copyOf(Day.values())).setRequired(true));
		add(new DropDownChoice<Venue>("venue", new PropertyModel<Venue>(classs, Classs.Fields.VENUE.getName()), venueDao.getAll()).setRequired(true));
		add(new DropDownChoice<Level>("level", new PropertyModel<Level>(classs, Classs.Fields.LEVEL.getName()), levelDao.getAll()).setRequired(true));
		add(new FieldText<Time>(Classs.Fields.START));
		add(new FieldText<Time>(Classs.Fields.END));
	}

	@Override
	protected Class<? extends WebPage> getResponsePage() {
		return ClassPage.class;
	}
	
	@Override
	protected String getName() {
		return "Class";
	}
}
