package com.hillsballetschool.dao;

import java.util.List;

import com.hillsballetschool.domain.Account;

public interface AccountDao {
	List<Account> get(long first, long count);
	long getCount();
}
