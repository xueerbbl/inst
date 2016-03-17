package cn.simpleray.base.util;

import java.util.List;

public class Util {
	/**
	 * Converts the first character of the string to upper case.
	 *
	 * @param  s the string whose first character is to be converted
	 * @return the string, with its first character converted to upper-case
	 */
	public static String upperCaseFirstLetter(String s) {
		char[] chars = s.toCharArray();

		if ((chars[0] >= 65) && (chars[0] <= 90)) {
			chars[0] = (char)(chars[0] + 32);
		}

		return new String(chars);
	}

	public static String merge(List<String> list) {
		if ((list == null) || (list.size() == 0)) {
			return null;
		}

		StringBuilder sb = new StringBuilder(2 * list.size() - 1);

		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).trim());

			if ((i + 1) != list.size()) {
				sb.append(QueryUtil.COMMA);
			}
		}

		return sb.toString();
	}

	public static String merge(List<String> list, String pre) {
		if ((list == null) || (list.size() == 0)) {
			return null;
		}

		StringBuilder sb = new StringBuilder(3 * list.size() - 1);

		for (int i = 0; i < list.size(); i++) {
			sb.append(pre);
			sb.append(list.get(i).trim());

			if ((i + 1) != list.size()) {
				sb.append(QueryUtil.COMMA);
			}
		}

		return sb.toString();
	}
}
