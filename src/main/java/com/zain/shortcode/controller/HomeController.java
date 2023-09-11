package com.zain.shortcode.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zain.shortcode.models.Report;
import com.zain.shortcode.services.Imp.ShortCodeServiceImp;

@Controller
public class HomeController {

	@Autowired
	ShortCodeServiceImp service;

	/**
	 * 
	 * View home page. Returns "home" view.
	 */
	@GetMapping({ "" })
	public String viewHomePage() {
		return "home";
	}

	/**
	 * Home page route. Returns "home" view and sets filter options.
	 */
	@RequestMapping(value = { "/", "/home" }, method = { RequestMethod.GET })
	public String home(Model model, Principal principal) {
		List<String> filterOptions = new ArrayList<>();
		filterOptions.add("Status");
		filterOptions.add("Segments");
		filterOptions.add("Classes");
		filterOptions.add("Additional Services");

		model.addAttribute("filterOptions", filterOptions);
		return "home";
	}

	@SuppressWarnings("deprecation")
	@RequestMapping({ "/setFilters" })
	@ResponseBody

	/**
	 * Sets filters from date range selection. Returns map of shortcode counts by
	 * status.
	 */
	public Object setFilters(@RequestParam(required = false) String filterOption, @RequestParam String from,
			@RequestParam String to) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = null, endDate = null;

		if (from == null || to == null)
			return null;
		else {
			try {
				startDate = formatter.parse(from);
				endDate = formatter.parse(to);
				endDate.setHours(23);
				endDate.setMinutes(59);
				endDate.setSeconds(59);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		Map<String, Integer> allInfo = this.service.getallshortcodebystatusanddates(startDate, endDate);
		return allInfo;
	}

	@SuppressWarnings("deprecation")
	@RequestMapping({ "/setadditionalFilters" })
	@ResponseBody

	/**
	 * Sets additional service filters from date range. Returns map of shortcode
	 * counts by additional service.
	 */
	public Object setaddtionalFilters(@RequestParam(required = false) String filterOption, @RequestParam String from,
			@RequestParam String to) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = null, endDate = null;

		if (from == null || to == null)
			return null;
		else {
			try {
				startDate = formatter.parse(from);
				endDate = formatter.parse(to);
				endDate.setHours(23);
				endDate.setMinutes(59);
				endDate.setSeconds(59);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		Map<String, Integer> allInfo = this.service.getallshortcodebyadditonalserviceanddates(startDate, endDate);
		System.out.println("setadditionalFilters" + allInfo);
		return allInfo;
	}

	@SuppressWarnings("deprecation")
	@RequestMapping({ "/setclassesFilters" })
	@ResponseBody

	/**
	 * 
	 * @setclassesFilters: Sets class filters from date range. Returns map of
	 *                     shortcode counts by class.
	 */
	public Object setclassesFilters(@RequestParam(required = false) String filterOption, @RequestParam String from,
			@RequestParam String to) {

		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = null, endDate = null;

		if (from == null || to == null)
			return null;
		else {
			try {
				startDate = formatter.parse(from);
				endDate = formatter.parse(to);
				endDate.setHours(23);
				endDate.setMinutes(59);
				endDate.setSeconds(59);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Map<String, Integer> allInfo = this.service.getallshortcodebyclassesanddates(startDate, endDate);
			return allInfo;
		}
	}

	@SuppressWarnings("deprecation")
	@RequestMapping({ "/setsegmentsFilters" })
	@ResponseBody
	/**
	 * 
	 * Sets segment filters from date range. Returns map of shortcode counts by
	 * segment.
	 */
	public Object setsegmentsFilters(@RequestParam String from, @RequestParam String to) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = null, endDate = null;

		if (from == null || to == null)
			return null;
		else {
			try {
				startDate = formatter.parse(from);
				endDate = formatter.parse(to);
				endDate.setHours(23);
				endDate.setMinutes(59);
				endDate.setSeconds(59);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Map<String, Integer> allInfo = this.service.getallshortcodebysegmentanddates(startDate, endDate);
			System.out.println("setsegmentsFilters" + allInfo);
			return allInfo;
		}
	}

	@RequestMapping({ "/login" })
	public String login() {
		return "login";
	}

	@GetMapping("/report")
	public String showForm(Model model) {
		model.addAttribute("report", new Report());
		return "report/reports";
	}

}
