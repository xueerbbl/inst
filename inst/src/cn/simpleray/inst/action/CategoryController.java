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
import cn.simpleray.base.util.WebKey;
import cn.simpleray.inst.model.Category;
import cn.simpleray.inst.service.ArticleLocalServiceImpl;
import cn.simpleray.inst.service.AttachmentLocalServiceImpl;
import cn.simpleray.inst.service.CategoryLocalServiceImpl;
import cn.simpleray.inst.service.ProductLocalServiceImpl;

/**
 * @author Alan Zhang
 *
 */
@Controller
@RequestMapping("/admin/category")
public class CategoryController {
	@Autowired
	public ArticleLocalServiceImpl articleLocalService;
	@Autowired
	public AttachmentLocalServiceImpl attachmentLocalService;
	@Autowired
	public CategoryLocalServiceImpl categoryLocalService;
	@Autowired
	public ProductLocalServiceImpl productLocalService;

	@RequestMapping(value="{type}/add",method=RequestMethod.GET)
	public String add(@PathVariable int type, Model model) {
		model.addAttribute("category", new Category());
		model.addAttribute("type", type);

		return "admin/category/edit_category";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addCategory(@Valid Category category, BindingResult result)
		throws Exception {

		categoryLocalService.addCategory(category);

		return "redirect:/admin/category/" + category.getType();
	}

	@RequestMapping(value="/delete/{type}/{categoryId}",method=RequestMethod.GET)
	public String delete(
		@PathVariable int type, @PathVariable long categoryId) {

		if (type == WebKey.CATEGORY_ATTACHMENT) {
			attachmentLocalService.deleteEntrys(categoryId);
		}
		else if (type == WebKey.CATEGORY_ARTICLE && (type == WebKey.CATEGORY_SUPPORT)) {
			articleLocalService.deleteEntrys(categoryId);
		}
		else if (type == WebKey.CATEGORY_PRODUCT) {
			productLocalService.deleteEntrys(categoryId);
		}

		categoryLocalService.delete(categoryId);

		return "redirect:/admin/category/" + type;
	}

	@RequestMapping("/{type}")
	public String select(@PathVariable int type, Model model) {
		Pagination<Category> pagination =
			categoryLocalService.getPagination(type);

		model.addAttribute("pagination", pagination);
		model.addAttribute("type", type);

		return "admin/category/view";
	}

	@RequestMapping(value="/update/{categoryId}", method=RequestMethod.POST)
	public String update(
		@PathVariable long categoryId, @Valid Category category,
		BindingResult result) {

		category.setCategoryId(categoryId);

		categoryLocalService.updateCategory(category);

		return "redirect:/admin/category/" + category.getType();
	}

	@RequestMapping(value="/update/{categoryId}", method=RequestMethod.GET)
	public String update(@PathVariable long categoryId, Model model) {
		Category category = categoryLocalService.getCategory(categoryId);

		model.addAttribute("category", category);
		model.addAttribute("type", category.getType());

		return "admin/category/edit_category";
	}
}
