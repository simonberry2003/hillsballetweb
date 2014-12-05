package com.hillsballetschool.pages.account;

import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;

import com.hillsballetschool.domain.Account;

/**
 * Marker interface for guice binding
 */
public interface AccountProvider extends ISortableDataProvider<Account, String> {
}
