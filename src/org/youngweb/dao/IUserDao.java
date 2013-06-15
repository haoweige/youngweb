package org.youngweb.dao;

import org.young.dao.IDao;
import org.youngweb.model.User;

public interface IUserDao extends IDao {

	public User find(String name);
}
