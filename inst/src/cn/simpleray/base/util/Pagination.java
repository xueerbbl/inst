package cn.simpleray.base.util;

import java.util.List;
import java.util.Map;

public class Pagination<T> {
	/**
	 * 总记录数
	 */
	private int total;

	private int pageCount = 1;

	/**
	 * 分页的大小
	 */
	private int pageSize = Constants.DEFAULT_PAGE_SIZE;

	/**
	 * 分页的起始页
	 */
	private int pageNum = 1;

	private int start = 1;

	private int end = 1;

	private Map<String, Boolean> order = null;

	/**
	 * 分页的数据
	 */
	private List<T> entrys;

	public int getTotal() {
		return total;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public List<T> getEntrys() {
		return entrys;
	}

	public void setTotal(int total) {
		this.total = total;

		initPagination();
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public void setEntrys(List<T> entrys) {
		this.entrys = entrys;
	}

	public Map<String, Boolean> getOrder() {
		return order;
	}

	public void setOrder(Map<String, Boolean> order) {
		this.order = order;
	}

	private void initPagination() {
		// 计算分页总数
		if ((total % pageSize) == 0) {
			pageCount = total / pageSize;
		} else {
			pageCount = total / pageSize + 1;
		}

		if (pageCount == 0) {
			pageCount = 1;
		}

		// 判断pageNum是否过界
		if (pageNum > pageCount && total != 0) {
			pageNum = pageCount;
		}

		// 计算起止记录
		start = (pageNum - 1) * pageSize;
		end = (pageNum) * pageSize;
	}

}
