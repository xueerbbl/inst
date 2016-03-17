/**
 * Copyright (c) 2000-2015 Inst.Inc. All rights reserved.
 *
 */
package cn.simpleray.inst.model;

import javax.validation.constraints.NotNull;

import cn.simpleray.base.core.annotation.Table;

/**
 * @author Alan Zhang
 * 
 */
@Table(table = "user", pk = "userId")
public class User {

	public long getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public int getType() {
		return type;
	}

	public static String getTypeLabel(int type) {
		if (type == 1) {
			return "超级管理员";
		}
		else {
			return "文章管理员";
		}
	}
	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@NotNull(message = "用户名不能为空")
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@NotNull(message = "密码不能为空")
	public void setPassword(String password) {
		this.password = password;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}

	private long userId;

	private String userName;

	private long createDate;

	private String password;

	private int type;

	private String phone;

	private String email;

}
