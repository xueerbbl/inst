package cn.simpleray.inst.persistence.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.simpleray.base.core.BasePersistenceImpl;
import cn.simpleray.inst.model.Group;

@Repository("groupPersistence")
public class GroupPersistenceImpl extends BasePersistenceImpl<Group> {
	@Override
	public RowMapper<Group> getModelMapper() {
		return new GroupMapper();
	}

	private static final class GroupMapper implements RowMapper<Group> {
		@Override
		public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
			Group group = new Group();

			group.setGroupId(rs.getLong("groupId"));
			group.setCategoryId(rs.getLong("categoryId") );
			group.setName(rs.getString("name"));

			return group;
		}
	}

}
