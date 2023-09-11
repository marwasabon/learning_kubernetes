package com.zain.shortcode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zain.shortcode.models.ShortCode;
import com.zain.shortcode.repository.ShortCodeRepository;
import com.zain.shortcode.services.Imp.AdditionalServiceServiceImp;
import com.zain.shortcode.services.Imp.ClassServiceImp;
import com.zain.shortcode.services.Imp.SegmentServiceImp;
import com.zain.shortcode.services.Imp.ShortCodeServiceImp;
import com.zain.shortcode.services.Imp.StatusServiceImp;

/**
 * @author m.sabon
 *
 */
@Controller
@RequestMapping("/shortcodes")

public class ShortCodeController {

	@Autowired
	ShortCodeServiceImp ShortCodeServiceImp;

	@Autowired
	ShortCodeRepository repo;

	@Autowired
	ClassServiceImp classServiceImp;

	@Autowired
	StatusServiceImp statusesServiceImp;

	@Autowired
	SegmentServiceImp segmentServiceImp;
	@Autowired
	StatusServiceImp ststusesServiceImp;

	@Autowired
	AdditionalServiceServiceImp aservicesImp;

	/**
	 * getShortCodePage
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/lists", method = RequestMethod.GET)
	public String getShortCodePage(Model model) {
		List<ShortCode> shortcode = ShortCodeServiceImp.get_All_ShortCode();
		model.addAttribute("ShortCodes", shortcode);
		model.addAttribute("classes", this.classServiceImp.get_All_Classes());
		model.addAttribute("segments", this.segmentServiceImp.get_All_Segment());
		model.addAttribute("aservices", this.aservicesImp.get_All_AdditionalService());
		model.addAttribute("statuses", this.ststusesServiceImp.get_All_Status());

		return "shortcode/shortcode-list";
	}

	/**
	 * getShortCode
	 * 
	 * @param ShortCodeID
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping({ "/getShortCode" })
	@ResponseBody
	public ResponseEntity<ShortCode> getShortCode(@RequestParam Long ShortCodeID) {

		ShortCode ShortCode = this.ShortCodeServiceImp.get_ShortCode_ById(ShortCodeID);
		return new ResponseEntity(ShortCode, HttpStatus.OK);
	}
 
	/**
	 * showDetails
	 * @param ShortCodeID
	 * @return
	 */
	 
	@GetMapping({ "/showDetails/{id}" })
 	public String showDetails(@PathVariable Long id,Model model) {
 
		ShortCode shortcode = this.ShortCodeServiceImp.get_ShortCode_ById(id);
	    model.addAttribute("shortcode", shortcode); // add shortcode info to the model

		return "shortcode/shortcode-details";
	}
	/**
	 * saveShortCode
	 * 
	 * @param shortCode
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping({ "/saveShortCode" })
	public String saveShortCode(@ModelAttribute ShortCode shortCode, RedirectAttributes redirectAttributes) {
		List<String> errors = ShortcodeValidator.isValidShortcode(shortCode);
		if (errors.isEmpty()) {

			try {
				this.ShortCodeServiceImp.add_ShortCode(shortCode);
				Long shortCodeID = shortCode.getShortcodeID();
				redirectAttributes.addFlashAttribute("success", "ShortCode added successfully!");
				return "redirect:/routingMSISDNs/listroutingMSISDNs/" + shortCodeID;

			} catch (Exception e) {

				redirectAttributes.addFlashAttribute("failure", e.getMessage());
			}
		} else {
			for (String error : errors) {
				redirectAttributes.addFlashAttribute("failure", error);
			}
		}
		return "redirect:/shortcodes/lists";
	}

	/**
	 * saveShortCode
	 * 
	 * @param shortCodeID
	 * @param redirectAttributes
	 * @return
	 */
	@GetMapping({ "/showlistroutingMSISDNs" })
	public String showroutingMSISDNs(@RequestParam Long shortCodeID, RedirectAttributes redirectAttributes) {
		redirectAttributes.addAttribute("shortCodeID", shortCodeID);
		return "redirect:/routingMSISDNs/listroutingMSISDNs/{shortcodeID}";
	}

	/**
	 * updateShortCode
	 * 
	 * @param ShortCode
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping({ "/updateShortCode" })
	public String updateShortCode(@ModelAttribute ShortCode ShortCode, RedirectAttributes redirectAttributes) {

		this.ShortCodeServiceImp.update_ShortCode(ShortCode, ShortCode.getShortcodeID());

		redirectAttributes.addFlashAttribute("success", "ShortCode updated successfuly!");
		return "redirect:/shortcodes/lists";
	}

	
	/**
	 * renewShortCode
	 * 
	 * @param ShortCodeID
	 * @param redirectAttributes
	 * @return
	 */
	@GetMapping({ "/renew" })
	public String renewShortCode(@RequestParam Long ShortCodeID, RedirectAttributes redirectAttributes) {
		this.ShortCodeServiceImp.delete_ShortCode_ById(ShortCodeID);
		redirectAttributes.addFlashAttribute("success", "ShortCode deleted successfuly!");
		return "redirect:/shortcodes/lists";
	}

	/**
	 * deleteShortCode
	 * 
	 * @param ShortCodeID
	 * @param redirectAttributes
	 * @return
	 */
	@GetMapping({ "/deleteShortCode" })
	public String deleteShortCode(@RequestParam Long ShortCodeID, RedirectAttributes redirectAttributes) {
		this.ShortCodeServiceImp.delete_ShortCode_ById(ShortCodeID);
		redirectAttributes.addFlashAttribute("success", "ShortCode deleted successfuly!");
		return "redirect:/shortcodes/lists";
	}

}
