package cn.simpleray.base.util;

public class QueryUtil {

	public static final int ALL_POS = -1;

	public static final String BLANK = "";

	public static final String COMMA = ",";

	public final static String SPACE = " ";

	public final static String SQL_AND = " and ";

	public final static String SQL_OR = " or ";

	public final static String SQL_LIKE = " like ";

	public final static String SQL_COUNT = " count(*) ";

	public final static String SQL_DELETE = "delete ";

	public final static String SQL_EQUAL = " = ";

	public final static String SQL_COLON = " :";

	public final static String SQL_EQUAL_COLON = " = :";

	public final static String SQL_EQUAL_QUESTION = " = ?";

	public final static String SQL_FROM = " from ";

	public final static String SQL_LIMIT = " limit ";

	public final static String SQL_ORDER_BY = " order by ";
	
	public final static String SQL_SELECT = "select ";

	public final static String SQL_SET = " set ";

	public final static String SQL_UPDATE = "update ";

	public final static String SQL_WHERE = " where ";

	public static final String ASC = "asc";

	public static final String DESC = "desc";

	public static final String getLike(String searchParam) {
		return "%" + searchParam + "%";
	}
}