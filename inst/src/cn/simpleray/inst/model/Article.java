/**
 * Copyright (c) 2000-2015 Inst.Inc. All rights reserved.
 *
 */
package cn.simpleray.inst.model;

import cn.simpleray.base.core.annotation.Table;

/**
 * @author Alan Zhang
 * 
 */
@Table(table = "article", pk = "articleId")
public class Article {
	public long getArticleId() {
		return articleId;
	}

	public long getCreateDate() {
		return createDate;
	}

	public long getCreateUserId() {
		return createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public String getDetail() {
		return detail;
	}

	public String getTitle() {
		return title;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}

	public void setCreateUserId(long createUserId) {
		this.createUserId = createUserId;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	private long articleId;

	private long createDate;

	private long createUserId;

	private String createUserName;

	private String detail;

	private String title;

	private int categoryId;
}
