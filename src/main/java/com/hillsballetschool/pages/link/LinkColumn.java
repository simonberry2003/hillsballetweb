package com.hillsballetschool.pages.link;

import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.google.common.base.Preconditions;
import com.hillsballetschool.pages.account.edit.EditAccountPage;

@SuppressWarnings("serial")
public class LinkColumn<T> extends AbstractColumn<T, String> {

	private final String propertyExpression;
	private final String label;
	
	public LinkColumn(IModel<String> displayModel, String propertyExpression, String label) {
		super(displayModel);
		this.propertyExpression = Preconditions.checkNotNull(propertyExpression);
		this.label = Preconditions.checkNotNull(label);
	}

	@Override
	public void populateItem(Item<ICellPopulator<T>> item, String componentId, IModel<T> rowModel) {
    	PropertyModel<Object> propertyModel = new PropertyModel<Object>(rowModel, propertyExpression);
		item.add(new LinkPanel(item, componentId, propertyModel));
	}
	
	@Override
	public boolean isSortable() {
		return false;
	}
	
    public class LinkPanel extends Panel {
        public LinkPanel(Item<ICellPopulator<T>> item, String componentId, final PropertyModel<Object> propertyModel) {
            super(componentId);
 
            Link<String> link = new Link<String>("link") {
                @Override
                public void onClick() {
        			PageParameters params = new PageParameters();
        			params.set(propertyExpression, propertyModel.getObject());
        			setResponsePage(EditAccountPage.class, params);
                }
            };
            add(link);
            link.add(new Label("label", new Model<String>(label)));
        }
    }
}
