package com.hillsballetschool.pages.edit;

import javax.persistence.OptimisticLockException;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.IValidator;
import org.hibernate.exception.ConstraintViolationException;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.hillsballetschool.dao.Dao;
import com.hillsballetschool.field.Field;
import com.hillsballetschool.field.FieldText;
import com.hillsballetschool.form.FormGroup2;

import de.agilecoders.wicket.core.markup.html.bootstrap.button.BootstrapButton;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.Buttons;
import de.agilecoders.wicket.core.markup.html.bootstrap.form.BootstrapForm;
import de.agilecoders.wicket.core.markup.html.bootstrap.form.FormBehavior;
import de.agilecoders.wicket.core.markup.html.bootstrap.form.FormGroup;
import de.agilecoders.wicket.core.markup.html.bootstrap.form.FormGroup.Size;
import de.agilecoders.wicket.core.markup.html.bootstrap.form.FormType;

@SuppressWarnings("serial")
public abstract class AbstractStatelessForm<T> extends BootstrapForm<T> {

	private final Dao<T> dao;
	private T model;

	public AbstractStatelessForm(String id, T model, Dao<T> dao) {
		super(id);
		this.dao = Preconditions.checkNotNull(dao);
		if (model == null) {
			model = createModel();
		}
		this.model = model;
	}

	protected abstract T createModel();

	@Override
	protected void onInitialize() {
		super.onInitialize();
		setModel(new CompoundPropertyModel<T>(model));
		add(new FormBehavior().type(FormType.Horizontal));
		addFields();

		FormGroup button = new FormGroup("groupButton");
        BootstrapButton submitButton = new BootstrapButton("submit-button", Buttons.Type.Primary);
        submitButton.setLabel(Model.of("Submit"));
        button.add(submitButton);
        add(button);
	}
	
	protected abstract void addFields();
	
	@Override
	public void onSubmit() {
		try {
			setModel(new CompoundPropertyModel<T>(dao.save(getModel().getObject())));
			setResponsePage(getResponsePage());
		} catch (OptimisticLockException e) {
			error(getEntityName() + " was updated by another user. Please reload and try again.");
		} catch (Exception e) {
			if (e.getCause() instanceof ConstraintViolationException) {
				error(getEntityName() + " has already been added.");
			} else {
				error(e.getMessage());
			}
		}
	}

	/**
	 * @return the name of the entity used in the form. Used in error messages.
	 */
	protected abstract String getEntityName();

	protected abstract Class<? extends WebPage> getResponsePage();
	
	protected void addGroup(String name, String label, Field...fields) {
		addGroup(name, label, Optional.<IValidator<String>>absent(), fields);
	}

	protected void addGroup(String name, String label, IValidator<String> validator, Field...fields) {
		addGroup(name, label, Optional.of(validator), fields);
	}

	protected void addGroup(String name, String label, Optional<IValidator<String>> validator, Field...fields) {
		FormGroup group = new FormGroup2(name, label).size(Size.Small);
		for (Field field : fields) {
			FieldText<String> textField = new FieldText<String>(field).formControl();
			if (validator.isPresent()) {
				textField.add(validator.get());
			}
			group.add(textField);
		}
        add(group);
	}
}
