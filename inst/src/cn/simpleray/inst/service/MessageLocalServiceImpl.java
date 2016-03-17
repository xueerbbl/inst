/**
 * Copyright (c) 2000-2015 Inst.Inc. All rights reserved.
 *
 */
package cn.simpleray.inst.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import cn.simpleray.base.util.Pagination;
import cn.simpleray.inst.model.Message;
import cn.simpleray.inst.persistence.impl.MessagePersistenceImpl;

/**
 * @author Alan Zhang
 * 
 */
@Service("messageService")
public class MessageLocalServiceImpl {
	@Autowired
	MessagePersistenceImpl messagePersistence;

	public long add(Message message) {
		message.setCreateDate(new Date().getTime());

		return messagePersistence.insert(message);
	}

	public void delete(long primaryKey) {
		messagePersistence.delete(primaryKey);
	}

	public Message getEntry(long primaryKey) {
		return messagePersistence.findByPrimaryKey(primaryKey);
	}

	public Pagination<Message> getPagination() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		return messagePersistence.getPagination(namedParameters);
	}

	public void updateMessage(long messageId, int status) {
		Message message = messagePersistence.findByPrimaryKey(messageId);

		message.setStatus(status);

		messagePersistence.update(message);
	}

}
