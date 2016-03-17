/**
 * Copyright (c) 2000-2015 Alan Zhang. All rights reserved.
 */
package cn.simpleray.inst.action;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.simpleray.base.util.Pagination;
import cn.simpleray.inst.model.Product;
import cn.simpleray.inst.service.ProductLocalServiceImpl;

/**
 * @author Alan Zhang
 *
 */
@Controller
@RequestMapping("/admin/product")
public class ProductController {
	@Autowired
	public ProductLocalServiceImpl productLocalService;

	@RequestMapping(value="/{categoryId}/add",method=RequestMethod.GET)
	public String add(@PathVariable long categoryId, Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("categoryId", categoryId);

		return "admin/product/edit_product";
	}
	
	@RequestMapping(value="/{categoryId}/add",method=RequestMethod.POST)
	public String add(HttpServletRequest request, @PathVariable long categoryId,
		@Valid Product product, BindingResult result) throws Exception {

        // 转型为MultipartHttpRequest：     
        MultipartHttpServletRequest multipartRequest =
        	(MultipartHttpServletRequest) request;     
        // 获得文件：     
        MultipartFile file = multipartRequest.getFile("micro"); 

		productLocalService.addProduct(product, file);

		return "redirect:/admin/product/" + categoryId;
	}

	@RequestMapping("/{categoryId}")
	public String select(@PathVariable long categoryId, Model model) {
		Pagination<Product> pagination = productLocalService.getPagination(
			categoryId);

		model.addAttribute("pagination", pagination);
		model.addAttribute("categoryId", categoryId);

		return "admin/product/view";
	}

	@RequestMapping("/{categoryId}/{productId}")
	public String select(
		@PathVariable long categoryId, @PathVariable long productId,
		Model model) {

		Product product = productLocalService.getProduct(productId);

		model.addAttribute("product", product);
		model.addAttribute("categoryId", categoryId);

		return "admin/product/product";
	}

	@RequestMapping(value="/update/{productId}", method=RequestMethod.GET)
	public String update(@PathVariable long productId, Model model) {
		Product product = productLocalService.getProduct(productId);

		model.addAttribute("product", product);
		model.addAttribute("categoryId", product.getCategoryId());

		return "admin/product/edit_product";
	}

	@RequestMapping(value="/update/{productId}", method=RequestMethod.POST)
	public String update(
			HttpServletRequest request, @PathVariable long productId,
			@Valid Product product, BindingResult result)
		throws Exception {

        // 转型为MultipartHttpRequest：     
        MultipartHttpServletRequest multipartRequest =
        	(MultipartHttpServletRequest) request;     
        // 获得文件：     
        MultipartFile file = multipartRequest.getFile("micro"); 

		product = productLocalService.updateProduct(
			productId, product.getName(), product.getStatus(), file,
			product.getDetail(), product.getDetail1(), product.getDetail2());

		return "redirect:/admin/product/" + product.getCategoryId();
	}

	@RequestMapping(value="/delete/{categoryId}/{productId}",method=RequestMethod.GET)
	public String delete(
		@PathVariable long categoryId, @PathVariable long productId,
		Model model) {

		productLocalService.delete(productId);

		model.addAttribute("categoryId", categoryId);

		return "redirect:/admin/product/" + categoryId;
	}
}
