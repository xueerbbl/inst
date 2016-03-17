package cn.simpleray.inst.persistence.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.simpleray.base.core.BasePersistenceImpl;
import cn.simpleray.inst.model.HireInfo;

@Repository("hireInfoPersistence")
public class HireInfoPersistenceImpl extends BasePersistenceImpl<HireInfo> {
	@Override
	public RowMapper<HireInfo> getModelMapper() {
		return new HireInfoMapper();
	}

	private static final class HireInfoMapper implements RowMapper<HireInfo> {
		@Override
		public HireInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			HireInfo hireInfo = new HireInfo();

			hireInfo.setCreateDate(rs.getLong("createDate"));
			hireInfo.setDescription(rs.getString("description"));
			hireInfo.setHireInfoId(rs.getLong("hireInfoId"));
			hireInfo.setLocation(rs.getString("location"));
			hireInfo.setNumber(rs.getInt("number"));
			hireInfo.setStatus(rs.getInt("status"));
			hireInfo.setTitle(rs.getString("title"));
			
			return hireInfo;
		}
	}
}
