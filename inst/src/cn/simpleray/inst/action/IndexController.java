/**
 * Copyright (c) 2000-2015 Alan Zhang. All rights reserved.
 */
package cn.simpleray.inst.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.simpleray.base.util.WebKey;
import cn.simpleray.inst.model.Article;
import cn.simpleray.inst.model.Category;
import cn.simpleray.inst.model.Product;
import cn.simpleray.inst.service.ArticleLocalServiceImpl;
import cn.simpleray.inst.service.AttachmentLocalServiceImpl;
import cn.simpleray.inst.service.CategoryLocalServiceImpl;
import cn.simpleray.inst.service.ProductLocalServiceImpl;

/**
 * @author Alan Zhang
 *
 */
@Controller
public class IndexController {
	@Autowired
	public ProductLocalServiceImpl productLocalService;
	@Autowired
	public CategoryLocalServiceImpl categoryLocalService;
	@Autowired
	public ArticleLocalServiceImpl articleLocalService;
	@Autowired
	public AttachmentLocalServiceImpl attachmentLocalService;

	@RequestMapping({"/", "/index", "/portal/index"})
	public String views(Model model) {
		List<Article> articles = articleLocalService.getTopArticles(
			WebKey.CATEGORY_ARTICLE);
		List<Article> supportArticles = articleLocalService.getTopArticles(
			WebKey.CATEGORY_SUPPORT);
		List<Product> products = productLocalService.getTopProducts();

		model.addAttribute("articles", articles);
		model.addAttribute("supportArticles", supportArticles);
		model.addAttribute("products", products);

		List<Category> articleCategorys =
			categoryLocalService.getCategorys(WebKey.CATEGORY_ARTICLE);

		model.addAttribute("articleCategorys", articleCategorys);

		List<Category> supportCategorys =
			categoryLocalService.getCategorys(WebKey.CATEGORY_SUPPORT);

		model.addAttribute("supportCategorys", supportCategorys);

		List<Category> attachmentCategorys =
			categoryLocalService.getCategorys(WebKey.CATEGORY_ATTACHMENT);

		model.addAttribute("attachmentCategorys", attachmentCategorys);

		List<Category> productCategorys =
			categoryLocalService.getCategorys(WebKey.CATEGORY_PRODUCT);

		model.addAttribute("productCategorys", productCategorys);

		return "/portal/index";
	}

}
