package cn.simpleray.inst.persistence.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.simpleray.base.core.BasePersistenceImpl;
import cn.simpleray.inst.model.Product;

@Repository("productPersistence")
public class ProductPersistenceImpl extends BasePersistenceImpl<Product> {
	@Override
	public RowMapper<Product> getModelMapper() {
		return new ProductMapper();
	}

	private static final class ProductMapper implements RowMapper<Product> {
		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();

			product.setProductId(rs.getLong("productId"));
			product.setCategoryId(rs.getLong("categoryId"));
			product.setCreateDate(rs.getLong("createDate"));
			product.setCreateUserId(rs.getLong("createUserId"));
			product.setCreateUserName(rs.getString("createUserName"));
			product.setName(rs.getString("name"));
			product.setDetail(rs.getString("detail"));
			product.setDetail1(rs.getString("detail1"));
			product.setDetail2(rs.getString("detail2"));
			product.setMicro(rs.getString("micro"));
			product.setStatus(rs.getInt("status"));
			
			return product;
		}
	}
}
