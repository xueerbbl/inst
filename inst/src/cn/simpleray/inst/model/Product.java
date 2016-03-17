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
@Table(table = "product", pk = "productId")
public class Product {

	private long categoryId;

	private long createDate;

	private long createUserId;

	private String createUserName;

	private String detail;

	private String detail1;

	private String detail2;

	private String micro;

	private String name;

	private long productId;

	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getCategoryId() {
		return categoryId;
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

	public String getDetail1() {
		return detail1;
	}

	public String getDetail2() {
		return detail2;
	}

	public String getMicro() {
		return micro;
	}

	public String getName() {
		return name;
	}

	public long getProductId() {
		return productId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
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

	public void setDetail1(String detail1) {
		this.detail1 = detail1;
	}

	public void setDetail2(String detail2) {
		this.detail2 = detail2;
	}

	public void setMicro(String micro) {
		this.micro = micro;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}
}
