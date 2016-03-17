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
import org.springframework.web.multipart.MultipartFile;

import cn.simpleray.base.core.BaseServiceImpl;
import cn.simpleray.base.util.FileOperateUtil;
import cn.simpleray.base.util.Pagination;
import cn.simpleray.inst.model.Attachment;
import cn.simpleray.inst.persistence.impl.AttachmentPersistenceImpl;

/**
 * @author Alan Zhang
 * 
 */

@Service("attachmentService")
public class AttachmentLocalServiceImpl extends BaseServiceImpl {
	@Autowired
	public AttachmentPersistenceImpl attachmentPersistence;

	public void add(long categoryId, MultipartFile[] files)
		throws Exception {

		long now = new Date().getTime();

		for(MultipartFile file : files) {
			String filePath = FileOperateUtil.uploadAsZip(file);

			Attachment attachment = new Attachment();

			attachment.setFileName(file.getOriginalFilename());
			attachment.setCategoryId(categoryId);
			attachment.setCreateDate(now);
			attachment.setFileSize(file.getSize());
			attachment.setFilePath(filePath);

			attachmentPersistence.insert(attachment);
		}
	}

	public void delete(long attachmentId) {
		Attachment attachment = getEntry(attachmentId);

		delete(attachment);
	}

	public void delete(Attachment attachment) {
		try {
			FileOperateUtil.delete(attachment.getFilePath());

			attachmentPersistence.delete(attachment.getAttachmentId());
		} catch (Exception e) {
		}
	}

	public void deleteEntrys(long categoryId) {
		List<Attachment> attachments = getEntrys(categoryId);

		for (Attachment attachment : attachments) {
			delete(attachment);
		}
	}

	public Attachment getEntry(long primaryKey) {
		return attachmentPersistence.findByPrimaryKey(primaryKey);
	}

	public List<Attachment> getEntrys() {
		return attachmentPersistence.getEntrys();
	}

	public List<Attachment> getEntrys(long categoryId) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource(
				"categoryId", categoryId);

		return attachmentPersistence.getEntrys(namedParameters);
	}

	public Pagination<Attachment> getPagination(int type) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource(
			"type", type);

		String joinSql =
			" JOIN inst_group ON inst_group.groupId = attachment.categoryId " +
			"JOIN category ON inst_group.categoryId = category.categoryId ";
	
		return attachmentPersistence.getPagination(joinSql, namedParameters);
	}

	public Pagination<Attachment> getPagination(long categoryId) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource(
			"categoryId", categoryId);

		return attachmentPersistence.getPagination(namedParameters);
	}

	public void add(long categoryId, String fileName, long fileSize, String url) {
		long now = new Date().getTime();

		Attachment attachment = new Attachment();

		attachment.setFileName(fileName);
		attachment.setCategoryId(categoryId);
		attachment.setCreateDate(now);
		attachment.setFileSize(fileSize);
		attachment.setUrl(url);

		attachmentPersistence.insert(attachment);		
	}

	public Pagination<Attachment> getPaginationByCategory(long categoryId) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		String joinSql =
			" JOIN inst_group ON inst_group.groupId = attachment.categoryId " +
			" and inst_group.categoryId = " + categoryId;
		
			return attachmentPersistence.getPagination(joinSql, namedParameters);
	}

}
