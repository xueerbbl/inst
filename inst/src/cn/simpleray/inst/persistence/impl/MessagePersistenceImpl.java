package cn.simpleray.inst.persistence.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.simpleray.base.core.BasePersistenceImpl;
import cn.simpleray.inst.model.Message;

@Repository("messagePersistence")
public class MessagePersistenceImpl extends BasePersistenceImpl<Message> {

	@Override
	public RowMapper<Message> getModelMapper() {
		return new MessageMapper();
	}

	private static final class MessageMapper implements RowMapper<Message> {
		@Override
	    public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
			Message message = new Message();

			message.setCompanyName(rs.getString("companyName"));
			message.setCreateDate(rs.getLong("createDate"));
			message.setDetail(rs.getString("detail"));
			message.setEmail(rs.getString("email"));
			message.setMessageId(rs.getLong("messageId"));
			message.setPhone(rs.getString("phone"));
			message.setUserName(rs.getString("userName"));
			message.setStatus(rs.getInt("status"));

	        return message;
	    }
	}

}
