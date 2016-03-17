/**
 * Copyright (c) 2000-2015 Inst.Inc. All rights reserved.
 *
 */
package cn.simpleray.inst.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import cn.simpleray.base.core.BaseServiceImpl;
import cn.simpleray.base.util.Pagination;
import cn.simpleray.inst.model.User;
import cn.simpleray.inst.persistence.impl.UserPersistenceImpl;

/**
 * @author Alan Zhang
 * 
 */
@Service("userService")
public class UserLocalServiceImpl extends BaseServiceImpl {
	@Autowired
	public UserPersistenceImpl userPersistence;

	public long addUser(User user) {
		user.setCreateDate(new Date().getTime());

		return userPersistence.insert(user);
	}

	public List<User> getUsers() {
		return userPersistence.getEntrys();
	}

	public User getUser(long userId) {
		return userPersistence.findByPrimaryKey(userId);
	}

	public void deleteUser(long userId) {
		userPersistence.delete(userId);
	}

	public void updateUser(User user) {
		userPersistence.update(user);
	}

	public Pagination<User> getPagination() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		return userPersistence.getPagination(namedParameters);
	}

	public User getUser(String userName, String password) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		namedParameters.addValue("userName", userName);
		namedParameters.addValue("password", password);

		return userPersistence.getEntry(namedParameters);
	}
}
