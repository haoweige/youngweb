package org.youngweb.dao.young.impl;

import org.young.dao.YoungDao;
import org.youngweb.dao.IUserDao;
import org.youngweb.model.User;

public class UserDao extends YoungDao implements IUserDao {

	@Override
	public String getTable() {
		return null;
	}

	@Override
	public User find(String name) {
		// ...
		return null;
	}

}