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
import cn.simpleray.inst.model.Category;
import cn.simpleray.inst.model.Group;
import cn.simpleray.inst.service.AttachmentLocalServiceImpl;
import cn.simpleray.inst.service.CategoryLocalServiceImpl;
import cn.simpleray.inst.service.GroupLocalServiceImpl;

/**
 * @author Alan Zhang
 *
 */
@Controller
@RequestMapping("/admin/group")
public class GroupController {
	@Autowired
	public AttachmentLocalServiceImpl attachmentLocalService;
	@Autowired
	public CategoryLocalServiceImpl categoryLocalService;
	@Autowired
	public GroupLocalServiceImpl groupLocalService;

	@RequestMapping(value="/add/{categoryId}",method=RequestMethod.GET)
	public String add(@PathVariable long categoryId, Model model) {
		Category category = categoryLocalService.getCategory(categoryId);

		model.addAttribute("group", new Group());
		model.addAttribute("categoryId", categoryId);
		model.addAttribute("category", category);

		return "admin/group/edit_group";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Valid Group group, BindingResult result)
		throws Exception {

		groupLocalService.addGroup(group);

		return "redirect:/admin/group/" + group.getCategoryId();
	}

	@RequestMapping(value="/delete/{groupId}", method=RequestMethod.GET)
	public String delete(@PathVariable long groupId) {
		Group group = groupLocalService.getGroup(groupId);

		groupLocalService.deleteGroup(group.getCategoryId(), groupId);

		return "redirect:/admin/group/" + group.getCategoryId();
	}

	@RequestMapping("/{categoryId}")
	public String view(@PathVariable long categoryId, Model model) {
		Category category = categoryLocalService.getCategory(categoryId);

		Pagination<Group> pagination =
			groupLocalService.getPagination(categoryId);

		model.addAttribute("pagination", pagination);
		model.addAttribute("categoryId", categoryId);
		model.addAttribute("type", category.getType());

		return "admin/group/view";
	}

	@RequestMapping(value="/update/{groupId}", method=RequestMethod.POST)
	public String update(
		@PathVariable long groupId, @Valid Group group, BindingResult result) {

		group.setGroupId(groupId);

		groupLocalService.updateGroup(group);

		return "redirect:/admin/group/" + group.getCategoryId();
	}

	@RequestMapping(value="/update/{groupId}", method=RequestMethod.GET)
	public String update(@PathVariable long groupId, Model model) {
		Group group = groupLocalService.getGroup(groupId);

		Category category = categoryLocalService.getCategory(
			group.getCategoryId());

		model.addAttribute("group", group);
		model.addAttribute("category", category);

		return "admin/group/edit_group";
	}
}
