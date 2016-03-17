package cn.simpleray.base.core;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import cn.simpleray.base.core.annotation.Ignore;
import cn.simpleray.base.core.annotation.Table;
import cn.simpleray.base.util.FinderUtil;
import cn.simpleray.base.util.Pagination;
import cn.simpleray.base.util.QueryUtil;

/**
 * @author Alan Zhang
 */
public abstract class BasePersistenceImpl<T>
	extends NamedParameterJdbcDaoSupport implements BasePersistence<T> {

	public NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private Class<T> clazz;

	private List<String> colums;

	private SimpleJdbcInsert simpleJdbcInsert;

	private Table table;

	@Override
	public void delete(long primaryKey) {
		List<String> parems = new ArrayList<String>();

		parems.add(getTable().pk());

		String sql = FinderUtil.buildDeleteSql(getTable().table(), parems);

		getJdbcTemplate().update(sql, primaryKey);
	}

	public void delete(MapSqlParameterSource namedParameters) {
		Set<String> conditions = namedParameters.getValues().keySet();

		String sql = FinderUtil.buildDeleteSql(getTable().table(), conditions);

		getJdbcTemplate().update(sql, namedParameters.getValues().values());
	}

	@Override
	public T findByPrimaryKey(long primaryKey) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource(
			getTable().pk(), primaryKey);

		return getEntry(namedParameters);
	}

	public T getEntry(MapSqlParameterSource namedParameters) {
		Set<String> conditions = namedParameters.getValues().keySet();

		String sql = FinderUtil.buildSql(
			getTable().table(), getColums(), conditions);

		T model = null;

		try {
			model = namedParameterJdbcTemplate.queryForObject(
				sql, namedParameters, getModelMapper());
		}
		catch (DataAccessException e) {
		}

		return model;
	}

	public List<T> getEntrys() {
		String sql = FinderUtil.buildSql(getTable().table(), getColums(), null);

		return namedParameterJdbcTemplate.query(sql, getModelMapper());
	}

	public List<T> getEntrys(MapSqlParameterSource namedParameters) {
		return getEntrys(namedParameters, null);
	}

	public List<T> getEntrys(
		MapSqlParameterSource namedParameters, Map<String, Boolean> orders) {

		return getEntrys(
			namedParameters, orders, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<T> getEntrys(
		MapSqlParameterSource namedParameters, Map<String, Boolean> orders,
		int start, int end) {

		return getEntrys(namedParameters, "", orders, start, end);
	}

	public List<T> getEntrys(
		MapSqlParameterSource namedParameters, String joinSql,
		Map<String, Boolean> orders, int start, int end) {

		Collection<String> conditions = namedParameters.getValues().keySet();

		String sql = FinderUtil.buildSql(
			getTable().table(), getColums(), joinSql, conditions, orders,
			start, end);

		return namedParameterJdbcTemplate.query(
			sql, namedParameters, getModelMapper());
	}

	public abstract RowMapper<T> getModelMapper();

	public Pagination<T> getPagination(MapSqlParameterSource namedParameters) {

		Pagination<T> pagination = getPagination();

		Collection<String> conditions = namedParameters.getValues().keySet();

		pagination.setTotal(selectCount(namedParameters, ""));

		String sql = FinderUtil.buildSql(
			getTable().table(), getColums(), conditions, pagination.getOrder(),
			pagination.getStart(), pagination.getEnd());

		List<T> models = namedParameterJdbcTemplate.query(
			sql, namedParameters, getModelMapper());

		pagination.setEntrys(models);

		return pagination;
	}

	public Pagination<T> search(MapSqlParameterSource namedParameters) {
		Pagination<T> pagination = getPagination();

		Collection<String> conditions = namedParameters.getValues().keySet();

		pagination.setTotal(searchCount(namedParameters));

		String sql = FinderUtil.buildSql(
			getTable().table(), getColums(), conditions,
			QueryUtil.SQL_LIKE, pagination.getOrder(),
			pagination.getStart(), pagination.getEnd());

		List<T> models = namedParameterJdbcTemplate.query(
			sql, namedParameters, getModelMapper());

		pagination.setEntrys(models);

		return pagination;
	}

	public Pagination<T> getPagination(
		String joinSql, MapSqlParameterSource namedParameters) {

		Pagination<T> pagination = getPagination();

		Collection<String> conditions = namedParameters.
			getValues().keySet();

		pagination.setTotal(selectCount(new MapSqlParameterSource(), joinSql));

		String sql = FinderUtil.buildSql(
			getTable().table(), getColums(), joinSql, conditions,
			pagination.getOrder(), pagination.getStart(), pagination.getEnd());

		List<T> models = namedParameterJdbcTemplate.query(
			sql, namedParameters, getModelMapper());

		pagination.setEntrys(models);

		return pagination;
	}

	@Override
	public void update(T model) {
		List<String> parems = new ArrayList<String>();

		parems.add(getTable().pk());

		String sql = FinderUtil.buildUpdateSql(
			getTable().table(), getUpdateColums(), parems);

		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(
			model);

		namedParameterJdbcTemplate.update(sql, paramSource);
	}

	public void update(List<String> colums, MapSqlParameterSource namedParameters) {
		Collection<String> conditions = namedParameters.getValues().keySet();

		String sql = FinderUtil.buildUpdateSql(
			getTable().table(), colums, conditions);

		namedParameterJdbcTemplate.update(sql, namedParameters);
	}

	private Pagination<T> getPagination() {
		Pagination<T> pagination = new Pagination<T>();

		pagination.setOrder(SystemContext.getOrder());
		pagination.setPageNum(SystemContext.getPageNum());
		pagination.setPageSize(SystemContext.getPageSize());

		return pagination;
	}

	public long insert(T model) {
		SqlParameterSource parameters = new BeanPropertySqlParameterSource(
			model);

	    Number newId = getSimpleJdbcInsert().executeAndReturnKey(parameters);

		return newId.longValue();
	}

	public int selectCount(MapSqlParameterSource namedParameters, String joinsql) {
		Collection<String> conditions = namedParameters.getValues().keySet();

		String sql = FinderUtil.buildCountSql(
			getTable().table(), joinsql, conditions);

		return namedParameterJdbcTemplate.queryForObject(
			sql, namedParameters, Integer.class);
	}

	public int searchCount(MapSqlParameterSource namedParameters) {
		Collection<String> conditions = namedParameters.getValues().keySet();

		String sql = FinderUtil.buildSearchCountSql(
			getTable().table(), conditions);

		return namedParameterJdbcTemplate.queryForObject(
			sql, namedParameters, Integer.class);
	}

    @Autowired
    public void setDataSource(BasicDataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
        	dataSource);

        super.setDataSource(dataSource);
    }

	public void update(String sql, T model) {
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(
			model);

		namedParameterJdbcTemplate.update(sql, paramSource);
	}

	@SuppressWarnings("unchecked")
	private Class<T> getclazz() {
		if (clazz == null) {
			ParameterizedType parameterizedType =
				(ParameterizedType) this.getClass().getGenericSuperclass();

			clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		}

		return clazz;
	}

	private List<String> getUpdateColums() {
		List<String> colums = new ArrayList<String>(getColums());

		colums.remove(getTable().pk());

		return colums;
	}

	private List<String> getColums() {
		if (colums != null) {
			return colums;
		}

		List<String> colums = new ArrayList<String>();

		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			Ignore ignore = field.getAnnotation(Ignore.class);

			if (ignore != null) {
				continue;
			}

			colums.add(field.getName());
		}

		return colums;
	}

	private SimpleJdbcInsert getSimpleJdbcInsert() {
		if (simpleJdbcInsert != null) {
			return simpleJdbcInsert;
		}

		simpleJdbcInsert = new SimpleJdbcInsert(getJdbcTemplate());

		simpleJdbcInsert.setTableName(getTable().table());
		simpleJdbcInsert.setGeneratedKeyName(getTable().pk());

		return simpleJdbcInsert;
	}

	private Table getTable() {
		if (table != null) {
			return this.table;
		}

		table = (Table)getclazz().getAnnotation(Table.class);

		return table;
	}
}
