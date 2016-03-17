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
import cn.simpleray.inst.model.HireInfo;
import cn.simpleray.inst.service.HireInfoLocalServiceImpl;

/**
 * @author Alan Zhang
 * 
 */
@Controller
@RequestMapping("/admin/hireInfo")
public class HireInfoController {
	@Autowired
	public HireInfoLocalServiceImpl hireInfoLocalService;

	@RequestMapping("/view")
	public String view(Model model) {
		Pagination<HireInfo> pagination = hireInfoLocalService.getPagination();

		model.addAttribute("pagination", pagination);

		return "admin/hireInfo/view";
	}

	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addHireInfo(Model model) {
		model.addAttribute("hireInfo", new HireInfo()); 

		return "admin/hireInfo/edit_hireInfo";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addHireInfo(@Valid HireInfo hireInfo, BindingResult result) {
		hireInfoLocalService.addHireInfo(hireInfo);

		return "redirect:/admin/hireInfo/view";
	}

	@RequestMapping(value="/update/{hireInfoId}", method=RequestMethod.GET)
	public String updateHireInfo(@PathVariable long hireInfoId, Model model) {
		HireInfo hireInfo = hireInfoLocalService.getHireInfo(hireInfoId);

		model.addAttribute("hireInfo", hireInfo);

		return "admin/hireInfo/edit_hireInfo";
	}

	@RequestMapping(value="/update/{hireInfoId}", method=RequestMethod.POST)
	public String updateHireInfo(
		@PathVariable long hireInfoId, @Valid HireInfo hireInfo,
		BindingResult result) {

		hireInfoLocalService.updateHireInfo(
			hireInfoId, hireInfo.getTitle(), hireInfo.getNumber(),
			hireInfo.getLocation(), hireInfo.getStatus(),
			hireInfo.getDescription());

		return "redirect:/admin/hireInfo/view";
	}

	@RequestMapping(value="/delete/{hireInfoId}")
	public String deleteHireInfo(@PathVariable long hireInfoId) {
		hireInfoLocalService.deleteHireInfo(hireInfoId);

		return "redirect:/admin/hireInfo/view";
	}
}
