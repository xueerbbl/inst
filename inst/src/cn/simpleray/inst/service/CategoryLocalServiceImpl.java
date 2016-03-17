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

import cn.simpleray.base.core.BaseServiceImpl;
import cn.simpleray.base.util.Pagination;
import cn.simpleray.inst.model.Category;
import cn.simpleray.inst.persistence.impl.CategoryPersistenceImpl;

/**
 * @author Alan Zhang
 * 
 */
@Service("categoryService")
public class CategoryLocalServiceImpl extends BaseServiceImpl {
	@Autowired
	public CategoryPersistenceImpl categoryPersistence;

	public long addCategory(Category category) {
		category.setCreateDate(new Date().getTime());

		return categoryPersistence.insert(category);
	}

	public List<Category> getCategorys(int type) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource(
			"type", type);

		return categoryPersistence.getEntrys(namedParameters);
	}

	public Category getCategory(long categoryId) {
		return categoryPersistence.findByPrimaryKey(categoryId);
	}

	public void delete(long categoryId) {
		categoryPersistence.delete(categoryId);
	}

	public void updateCategory(Category category) {
		categoryPersistence.update(category);
	}

	public Pagination<Category> getPagination(int type) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource(
			"type", type);

		return categoryPersistence.getPagination(namedParameters);
	}

}
