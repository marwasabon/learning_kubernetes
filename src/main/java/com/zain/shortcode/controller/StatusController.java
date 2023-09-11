package com.zain.shortcode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zain.shortcode.models.Status;
import com.zain.shortcode.repository.ShortCodeRepository;
import com.zain.shortcode.repository.StatusRepository;
import com.zain.shortcode.services.Imp.StatusServiceImp;

/**
 * @author m.sabon
 *
 */
@Controller
@RequestMapping("/statuses")

public class StatusController {

	@Autowired
	StatusServiceImp statusServiceImp;
	@Autowired
	StatusRepository statusRepo;
	@Autowired
	ShortCodeRepository shortcodeRepo;

	/**
	 * getStatusPage
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getStatusPage(Model model) {
		List<Status> Statuses = statusServiceImp.get_All_Status();
		model.addAttribute("Statuses", Statuses);
		return "status/status-list";
	}

	/**
	 * getStatus
	 * 
	 * @param StatusID
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping({ "/getStatus" })
	@ResponseBody
	public ResponseEntity<Status> getStatus(@RequestParam Long StatusID) {
		Status Status = this.statusServiceImp.get_Status_ById(StatusID);
		return new ResponseEntity(Status, HttpStatus.OK);
	}

	/**
	 * saveStatus
	 * 
	 * @param status
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping({ "/saveStatus" })
	public String saveStatus(@ModelAttribute Status status, RedirectAttributes redirectAttributes) {
		try {
			this.statusServiceImp.add_Status(status);
			redirectAttributes.addFlashAttribute("success", "Status added successfuly!");

		} catch (Exception e) {

			redirectAttributes.addFlashAttribute("failure", e.getMessage());
		}
		return "redirect:/statuses/list";
	}

	/**
	 * updateStatus
	 * 
	 * @param status
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping({ "/updateStatus" })
	public String updateStatus(@ModelAttribute Status status, RedirectAttributes redirectAttributes) {
		this.statusServiceImp.update_status(status);

		redirectAttributes.addFlashAttribute("success", "Status updated successfuly!");
		return "redirect:/statuses/list";
	}

	/**
	 * deleteStatus
	 * 
	 * @param StatusID
	 * @param redirectAttributes
	 * @return
	 */
	@GetMapping({ "/deleteStatus" })
	public String deleteStatus(@RequestParam Long StatusID, RedirectAttributes redirectAttributes) {

		if (shortcodeRepo.countshortcodebyStatusID(StatusID) > 0) {
			System.out.println("error " + "Cannot delete Status with Shortcode!");
			redirectAttributes.addFlashAttribute("failure", "Status is currently used by Shortcode!");
		} else {
			this.statusServiceImp.delete_Status_ById((StatusID));
			redirectAttributes.addFlashAttribute("success", "Status deleted successfuly!");
		}
		return "redirect:/statuses/list";

	}
}