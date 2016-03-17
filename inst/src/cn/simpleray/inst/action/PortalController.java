/**
 * Copyright (c) 2000-2015 Alan Zhang. All rights reserved.
 */
package cn.simpleray.inst.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.simpleray.base.core.SystemContext;
import cn.simpleray.base.util.FileOperateUtil;
import cn.simpleray.base.util.Pagination;
import cn.simpleray.base.util.ParamUtil;
import cn.simpleray.base.util.WebKey;
import cn.simpleray.inst.model.Article;
import cn.simpleray.inst.model.Attachment;
import cn.simpleray.inst.model.Category;
import cn.simpleray.inst.model.Group;
import cn.simpleray.inst.model.Groups;
import cn.simpleray.inst.model.HireInfo;
import cn.simpleray.inst.model.Message;
import cn.simpleray.inst.model.Product;
import cn.simpleray.inst.model.ProductGroup;
import cn.simpleray.inst.service.ArticleLocalServiceImpl;
import cn.simpleray.inst.service.AttachmentLocalServiceImpl;
import cn.simpleray.inst.service.CategoryLocalServiceImpl;
import cn.simpleray.inst.service.GroupLocalServiceImpl;
import cn.simpleray.inst.service.HireInfoLocalServiceImpl;
import cn.simpleray.inst.service.MessageLocalServiceImpl;
import cn.simpleray.inst.service.ProductLocalServiceImpl;

/**
 * @author Alan Zhang
 *
 */
@Controller
@RequestMapping("/portal")
public class PortalController {
	@Autowired
	public ProductLocalServiceImpl productLocalService;
	@Autowired
	public CategoryLocalServiceImpl categoryLocalService;
	@Autowired
	public ArticleLocalServiceImpl articleLocalService;
	@Autowired
	public AttachmentLocalServiceImpl attachmentLocalService;
	@Autowired
	public HireInfoLocalServiceImpl hireInfoLocalService;
	@Autowired
	public GroupLocalServiceImpl groupLocalService;
	@Autowired
	public MessageLocalServiceImpl messageLocalService;

	@RequestMapping("/product")
	public String getProducts() {
		return "redirect:/portal/product/" + 0 +"?pagination.pageSize=9";
	}

	@RequestMapping("/search")
	public String search(HttpServletRequest request, Model model) {
		List<Category> categorys = categoryLocalService.getCategorys(
			WebKey.CATEGORY_PRODUCT);

		List<ProductGroup> productGroups = new ArrayList<ProductGroup>();

		for (Category category : categorys) {
			ProductGroup pg = new ProductGroup();

			List<Product> products = productLocalService.getProducts(
				category.getCategoryId());

			pg.setId(category.getCategoryId());
			pg.setName(category.getName());
			pg.setProducts(products);

			productGroups.add(pg);
		}

		model.addAttribute("productGroups", productGroups);


		String search = ParamUtil.getString(request, "search");

		SystemContext.setPageSize(9);

		Pagination<Product> pagination = productLocalService.search(search);

		model.addAttribute("pagination", pagination);

		model.addAttribute("search", search);

		addNavigate(model);

		return "/portal/product/view";
	}

	@RequestMapping("/product/{categoryId}")
	public String getProducts(@PathVariable long categoryId, Model model) {
		List<Category> categorys = categoryLocalService.getCategorys(
			WebKey.CATEGORY_PRODUCT);

		List<ProductGroup> productGroups = new ArrayList<ProductGroup>();

		for (Category category : categorys) {
			ProductGroup pg = new ProductGroup();

			List<Product> products = productLocalService.getProducts(
				category.getCategoryId());

			pg.setId(category.getCategoryId());
			pg.setName(category.getName());
			pg.setProducts(products);

			productGroups.add(pg);
		}

		model.addAttribute("productGroups", productGroups);

		Pagination<Product> pagination = null;

		if (categoryId == 0) {
			pagination = productLocalService.getPagination();
		}
		else {
			pagination = productLocalService.getPagination(categoryId);
		}

		model.addAttribute("pagination", pagination);

		model.addAttribute("categoryId", categoryId);

		addNavigate(model);

		return "/portal/product/view";
	}

