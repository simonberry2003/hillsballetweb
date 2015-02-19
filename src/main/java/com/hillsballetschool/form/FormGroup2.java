package com.hillsballetschool.form;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.border.Border;
import org.apache.wicket.model.Model;

import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.CssClassNameAppender;
import de.agilecoders.wicket.core.markup.html.bootstrap.form.FormGroup;

@SuppressWarnings("serial")
public class FormGroup2 extends FormGroup {

	public FormGroup2(String id, String label) {
		super(id, Model.of(label));
	}
	
	@Override
	public Border addToBorder(Component... children) {
		children[0].add(new CssClassNameAppender("col-sm-2"));
		return super.addToBorder(children);
	}
}
