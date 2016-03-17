/**
 * Copyright (c) 2000-2015 Inst.Inc. All rights reserved.
 *
 */
package cn.simpleray.inst.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import cn.simpleray.base.util.Pagination;
import cn.simpleray.inst.model.HireInfo;
import cn.simpleray.inst.persistence.impl.HireInfoPersistenceImpl;

/**
 * @author Alan.Zhang
 *
 */
@Service("hireInfoService")
public class HireInfoLocalServiceImpl {

	@Autowired
	public HireInfoPersistenceImpl hireInfoPersistence;

	public long addHireInfo(HireInfo hireInfo) {
		hireInfo.setCreateDate(new Date().getTime());

		return hireInfoPersistence.insert(hireInfo);
	}

	public void deleteHireInfo(long hireInfoId) {
		hireInfoPersistence.delete(hireInfoId);		
	}

	public HireInfo getHireInfo(long hireInfoId) {
		return hireInfoPersistence.findByPrimaryKey(hireInfoId);
	}

	public Pagination<HireInfo> getPagination() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		return hireInfoPersistence.getPagination(namedParameters);
	}

	public HireInfo updateHireInfo(
		long hireInfoId, String title, int number, String location, int status,
		String description) {

		HireInfo hireInfo = getHireInfo(hireInfoId);

		hireInfo.setTitle(title);
		hireInfo.setNumber(number);
		hireInfo.setLocation(location);
		hireInfo.setStatus(status);
		hireInfo.setDescription(description);

		hireInfoPersistence.update(hireInfo);

		return hireInfo;
	}

}
