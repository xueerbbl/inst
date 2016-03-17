package cn.simpleray.base.util;

public class Constants {

	/* 系统内部编码 */
	public static final String ENCODING = "UTF-8";


	/* 异常信息在上下文中的存储值 */
	public static final String CONTEXT_EXCEPTION = "_exception_";
	public static final String CONTEXT_EXCEPTION_INFO = "_exception_info_";

	/* 默认分页尺寸及分页标记 */
	public static final int DEFAULT_PAGE_SIZE = 18;
	public static final int MAX_PAGE_SIZE = 1000;
	public static final String START_MARK = ":_START_INDEX_";
	public static final String END_MARK = ":_END_INDEX_";

	/* 记录返回页面地址用的session key */
	public static final String REFER_URL = "_REFER_URL_";
	public static final String REFER_URL_DEFAULT_KEY = "_REFER_URL_DEFAULT_KEY_";

	/* 登录后用户信息在Session中的Key */
	public static final String LOGIN_USER = "_LOGIN_USER_";

	/* 记录用户登录前想要访问的地址在Session中的Key */
	public static final String ORIGINAL_URL = "_ORIGINAL_URL_";
}