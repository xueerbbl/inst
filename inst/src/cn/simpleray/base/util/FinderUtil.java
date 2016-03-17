package cn.simpleray.base.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class FinderUtil {
	public static String buildCountSql(
		String table, String joinSql, Collection<String> conditions) {

		StringBuilder sb = new StringBuilder(2);

		sb.append(buildCountSql(table));
		sb.append(joinSql);
		sb.append(buildConditionSql(QueryUtil.SQL_WHERE, conditions, true));

		return sb.toString();
	}

	public static String buildSearchCountSql(
		String table, Collection<String> conditions) {

		StringBuilder sb = new StringBuilder(2);

		sb.append(buildCountSql(table));
		sb.append(buildConditionSql(QueryUtil.SQL_WHERE, conditions,
			QueryUtil.SQL_LIKE));

		return sb.toString();
	}

	public static String buildDeleteSql(
		String table, Collection<String> conditions) {

		StringBuilder sb = new StringBuilder(2);

		sb.append(buildDeleteSql(table));
		sb.append(buildConditionSql(QueryUtil.SQL_WHERE, conditions, false));

		return sb.toString();
	}
	
	public static String buildSql(
		String table, List<String> colums, Collection<String> conditions) {

		return buildSql(
			table, colums, conditions, null, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	public static String buildSql(
		String table, List<String> colums, Collection<String> conditions,
		Map<String, Boolean> orders, int start, int end) {

		return buildSql(table, colums, "", conditions, orders, start, end);
	}

	public static String buildSql(
		String table, List<String> colums, String joinSql,
		Collection<String> conditions, Map<String, Boolean> orders, int start,
		int end) {

		StringBuilder sb = new StringBuilder(5);

		sb.append(buildSelectSql(table, colums));
		sb.append(joinSql);
		sb.append(buildConditionSql(QueryUtil.SQL_WHERE, conditions, true));
		sb.append(buildOrderBySql(orders));
		sb.append(buildPaginationSql(start, end));

		return sb.toString();
	}

	public static String buildSql(
		String table, List<String> colums, Collection<String> conditions,
		String keyHolder, Map<String, Boolean> orders, int start, int end) {

		StringBuilder sb = new StringBuilder(5);

		sb.append(buildSelectSql(table, colums));
		sb.append(buildConditionSql(QueryUtil.SQL_WHERE, conditions, keyHolder));
		sb.append(buildOrderBySql(orders));
		sb.append(buildPaginationSql(start, end));

		return sb.toString();
	}

	public static String buildUpdateSql(
		String table,Collection<String> colums, Collection<String> conditions) {

		StringBuilder sb = new StringBuilder(2);

		sb.append(buildUpdateSql(table, colums));
		sb.append(buildConditionSql(QueryUtil.SQL_WHERE, conditions, true));

		return sb.toString();
	}

	private static String buildConditionSql(
		String connecter, Collection<String> conditions,
		String keyHolder) {

		if ((conditions == null) || (conditions.size() == 0)) {
			return QueryUtil.BLANK;
		}

		StringBuilder sb = new StringBuilder(conditions.size() * 4 + 1);

		sb.append(connecter);

		for (String condition : conditions) {
			sb.append(condition);

			sb.append(keyHolder);
			sb.append(QueryUtil.SQL_COLON);
			sb.append(condition);
			
			sb.append(QueryUtil.SQL_OR);
		}

		String conditionSql = sb.toString();
		
		return conditionSql.substring(0, (conditionSql.length() - 4));
	}

	private static String buildConditionSql(
		String connecter, Collection<String> conditions,
		boolean namedParameter) {

		if ((conditions == null) || (conditions.size() == 0)) {
			return QueryUtil.BLANK;
		}

		StringBuilder sb = new StringBuilder(conditions.size() * 4 + 1);

		if (!namedParameter) {
			sb = new StringBuilder(conditions.size() * 3 + 1);
		}

		sb.append(connecter);

		for (String condition : conditions) {
			sb.append(condition);

			if (namedParameter) {
				sb.append(QueryUtil.SQL_EQUAL_COLON);
				sb.append(condition);
			}
			else {
				sb.append(QueryUtil.SQL_EQUAL_QUESTION);
			}

			sb.append(QueryUtil.SQL_AND);
		}

		String conditionSql = sb.toString();
		
		return conditionSql.substring(0, (conditionSql.length() - 4));
	}

	private static String buildCountSql(String table) {
		StringBuilder sb = new StringBuilder(4);

		sb.append(QueryUtil.SQL_SELECT);
		sb.append(QueryUtil.SQL_COUNT);
		sb.append(QueryUtil.SQL_FROM);
		sb.append(table);

		return sb.toString();
	}

	private static String buildDeleteSql(String table) {
		StringBuilder sb = new StringBuilder(3);

		sb.append(QueryUtil.SQL_DELETE);
		sb.append(QueryUtil.SQL_FROM);
		sb.append(table);

		return sb.toString();
	}

	private static String buildOrderBySql(Map<String, Boolean> orders) {
		if (orders == null) {
			return QueryUtil.BLANK;
		}

		StringBuilder sb = new StringBuilder(orders.size() * 4 + 1);

		sb.append(QueryUtil.SQL_ORDER_BY);

		for (String order : orders.keySet()) {
			sb.append(order);
			sb.append(QueryUtil.SPACE);

			if (orders.get(order)) {
				sb.append(QueryUtil.ASC);
			}
			else {
				sb.append(QueryUtil.DESC);
			}

			sb.append(QueryUtil.COMMA);
		}

		String orderBySql = sb.toString();
		
		return orderBySql.substring(0, (orderBySql.length() - 1));
	}

	private static String buildPaginationSql(int start, int end) {
		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS)) {
			return QueryUtil.BLANK;
		}

		StringBuilder sb = new StringBuilder(4);

		sb.append(QueryUtil.SQL_LIMIT);
		sb.append(start);
		sb.append(QueryUtil.COMMA);
		sb.append(end - start);

		return sb.toString();
	}

	private static String buildSelectSql(String table, List<String> columns) {
		String selectColumns = Util.merge(columns, table.concat("."));

		StringBuilder sb = new StringBuilder(4);

		sb.append(QueryUtil.SQL_SELECT);
		sb.append(selectColumns);
		sb.append(QueryUtil.SQL_FROM);
		sb.append(table);

		return sb.toString();
	}

	private static String buildUpdateSql(
		String table, Collection<String> columns) {

		StringBuilder sb = new StringBuilder(3 + columns.size() * 4);

		sb.append(QueryUtil.SQL_UPDATE);
		sb.append(table);
		sb.append(QueryUtil.SQL_SET);

		for (String condition : columns) {
			sb.append(condition);
			sb.append(QueryUtil.SQL_EQUAL_COLON);
			sb.append(condition);
			sb.append(QueryUtil.COMMA);
		}

		String sql = sb.toString();

		return sql.substring(0, (sql.length() - 1));
	}
}