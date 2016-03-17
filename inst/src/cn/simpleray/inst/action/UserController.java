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
import cn.simpleray.inst.model.User;
import cn.simpleray.inst.service.UserLocalServiceImpl;

/**
 * @author Alan Zhang
 *
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {
	@Autowired
	public UserLocalServiceImpl userLocalService;

	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("user", new User());

		return "admin/user/edit_user";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addUser(@Valid User user, BindingResult result) {
		userLocalService.addUser(user);

		return "redirect:/admin/user/view";
	}

	@RequestMapping("/view")
	public String select(Model model) {
		Pagination<User> Pagination = userLocalService.getPagination();

		model.addAttribute("Pagination", Pagination);

		return "admin/user/view";
	}

	@RequestMapping(value="/update/{userId}", method=RequestMethod.GET)
	public String update(@PathVariable long userId, Model model) {
		User user = userLocalService.getUser(userId);

		model.addAttribute("user", user);

		return "admin/user/edit_user";
	}

	@RequestMapping(value="/update/{userId}", method=RequestMethod.POST)
	public String update(@PathVariable long userId, @Valid User user, BindingResult result) {
		user.setUserId(userId);

		userLocalService.updateUser(user);

		return "redirect:/admin/user/view";
	}

	@RequestMapping(value="/delete/{userId}",method=RequestMethod.GET)
	public String delete(@PathVariable long userId) {
		userLocalService.deleteUser(userId);

		return "redirect:/admin/user/view";
	}
}