	@RequestMapping("/product/{categoryId}/{productId}")
	public String getProducts(
		@PathVariable long categoryId, @PathVariable long productId,
		Model model) {

		List<Category> categorys = categoryLocalService.getCategorys(
			WebKey.CATEGORY_PRODUCT);

		List<ProductGroup> productGroups = new ArrayList<ProductGroup>();

		for (Category category : categorys) {
			ProductGroup pg = new ProductGroup();

			List<Product> products = productLocalService.getProducts(
				category.getCategoryId());

			pg.setId(category.getCategoryId());
			pg.setName(category.getName());
			pg.setProducts(products);

			productGroups.add(pg);
		}

		model.addAttribute("productGroups", productGroups);

		Product product = productLocalService.getProduct(productId);

		model.addAttribute("product", product);

		addNavigate(model);

		return "/portal/product/product_detail";
	}

	@RequestMapping("/article")
	public String getArticles(Model model) {
		return "redirect:/portal/articles/0";
	}

	@RequestMapping("/support")
	public String getSupportArticles(Model model) {
		return "redirect:/portal/supports/0";
	}

	@RequestMapping("/supports/{categoryId}")
	public String getSupportArticles(
		@PathVariable long categoryId, Model model) {

		List<Category> categorys = categoryLocalService.getCategorys(
			WebKey.CATEGORY_SUPPORT);

		model.addAttribute("categorys", categorys);

		Pagination<Article> pagination = null;

		if (categoryId == 0) {
			pagination = articleLocalService.getPagination(
				WebKey.CATEGORY_SUPPORT);
		}
		else {
			pagination = articleLocalService.getPagination(categoryId);
		}

		model.addAttribute("pagination", pagination);

		model.addAttribute("categoryId", categoryId);

		addNavigate(model);

		return "/portal/support/view";
	}

	@RequestMapping("/support/{articleId}")
	public String getSupportArticle(@PathVariable long articleId,
		Model model) {

		List<Category> categorys = categoryLocalService.getCategorys(
			WebKey.CATEGORY_SUPPORT);

		model.addAttribute("categorys", categorys);

		Article article = articleLocalService.getEntry(articleId);

		model.addAttribute("article", article);

		addNavigate(model);

		return "/portal/support/article_detail";
	}

	@RequestMapping("/articles/{categoryId}")
	public String getArticles(@PathVariable long categoryId, Model model) {
		List<Category> categorys = categoryLocalService.getCategorys(
			WebKey.CATEGORY_ARTICLE);

		model.addAttribute("categorys", categorys);



		Pagination<Article> pagination = null;

		if (categoryId == 0) {
			pagination = articleLocalService.getPagination(
				WebKey.CATEGORY_ARTICLE);
		}
		else {
			pagination = articleLocalService.getPagination(categoryId);
		}

		model.addAttribute("pagination", pagination);

		model.addAttribute("categoryId", categoryId);
		
		addNavigate(model);

		return "/portal/article/view";
	}

	@RequestMapping("/article/{articleId}")
	public String getArticle(@PathVariable long articleId, Model model) {
		List<Category> categorys = categoryLocalService.getCategorys(
			WebKey.CATEGORY_ARTICLE);

		model.addAttribute("categorys", categorys);

		Article article = articleLocalService.getEntry(articleId);

		model.addAttribute("article", article);

		addNavigate(model);

		return "/portal/article/article_detail";
	}

	@RequestMapping("/attachment")
	public String getAttachments() {
		return "redirect:/portal/attachments/0";
	}

	@RequestMapping("/recruitment")
	public String getHireInfo(Model model) {
		Pagination<HireInfo> pagination = hireInfoLocalService.getPagination();

		model.addAttribute("pagination", pagination);

		addNavigate(model);

		return "/portal/recruitment/view";
	}

	@RequestMapping("/recruitment/{hireInfoId}")
	public String getHireInfo(@PathVariable long hireInfoId, Model model) {
		HireInfo hireInfo = hireInfoLocalService.getHireInfo(hireInfoId);

		model.addAttribute("hireInfo", hireInfo);

		addNavigate(model);

		return "/portal/recruitment/recruitment_detail";
	}

	@RequestMapping("/attachments/{groupId}")
	public String getAttachments(@PathVariable long groupId, Model model) {
		List<Category> categorys = categoryLocalService.getCategorys(
			WebKey.CATEGORY_ATTACHMENT);

		List<Groups> categoryGroups = new ArrayList<Groups>();

		for (Category category : categorys) {
			Groups groups = new Groups();

			List<Group> subCategorys = groupLocalService.getGroups(
				category.getCategoryId());

			groups.setId(category.getCategoryId());
			groups.setName(category.getName());
			groups.setSubCategorys(subCategorys);

			categoryGroups.add(groups);
		}

		model.addAttribute("categoryGroups", categoryGroups);

		Pagination<Attachment> pagination = null;

		if (groupId == 0) {
			pagination = attachmentLocalService.getPagination(
				WebKey.CATEGORY_ATTACHMENT);
		}
		else {
			pagination = attachmentLocalService.getPagination(groupId);
		}

		model.addAttribute("pagination", pagination);

		model.addAttribute("groupId", groupId);

		addNavigate(model);

		return "/portal/attachment/view";
	}

