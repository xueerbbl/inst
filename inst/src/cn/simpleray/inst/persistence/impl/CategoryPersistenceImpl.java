package cn.simpleray.inst.persistence.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.simpleray.base.core.BasePersistenceImpl;
import cn.simpleray.inst.model.Category;

@Repository("categoryPersistence")
public class CategoryPersistenceImpl extends BasePersistenceImpl<Category> {
	@Override
	public RowMapper<Category> getModelMapper() {
		return new CategoryMapper();
	}

	private static final class CategoryMapper implements RowMapper<Category> {
		@Override
		public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
			Category category = new Category();

			category.setCategoryId(rs.getLong("categoryId"));
			category.setCreateDate(rs.getLong("createDate"));
			category.setCreateUserId(rs.getLong("createUserId"));
			category.setCreateUserName(rs.getString("createUserName"));
			category.setName(rs.getString("name"));
			category.setType(rs.getInt("type"));

			return category;
		}
	}

}
