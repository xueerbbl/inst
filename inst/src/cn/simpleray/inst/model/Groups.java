/**
 * Copyright (c) 2000-2015 Inst.Inc. All rights reserved.
 *
 */
package cn.simpleray.inst.model;

import java.util.List;

/**
 * @author Alan Zhang
 * 
 */
public class Groups {

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Group> getSubCategorys() {
		return subCategorys;
	}

	public void setSubCategorys(List<Group> subCategorys) {
		this.subCategorys = subCategorys;
	}

	private String name;

	private long id;

	private List<Group> subCategorys;
}