	@RequestMapping("/attachments/category/{categoryId}")
	public String getAttachmentByCategorys(
		@PathVariable long categoryId, Model model) {

		List<Category> categorys = categoryLocalService.getCategorys(
			WebKey.CATEGORY_ATTACHMENT);

		List<Groups> categoryGroups = new ArrayList<Groups>();

		for (Category category : categorys) {
			Groups groups = new Groups();

			List<Group> subCategorys = groupLocalService.getGroups(
				category.getCategoryId());

			groups.setId(category.getCategoryId());
			groups.setName(category.getName());
			groups.setSubCategorys(subCategorys);

			categoryGroups.add(groups);
		}

		model.addAttribute("categoryGroups", categoryGroups);

		SystemContext.setPageSize(9);

		Pagination<Attachment> pagination =
			attachmentLocalService.getPaginationByCategory(categoryId) ;

		model.addAttribute("pagination", pagination);

		model.addAttribute("categoryId", categoryId);

		addNavigate(model);

		return "/portal/attachment/view";
	}

	@RequestMapping("/download/{attachmentId}")
	public String getAttachment(
			HttpServletRequest request, HttpServletResponse response,
			@PathVariable long attachmentId)
		throws Exception {

		Attachment attachment = attachmentLocalService.getEntry(attachmentId);

		FileOperateUtil.download(request, response, attachment.getFilePath(),
			"text/html;charset=utf-8", attachment.getFileName());

		return null;
	}

	@RequestMapping(value = "/message/add", method = RequestMethod.POST)
	public String addMessage(
		@Valid Message message, BindingResult result, Model model) {

		String tip = "留言添加成功 , 我们工作人员尽快和你联系 :)";

		try {
			messageLocalService.add(message);
		}
		catch (Exception e) {
		}

		model.addAttribute("tip", tip);

		addNavigate(model);

		return "portal/message/message_info";
	}

	@RequestMapping("/contact")
	public String getContact(Model model) {
		addNavigate(model);

		return "/portal/contact/view";
	}

	@RequestMapping("/message")
	public String getMessage(Model model) {
		addNavigate(model);

		return "/portal/message/view";
	}

	@RequestMapping("/company")
	public String getAbout1(Model model) {
		addNavigate(model);

		return "/portal/about/company";
	}
	@RequestMapping("/organization")
	public String getAbout2(Model model) {
		addNavigate(model);
		
		return "/portal/about/organization";
	}

	@RequestMapping("/culture")
	public String getAbout3(Model model) {
		addNavigate(model);
		
		return "/portal/about/culture";
	}

	@RequestMapping("/qualification")
	public String getAbout4(Model model) {
		addNavigate(model);
		
		return "/portal/about/qualification";
	}

	@RequestMapping("/qualification_1")
	public String getAbout5(Model model) {
		addNavigate(model);
		
		return "/portal/about/qualification_1";
	}

	@RequestMapping("/qualification_2")
	public String getAbout6(Model model) {
		addNavigate(model);
		
		return "/portal/about/qualification_2";
	}

	@RequestMapping("/qualification_3")
	public String getAbout7(Model model) {
		addNavigate(model);
		
		return "/portal/about/qualification_3";
	}

	@RequestMapping("/qualification_4")
	public String getAbout8(Model model) {
		addNavigate(model);
		
		return "/portal/about/qualification_4";
	}

	private void addNavigate(Model model) {
		List<Category> articleCategorys =
			categoryLocalService.getCategorys(WebKey.CATEGORY_ARTICLE);
		List<Category> supportCategorys =
			categoryLocalService.getCategorys(WebKey.CATEGORY_SUPPORT);
		List<Category> attachmentCategorys =
			categoryLocalService.getCategorys(WebKey.CATEGORY_ATTACHMENT);
		List<Category> productCategorys =
			categoryLocalService.getCategorys(WebKey.CATEGORY_PRODUCT);

		model.addAttribute("productCategorys", productCategorys);
		model.addAttribute("attachmentCategorys", attachmentCategorys);
		model.addAttribute("articleCategorys", articleCategorys);
		model.addAttribute("supportCategorys", supportCategorys);

	}
}
