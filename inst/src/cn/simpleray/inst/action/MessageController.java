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
import cn.simpleray.inst.model.Message;
import cn.simpleray.inst.service.MessageLocalServiceImpl;

/**
 * @author Alan Zhang
 * 
 */
@Controller
@RequestMapping("/admin/message")
public class MessageController {
	@Autowired
	public MessageLocalServiceImpl messageLocalService;

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(Model model) {
		Pagination<Message> pagination = messageLocalService.getPagination();

		model.addAttribute("pagination", pagination);

		return "admin/message/view";
	}

	@RequestMapping(value = "/update/{messageId}", method = RequestMethod.POST)
	public String updateMessage(
		@PathVariable long messageId, @Valid Message message, BindingResult result) {

		messageLocalService.updateMessage(messageId, message.getStatus());

		return "redirect:/admin/message/view";
	}

	@RequestMapping(value = "/view/{messageId}", method = RequestMethod.GET)
	public String view(@PathVariable long messageId, Model model) {

		Message message = messageLocalService.getEntry(messageId);

		model.addAttribute("message", message);

		return "admin/message/edit_message";
	}

	@RequestMapping(value = "/delete/{messageId}", method = RequestMethod.GET)
	public String delete(@PathVariable long messageId) {
		messageLocalService.delete(messageId);

		return "redirect:/admin/message/view";
	}
}
