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

import com.zain.shortcode.models.AdditionalService;
import com.zain.shortcode.repository.ShortCodeRepository;
import com.zain.shortcode.services.Imp.AdditionalServiceServiceImp;

/**
 * @author m.sabon
 *
 */
@Controller
@RequestMapping("/additionalservice")

public class AdditionalServiceController {

	@Autowired
	AdditionalServiceServiceImp additionalServiceServiceImp;
	@Autowired
	ShortCodeRepository shortcodeRepo;

	/**
	 * getAdditionalServicePage
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getAdditionalServicePage(Model model) {
		List<AdditionalService> AdditionalServicees = additionalServiceServiceImp.get_All_AdditionalService();
		model.addAttribute("AdditionalServicees", AdditionalServicees);
		return "additionalservice/additionalservice-list";
	}

	/**
	 * getAdditionalService
	 * 
	 * @param AdditionalServiceID
	 * @return
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping({ "/getAdditionalService" })
	@ResponseBody
	public ResponseEntity<AdditionalService> getAdditionalService(@RequestParam Long AdditionalServiceID) {
		AdditionalService AdditionalService = this.additionalServiceServiceImp
				.get_AdditionalService_ById(AdditionalServiceID);

		return new ResponseEntity(AdditionalService, HttpStatus.OK);
	}

	/**
	 * 
	 * @param AdditionalService
	 * @param redirectAttributes
	 * @return
	 */

	@PostMapping({ "/saveAdditionalService" })
	public String saveAdditionalService(@ModelAttribute AdditionalService AdditionalService,
			RedirectAttributes redirectAttributes) {
		try {
			this.additionalServiceServiceImp.add_AdditionalService(AdditionalService);
			redirectAttributes.addFlashAttribute("success", "AdditionalService added successfuly!");
		} catch (Exception e) {

			redirectAttributes.addFlashAttribute("failure", e.getMessage());
		}
		return "redirect:/additionalservice/list";
	}

	/**
	 * updateAdditionalService
	 * 
	 * @param AdditionalService
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping({ "/updateAdditionalService" })
	public String updateAdditionalService(@ModelAttribute AdditionalService AdditionalService,
			RedirectAttributes redirectAttributes) {

		this.additionalServiceServiceImp.update_AdditionalService(AdditionalService);

		redirectAttributes.addFlashAttribute("success", "AdditionalService updated successfuly!");
		return "redirect:/additionalservice/list";

	}

	/**
	 * deleteAdditionalService
	 * 
	 * @param AdditionalServiceID
	 * @param redirectAttributes
	 * @return
	 */
	@GetMapping({ "/deleteAdditionalService" })
	public String deleteAdditionalService(@RequestParam Long AdditionalServiceID,
			RedirectAttributes redirectAttributes) {
		if (shortcodeRepo.countshortcodebyadditionalID(AdditionalServiceID) > 0) {
			redirectAttributes.addFlashAttribute("failure", "AdditionalService is currently used by Shortcode!");
		} else {
			this.additionalServiceServiceImp.delete_AdditionalService_ById(AdditionalServiceID);
		}
		redirectAttributes.addFlashAttribute("success", "AdditionalService deleted successfuly!");
		return "redirect:/additionalservice/list";
	}
}
