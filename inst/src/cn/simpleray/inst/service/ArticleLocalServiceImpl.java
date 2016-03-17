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

import cn.simpleray.base.util.Pagination;
import cn.simpleray.inst.model.Article;
import cn.simpleray.inst.model.Product;
import cn.simpleray.inst.persistence.impl.ArticlePersistenceImpl;

/**
 * @author Alan Zhang
 * 
 */
@Service("articleService")
public class ArticleLocalServiceImpl {
	@Autowired
	public ArticlePersistenceImpl articlePersistence;

	public long add(Article article) {
		article.setCreateDate(new Date().getTime());

		return articlePersistence.insert(article);
	}

	public void delete(long articleId) {
		articlePersistence.delete(articleId);
	}

	public Article getEntry(long primaryKey) {
		return articlePersistence.findByPrimaryKey(primaryKey);
	}

	public List<Article> getEntrys() {
		return articlePersistence.getEntrys();
	}

	public List<Article> getEntrys(long categoryId) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource(
			"categoryId", categoryId);

		return articlePersistence.getEntrys(namedParameters);
	}

	public List<Article> getTopArticles(int type) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource(
			"type", type);

		Map<String, Boolean> orders = new HashMap<String, Boolean>();

		orders.put("articleId", false);

		String joinSql =
			" JOIN category ON article.categoryId = category.categoryId ";

		return articlePersistence.getEntrys(
			namedParameters, joinSql, orders, 0, 7);
	}

	public Pagination<Article> getPagination(long categoryId) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource(
			"categoryId", categoryId);

		return articlePersistence.getPagination(namedParameters);
	}

	public Article update(long articleId, String title, String detail) {
		Article article = getEntry(articleId);

		article.setTitle(title);
		article.setDetail(detail);

		articlePersistence.update(article);

		return article;
	}

	public Pagination<Article> getPagination(int type) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource(
			"type", type);

		String joinSql =
			" JOIN category ON article.categoryId = category.categoryId ";

		return articlePersistence.getPagination(joinSql, namedParameters);
	}

	public void deleteEntrys(long categoryId) {
		List<Article> articles = getEntrys(categoryId);

		for (Article article : articles) {
			delete(article.getArticleId());
		}
	}
}
