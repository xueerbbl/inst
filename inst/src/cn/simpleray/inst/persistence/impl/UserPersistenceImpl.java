package cn.simpleray.inst.persistence.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.simpleray.base.core.BasePersistenceImpl;
import cn.simpleray.inst.model.User;

@Repository("userPersistence")
public class UserPersistenceImpl extends BasePersistenceImpl<User> {

	@Override
	public RowMapper<User> getModelMapper() {
		return new UserMapper();
	}

	private static final class UserMapper implements RowMapper<User> {
		@Override
	    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	User user = new User();

	    	user.setUserId(rs.getLong("userId"));
	    	user.setUserName(rs.getString("userName"));
	    	user.setCreateDate(rs.getLong("createDate"));
	    	user.setPassword(rs.getString("password"));
	    	user.setType(rs.getInt("type"));
	    	user.setPhone(rs.getString("phone"));
	    	user.setEmail(rs.getString("email"));

	        return user;
	    }
	}

}
