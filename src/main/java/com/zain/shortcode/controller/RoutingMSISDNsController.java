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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zain.shortcode.models.RoutingMSISDNs;
import com.zain.shortcode.models.ShortCode;
import com.zain.shortcode.repository.ShortCodeRepository;
import com.zain.shortcode.services.Imp.RoutingMSISDNsServiceImp;

/**
 * @author m.sabon
 *
 */
@Controller
@RequestMapping("/routingMSISDNs")

public class RoutingMSISDNsController {

	@Autowired
	ShortCodeRepository ShortCodeRepositsory;

	@Autowired
	RoutingMSISDNsServiceImp routingMSISDNsServiceImp;

	/**
	 * getAllRoutingMSISDNs
	 * 
	 * @param shortcodeID
	 * @return
	 */
	@GetMapping("/listroutingMSISDNs/{shortcodeID}")
	public ModelAndView getAllRoutingMSISDNs(@PathVariable("shortcodeID") Long shortcodeID) {

		ModelAndView mav = new ModelAndView("routingMSISDNs/routingMSISDNs-list");
		ShortCode shortcode = ShortCodeRepositsory.findByshortcodeID(shortcodeID).get();
		mav.addObject("shortcodeID", shortcode.getShortcodeID());

		mav.addObject("routings", shortcode.getRoutingMSISDNs());
		System.out.println("shortcode---" + shortcode.getRoutingMSISDNs());

		mav.addObject("shortcode", shortcode);

		return mav;
	}

	/**
	 * getRoutingMSISDNsPage
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getRoutingMSISDNsPage(Model model) {
		List<RoutingMSISDNs> RoutingMSISDNs = routingMSISDNsServiceImp.get_All_RoutingMSISDNs();
		model.addAttribute("RoutingMSISDNs", RoutingMSISDNs);
		return "routingMSISDNs/routingMSISDNs-list";
	}

	/**
	 * getRoutingMSISDNs
	 * 
	 * @param RoutingMSISDNsID
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping({ "/getRoutingMSISDNs" })
	@ResponseBody
	public ResponseEntity<RoutingMSISDNs> getRoutingMSISDNs(@RequestParam Long RoutingMSISDNsID) {
		RoutingMSISDNs RoutingMSISDNs = this.routingMSISDNsServiceImp.get_RoutingMSISDNs_ById(RoutingMSISDNsID);
		return new ResponseEntity(RoutingMSISDNs, HttpStatus.OK);
	}

	/**
	 * getRoutingMSISDNs
	 * 
	 * @param RoutingMSISDNs
	 * @param shortcodeID
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping({ "/saveRoutingMSISDNs" })
	public String saveRoutingMSISDNs(@ModelAttribute RoutingMSISDNs RoutingMSISDNs, @RequestParam Long shortcodeID,
			RedirectAttributes redirectAttributes) {
		try {
			this.routingMSISDNsServiceImp.add_RoutingMSISDNs(RoutingMSISDNs, shortcodeID);

			redirectAttributes.addFlashAttribute("success", "RoutingMSISDNs added successfuly!");

		} catch (Exception e) {
			// RoutingMSISDNsServiceImp.add_RoutingMSISDNs(RoutingMSISDNs, shortcodeID);
			redirectAttributes.addFlashAttribute("failure", e.getMessage());

		}
		redirectAttributes.addAttribute("shortcodeID", shortcodeID);

		return "redirect:/routingMSISDNs/listroutingMSISDNs/{shortcodeID}";
	}

	/**
	 * updateRoutingMSISDNs
	 * 
	 * @param routingMSISDNs
	 * @param shortcodeID
	 * @param redirectAttributes
	 * @return
	 */

	@PostMapping({ "/updateRoutingMSISDNs" })
	public String updateRoutingMSISDNs(@ModelAttribute RoutingMSISDNs routingMSISDNs, @RequestParam Long shortcodeID,
			RedirectAttributes redirectAttributes) {

		RoutingMSISDNs newrouting = this.routingMSISDNsServiceImp
				.get_RoutingMSISDNs_ById(routingMSISDNs.getRoutingMSISDNID());

		System.out.println("newrouting" + newrouting);
		this.routingMSISDNsServiceImp.update_RoutingMSISDNs(routingMSISDNs, newrouting, shortcodeID);
		redirectAttributes.addAttribute("shortcodeID", shortcodeID);

		redirectAttributes.addFlashAttribute("success", "RoutingMSISDNs updated successfuly!");
		return "redirect:/routingMSISDNs/listroutingMSISDNs/{shortcodeID}";
	}

	/**
	 * deleteRoutingMSISDNs
	 * 
	 * @param RoutingMSISDNsID
	 * @param redirectAttributes
	 * @return
	 */
	@GetMapping({ "/deleteRoutingMSISDNs" })
	public String deleteRoutingMSISDNs(@RequestParam Long RoutingMSISDNsID, RedirectAttributes redirectAttributes) {
		ShortCode shortcode = this.routingMSISDNsServiceImp.get_RoutingMSISDNs_ById(RoutingMSISDNsID).getShortcode();
		Long shortcodeID = shortcode.getShortcodeID();
		this.routingMSISDNsServiceImp.delete_RoutingMSISDNs_ById(RoutingMSISDNsID);
		redirectAttributes.addFlashAttribute("success", "RoutingMSISDNs deleted successfuly!");
		redirectAttributes.addAttribute("shortcodeID", shortcodeID);

		return "redirect:/routingMSISDNs/listroutingMSISDNs/{shortcodeID}";
	}
}
