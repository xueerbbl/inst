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
@Table(table = "message", pk = "messageId")
public class Message {
	public long getMessageId() {
		return messageId;
	}

	public long getCreateDate() {
		return createDate;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getUserName() {
		return userName;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getDetail() {
		return detail;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getStatus() {
		return status;
	}

	public String getStatusLabel() {
		if (status == 0) {
			return "未读";
		}
		else {
			return "已阅";
		}
	}

	public void setStatus(int status) {
		this.status = status;
	}


	private long messageId;

	private long createDate;

	private String companyName;

	private String userName;

	private String phone;

	private String email;

	private String detail;

	private int status;
}
