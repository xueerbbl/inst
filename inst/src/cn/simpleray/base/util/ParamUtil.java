package cn.simpleray.base.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Alan Zhang
 */
public class ParamUtil {

	public static boolean getBoolean(HttpServletRequest request, String param) {
		return getBoolean(request, param, false);
	}

	public static boolean getBoolean(
		HttpServletRequest request, String param, boolean defaultValue) {

		String value = request.getParameter(param);

		if (value == null) {
			return defaultValue;
		}
		else {
			return Boolean.valueOf(value);
		}
	}

	public static int getInteger(HttpServletRequest request, String param) {
		return getInteger(request, param, 0);
	}

	public static int getInteger(
		HttpServletRequest request, String param, int defaultValue) {

		String value = request.getParameter(param);

		if (value == null) {
			return defaultValue;
		}
		else {
			return Integer.valueOf(value);
		}
	}

	public static long getLong(HttpServletRequest request, String param) {
		return getLong(request, param, 0);
	}

	public static long getLong(
		HttpServletRequest request, String param, long defaultValue) {

		String value = request.getParameter(param);

		if (value == null) {
			return defaultValue;
		}
		else {
			return Long.valueOf(value);
		}
	}

	public static String getString(HttpServletRequest request, String param) {
		return getString(request, param, "");
	}

	public static String getString(
		HttpServletRequest request, String param, String defaultValue) {

		String value = request.getParameter(param);

		if (value == null) {
			return defaultValue;
		}
		else {
			return value;
		}
	}

}