/**
 * Copyright (c) 2000-2015 Inst.Inc. All rights reserved.
 *
 */
package cn.simpleray.inst.model;

import cn.simpleray.base.core.annotation.Table;

/**
 * @author Alan Zhang
 * 
 */
@Table(table = "attachment", pk = "attachmentId")
public class Attachment {

	public long getAttachmentId() {
		return attachmentId;
	}

	public long getCreateDate() {
		return createDate;
	}

	public long getCreateUserId() {
		return createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public String getFileName() {
		return fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setAttachmentId(long attachmentId) {
		this.attachmentId = attachmentId;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}

	public void setCreateUserId(long createUserId) {
		this.createUserId = createUserId;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	private long attachmentId;

	private long createDate;

	private long createUserId;

	private String createUserName;

	private String fileName;

	private long fileSize;

	private long categoryId;

	private String filePath;

	private String url;
}
