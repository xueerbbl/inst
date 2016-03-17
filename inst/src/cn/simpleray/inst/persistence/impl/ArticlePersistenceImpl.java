package cn.simpleray.inst.persistence.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import cn.simpleray.base.core.BasePersistenceImpl;
import cn.simpleray.base.util.Pagination;
import cn.simpleray.inst.model.Article;

@Repository("articlePersistence")
public class ArticlePersistenceImpl extends BasePersistenceImpl<Article> {

	@Override
	public RowMapper<Article> getModelMapper() {
		return new ArticleMapper();
	}

	private static final class ArticleMapper implements RowMapper<Article> {
		@Override
	    public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
			Article article = new Article();

			article.setArticleId(rs.getLong("articleId"));
			article.setCreateDate(rs.getLong("createDate"));
			article.setCreateUserId(rs.getLong("createUserId"));
			article.setCreateUserName(rs.getString("createUserName"));
			article.setDetail(rs.getString("detail"));
			article.setTitle(rs.getString("title"));
			article.setCategoryId(rs.getInt("categoryId"));

	        return article;
	    }
	}

}
