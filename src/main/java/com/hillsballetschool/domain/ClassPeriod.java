package com.hillsballetschool.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.common.base.Preconditions;
import com.hillsballetschool.field.Field;

@Entity
@Table(name="class_period")
@NamedQueries({
	@NamedQuery(name = ClassPeriod.GET, query = "SELECT cp FROM ClassPeriod cp WHERE cp.classs.id = ?1 ORDER BY cp.period.start")
})
@SuppressWarnings("serial")
public class ClassPeriod extends AbstractEntity {

	public static final String GET = "getClassPeriod";
	public static final String CLASS_PERIOD_ID = "class_period_id";

	public interface Fields {
		static Field ID = new Field("id", 50);
		static Field PERIOD = new Field("period");
		static Field CLASS = new Field("classs");
		static Field[] VALUES = new Field[] {ID, PERIOD};
	}

	@OneToOne
	@JoinColumn(name="periodId")
	private Period period;

	@OneToOne
	@JoinColumn(name="classId")
	private Classs classs;

	public ClassPeriod() {
	}
	
	public ClassPeriod(Classs classs) {
		this.classs = Preconditions.checkNotNull(classs);
	}

	@Override
	public String toString() {
		return classs.toString();
	}
}
