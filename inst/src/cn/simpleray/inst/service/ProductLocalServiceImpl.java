/**
 * Copyright (c) 2000-2015 Inst.Inc. All rights reserved.
 *
 */
package cn.simpleray.inst.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.simpleray.base.core.BaseServiceImpl;
import cn.simpleray.base.util.FileOperateUtil;
import cn.simpleray.base.util.Pagination;
import cn.simpleray.base.util.QueryUtil;
import cn.simpleray.inst.model.Product;
import cn.simpleray.inst.persistence.impl.ProductPersistenceImpl;

/**
 * @author Alan Zhang
 * 
 */
@Service("productService")
public class ProductLocalServiceImpl extends BaseServiceImpl {
	@Autowired
	public ProductPersistenceImpl productPersistence;

	public long addProduct(Product product, MultipartFile file)
		throws Exception {

		if ((file != null) && (!file.isEmpty())) {
			product.setMicro(FileOperateUtil.upload(file));
		}

		product.setCreateDate(new Date().getTime());

		return productPersistence.insert(product);
	}

	public List<Product> getProducts() {
		return productPersistence.getEntrys();
	}

	public Product getProduct(long productId) {
		return productPersistence.findByPrimaryKey(productId);
	}

	public void delete(long productId) {
		productPersistence.delete(productId);
	}

	public void update(Product product) {
		productPersistence.update(product);
	}

	public List<Product> getProducts(long categoryId) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource(
			"categoryId", categoryId);

		return productPersistence.getEntrys(namedParameters);
	}

	public Pagination<Product> getPagination() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		return productPersistence.getPagination(namedParameters);
	}

	public Pagination<Product> getPagination(long categoryId) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource(
			"categoryId", categoryId);

		return productPersistence.getPagination(namedParameters);
	}

	public List<Product> getTopProducts() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("status", 1);

		Map<String, Boolean> orders = new HashMap<String, Boolean>();

		orders.put("productId", false);

		return productPersistence.getEntrys(namedParameters, orders, 0, 10);
	}

	public Product updateProduct(
			long productId, String name, int status, MultipartFile file, String detail,
			String detail1, String detail2)
		throws Exception {

		Product product = productPersistence.findByPrimaryKey(productId);

		if ((file != null) && (!file.isEmpty())) {
			FileOperateUtil.delete(product.getMicro());

			product.setMicro(FileOperateUtil.upload(file));
		}

		product.setName(name);
		product.setStatus(status);
		product.setDetail(detail);
		product.setDetail1(detail1);
		product.setDetail2(detail2);

		productPersistence.update(product);

		return product;
	}

	public void deleteEntrys(long categoryId) {
		List<Product> products = getProducts(categoryId);

		for (Product product : products) {
			delete(product.getProductId());
		}
	}

	public Pagination<Product> search(String search) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		namedParameters.addValue("name", QueryUtil.getLike(search));
		namedParameters.addValue("detail", QueryUtil.getLike(search));
		namedParameters.addValue("detail1", QueryUtil.getLike(search));
		namedParameters.addValue("detail2", QueryUtil.getLike(search));

		return productPersistence.search(namedParameters);
	}
}
