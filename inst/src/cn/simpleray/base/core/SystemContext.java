package cn.simpleray.base.core;

import java.util.Map;

/**
 * 用来传递列表对象的ThreadLocal数据
 * 
 * @author Alan Zhang
 * 
 */
public class SystemContext {
	/**
	 * 列表的排序方式
	 */
	private static ThreadLocal<Map<String, Boolean>> order =
		new ThreadLocal<Map<String, Boolean>>();
	/**
	 * 分页的起始页
	 */
	private static ThreadLocal<Integer> pageNum = new ThreadLocal<Integer>();
	/**
	 * 分页大小
	 */
	private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();

	private static ThreadLocal<String> realPath = new ThreadLocal<String>();

	public static Map<String, Boolean> getOrder() {
		return order.get();
	}

	public static Integer getPageNum() {
		return pageNum.get();
	}

	public static Integer getPageSize() {
		return pageSize.get();
	}

	public static String getRealPath() {
		return realPath.get();
	}

	public static void removeOrder() {
		order.remove();
	}

	public static void removePageNum() {
		pageNum.remove();
	}

	public static void removePageSize() {
		pageSize.remove();
	}

	public static void removeRealPath() {
		realPath.remove();
	}

	public static void setOrder(Map<String, Boolean> order) {
		SystemContext.order.set(order);
	}

	public static void setPageNum(Integer pageNum) {
		SystemContext.pageNum.set(pageNum);
	}

	public static void setPageSize(Integer _pageSize) {
		pageSize.set(_pageSize);
	}

	public static void setRealPath(String _realPath) {
		SystemContext.realPath.set(_realPath);
	}

}