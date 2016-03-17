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
@Table(table = "hireInfo", pk = "hireInfoId")
public class HireInfo {
	
	public long getHireInfoId() {
		return hireInfoId;
	}

	public long getCreateDate() {
		return createDate;
	}

	public String getTitle() {
		return title;
	}

	public int getNumber() {
		return number;
	}

	public String getLocation() {
		return location;
	}

	public int getStatus() {
		return status;
	}

	public String getDescription() {
		return description;
	}

	public void setHireInfoId(long hireInfoId) {
		this.hireInfoId = hireInfoId;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStatusLable() {
		if (status == 0) {
			return "正常";
		}
		else {
			return "过期";
		}
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private long hireInfoId;

	private long createDate;

	private String title;

	private int number;

	private String location;

	private int status;

	private String description;
}
