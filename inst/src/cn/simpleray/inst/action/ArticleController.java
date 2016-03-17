/**
 * Copyright (c) 2000-2015 Alan Zhang. All rights reserved.
 */
package cn.simpleray.inst.action;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.simpleray.base.util.Pagination;
import cn.simpleray.inst.model.Article;
import cn.simpleray.inst.model.Category;
import cn.simpleray.inst.service.ArticleLocalServiceImpl;
import cn.simpleray.inst.service.CategoryLocalServiceImpl;

/**
 * @author Alan Zhang
 * 
 */
@Controller
@RequestMapping("/admin/article")
public class ArticleController {
	@Autowired
	public ArticleLocalServiceImpl articleLocalService;

	@Autowired
	public CategoryLocalServiceImpl categoryLocalService;

	@RequestMapping(value = "/{categoryId}/add", method = RequestMethod.GET)
	public String add(@PathVariable long categoryId, Model model) {
		model.addAttribute("article", new Article());

		Category category = categoryLocalService.getCategory(categoryId);

		model.addAttribute("category", category);

		return "admin/article/edit_article";
	}

	@RequestMapping(value = "/{categoryId}/add", method = RequestMethod.POST)
	public String add(@PathVariable long categoryId, @Valid Article article,
			BindingResult result) {

		articleLocalService.add(article);

		return "redirect:/admin/article/" + categoryId;
	}

	@RequestMapping("/{categoryId}")
	public String select(@PathVariable long categoryId, Model model) {
		Pagination<Article> pagination = articleLocalService.getPagination(
			categoryId);

		model.addAttribute("pagination", pagination);

		Category category = categoryLocalService.getCategory(categoryId);

		model.addAttribute("category", category);

		return "admin/article/view";
	}

	@RequestMapping("/{categoryId}/{articleId}")
	public String select(@PathVariable long categoryId,
			@PathVariable long articleId, Model model) {

		Article article = articleLocalService.getEntry(articleId);

		model.addAttribute("article", article);

		Category category = categoryLocalService.getCategory(categoryId);

		model.addAttribute("category", category);

		return "admin/article/article";
	}

	@RequestMapping(value = "/update/{articleId}", method = RequestMethod.GET)
	public String update(@PathVariable long articleId, Model model) {
		Article article = articleLocalService.getEntry(articleId);

		model.addAttribute("article", article);

		Category category = categoryLocalService.getCategory(
			article.getCategoryId());

		model.addAttribute("category", category);

		return "admin/article/edit_article";
	}

	@RequestMapping(value = "/update/{articleId}", method = RequestMethod.POST)
	public String update(@PathVariable long articleId, @Valid Article articleDTO,
			BindingResult result) {

		Article article = articleLocalService.update(
			articleId, articleDTO.getTitle(), articleDTO.getDetail());

		return "redirect:/admin/article/" + article.getCategoryId();
	}

	@RequestMapping(value = "/delete/{categoryId}/{articleId}", method = RequestMethod.GET)
	public String delete(@PathVariable long categoryId,
			@PathVariable long articleId, Model model) {

		articleLocalService.delete(articleId);

		model.addAttribute("categoryId", categoryId);

		return "redirect:/admin/article/" + categoryId;
	}
}
