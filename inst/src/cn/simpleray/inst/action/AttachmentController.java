/**
 * Copyright (c) 2000-2015 Alan Zhang. All rights reserved.
 */
package cn.simpleray.inst.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.simpleray.base.util.Pagination;
import cn.simpleray.base.util.ParamUtil;
import cn.simpleray.inst.model.Attachment;
import cn.simpleray.inst.model.Group;
import cn.simpleray.inst.service.AttachmentLocalServiceImpl;
import cn.simpleray.inst.service.CategoryLocalServiceImpl;
import cn.simpleray.inst.service.GroupLocalServiceImpl;

/**
 * @author Alan Zhang
 * 
 */
@Controller
@RequestMapping("/admin/attachment")
public class AttachmentController {
	@Autowired
	public AttachmentLocalServiceImpl attachmentLocalService;

	@Autowired
	public CategoryLocalServiceImpl categoryLocalService;

	@Autowired
	public GroupLocalServiceImpl groupLocalService;
	
	@RequestMapping(value = "/{groupId}/add", method = RequestMethod.GET)
	public String add(@PathVariable long groupId, Model model) {
		model.addAttribute("attachment", new Attachment());

		Group group = groupLocalService.getGroup(groupId);

		model.addAttribute("group", group);

		return "admin/attachment/edit_attachment";
	}

	@RequestMapping(value = "/{groupId}/add2", method = RequestMethod.GET)
	public String add2(@PathVariable long groupId, Model model) {
		model.addAttribute("attachment", new Attachment());

		Group group = groupLocalService.getGroup(groupId);

		model.addAttribute("group", group);

		return "admin/attachment/edit_attachment2";
	}

	@RequestMapping(value = "/{categoryId}/add", method = RequestMethod.POST)
	public String add(HttpServletRequest request, @PathVariable long categoryId)
		throws Exception {

        // 转型为MultipartHttpRequest：     
        MultipartHttpServletRequest multipartRequest =
        	(MultipartHttpServletRequest) request;     
        // 获得文件：     
        MultipartFile file = multipartRequest.getFile("file"); 

		attachmentLocalService.add(categoryId, new MultipartFile[]{file});

		return "redirect:/admin/attachment/" + categoryId;
	}

	@RequestMapping(value = "/{categoryId}/add2", method = RequestMethod.POST)
	public String add2(HttpServletRequest request, @PathVariable long categoryId)
		throws Exception {

		String fileName = request.getParameter("fileName");
		long fileSize = ParamUtil.getLong(request, "fileSize");
		String url = request.getParameter("url");

		attachmentLocalService.add(categoryId, fileName, fileSize, url);

		return "redirect:/admin/attachment/" + categoryId;
	}

	@RequestMapping("/{categoryId}")
	public String select(@PathVariable long categoryId, Model model) {
		Pagination<Attachment> pagination = attachmentLocalService.getPagination(
			categoryId);

		model.addAttribute("pagination", pagination);

		Group group = groupLocalService.getGroup(categoryId);

		model.addAttribute("group", group);

		return "admin/attachment/view";
	}

	@RequestMapping(value = "/delete/{categoryId}/{attachmentId}", method = RequestMethod.GET)
	public String delete(
		@PathVariable long categoryId, @PathVariable long attachmentId,
		Model model) {

		attachmentLocalService.delete(attachmentId);

		model.addAttribute("categoryId", categoryId);

		return "redirect:/admin/attachment/" + categoryId;
	}
}
