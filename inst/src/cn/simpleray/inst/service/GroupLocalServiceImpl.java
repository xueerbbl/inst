/**
 * Copyright (c) 2000-2015 Inst.Inc. All rights reserved.
 *
 */
package cn.simpleray.inst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import cn.simpleray.base.core.BaseServiceImpl;
import cn.simpleray.base.util.Pagination;
import cn.simpleray.base.util.WebKey;
import cn.simpleray.inst.model.Category;
import cn.simpleray.inst.model.Group;
import cn.simpleray.inst.persistence.impl.CategoryPersistenceImpl;
import cn.simpleray.inst.persistence.impl.GroupPersistenceImpl;

/**
 * @author Alan Zhang
 * 
 */
@Service("groupService")
public class GroupLocalServiceImpl extends BaseServiceImpl {
	@Autowired
	public CategoryPersistenceImpl categoryPersistence;
	@Autowired
	public GroupPersistenceImpl groupPersistence;

	@Autowired
	public AttachmentLocalServiceImpl attachmentLocalService;
	@Autowired
	public CategoryLocalServiceImpl categoryLocalService;

	public long addGroup(Group group) {
		return groupPersistence.insert(group);
	}

	public Group getGroup(long groupId) {
		return groupPersistence.findByPrimaryKey(groupId);
	}

	public List<Group> getGroups(long categoryId) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource(
			"categoryId", categoryId);

		return groupPersistence.getEntrys(namedParameters);
	}

	public void delete(long groupId) {
		groupPersistence.delete(groupId);
	}

	public void updateGroup(Group group) {
		groupPersistence.update(group);
	}

	public Pagination<Group> getPagination(long categoryId) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource(
			"categoryId", categoryId);

		return groupPersistence.getPagination(namedParameters);
	}

	public void deleteByCategory(long categoryId) {
		Category category = categoryLocalService.getCategory(categoryId);

		if (category.getType() == WebKey.CATEGORY_ATTACHMENT) {
			List<Group> groups = getGroups(categoryId);

			for (Group group : groups) {
				attachmentLocalService.deleteEntrys(group.getCategoryId());
			}
		}

		MapSqlParameterSource namedParameters = new MapSqlParameterSource(
			"categoryId", categoryId);

		groupPersistence.delete(namedParameters);
	}

	public void deleteGroup(long categoryId, long groupId) {
		Category category = categoryLocalService.getCategory(categoryId);

		if (category.getType() == WebKey.CATEGORY_ATTACHMENT) {
			attachmentLocalService.deleteEntrys(groupId);
		}

		groupPersistence.delete(groupId);
	}

}
