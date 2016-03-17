/**
 * Copyright (c) 2000-2015 Inst.Inc. All rights reserved.
 *
 */
package cn.simpleray.inst.model;

import java.util.List;

/**
 * @author Alan Zhang
 * 
 */
public class ProductGroup {
	private long id;

	private String name;

	private List<Product> products;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}