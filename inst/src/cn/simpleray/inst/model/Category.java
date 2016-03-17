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
@Table(table = "category", pk = "categoryId")
public class Category {

	public long getCategoryId() {
		return categoryId;
	}

	public long getCreateUserId() {
		return createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public long getCreateDate() {
		return createDate;
	}

	public String getName() {
		return name;
	}

	public String getMicro() {
		return micro;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public void setCreateUserId(long createUserId) {
		this.createUserId = createUserId;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMicro(String micro) {
		this.micro = micro;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	private long categoryId;

	private long createUserId;

	private String createUserName;

	private long createDate;

	private String name;

	private String micro;

	private int type;
}
