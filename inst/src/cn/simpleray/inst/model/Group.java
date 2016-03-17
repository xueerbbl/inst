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
@Table(table = "inst_group", pk = "groupId")
public class Group {

	public long getCategoryId() {
		return categoryId;
	}

	public String getName() {
		return name;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public void setName(String name) {
		this.name = name;
	}
	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	private long groupId;

	private long categoryId;

	private String name;
}
