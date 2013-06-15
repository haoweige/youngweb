package org.youngweb.dao.jdbc.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.young.dao.EntityConverter;
import org.young.dao.JdbcDao;
import org.youngweb.dao.IUserDao;
import org.youngweb.model.User;

public class UserDao extends JdbcDao implements IUserDao {

	class UserConvertor implements EntityConverter<List<User>> {

		@Override
		public List<User> convert(ResultSet resultSet) throws SQLException {
			List<User> users = new ArrayList<User>();
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getString("ID"));
				user.setName(resultSet.getString("NAME"));
				user.setWork(resultSet.getString("WORK"));
				user.setPassword(resultSet.getString("PASSWORD"));
				users.add(user);
			}
			return users;
		}
	}

	@Override
	public User find(String name) {
		String SQL = "FROM USER WHERE NAME=?";
		List<User> list = query(SQL, new Object[] { name }, new UserConvertor());
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public String getTable() {
		return "USER";
	}

}
