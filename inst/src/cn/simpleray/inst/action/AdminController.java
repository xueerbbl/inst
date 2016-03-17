/**
 * Copyright (c) 2000-2015 Alan Zhang. All rights reserved.
 */
package cn.simpleray.inst.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.simpleray.inst.model.User;
import cn.simpleray.inst.service.UserLocalServiceImpl;

/**
 * @author Alan Zhang
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	public UserLocalServiceImpl userLocalService;

	@RequestMapping("/")
	public String index() {
		return "admin/index";
	}

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
		return "admin/login";
	}

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(String userName, String password, HttpSession session) {

		User user = userLocalService.getUser(userName, password);

		if (user != null) {
			session.setAttribute("user", user);

			return "redirect:/admin/";
		}

		return "admin/login";
	}
}
