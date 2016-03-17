package cn.simpleray.inst.persistence.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.simpleray.base.core.BasePersistenceImpl;
import cn.simpleray.inst.model.Attachment;

@Repository("attachmentPersistence")
public class AttachmentPersistenceImpl extends BasePersistenceImpl<Attachment> {

	@Override
	public RowMapper<Attachment> getModelMapper() {
		return new AttachmentMapper();
	}

	private static final class AttachmentMapper implements
		RowMapper<Attachment> {

		@Override
	    public Attachment mapRow(ResultSet rs, int rowNum) throws SQLException {
			Attachment attachment = new Attachment();

			attachment.setAttachmentId(rs.getLong("attachmentId"));
			attachment.setCreateDate(rs.getLong("createDate"));
			attachment.setCreateUserId(rs.getLong("createUserId"));
			attachment.setCreateUserName(rs.getString("createUserName"));
			attachment.setCategoryId(rs.getInt("categoryId"));
			attachment.setFileName(rs.getString("fileName"));
			attachment.setFileSize(rs.getLong("fileSize"));
			attachment.setFilePath(rs.getString("filePath"));
			attachment.setUrl(rs.getString("url"));
			
	        return attachment;
	    }
	}

}
