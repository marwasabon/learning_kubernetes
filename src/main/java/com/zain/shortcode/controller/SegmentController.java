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

import com.zain.shortcode.models.Segment;
import com.zain.shortcode.repository.ShortCodeRepository;
import com.zain.shortcode.services.Imp.SegmentServiceImp;

/**
 * @author m.sabon
 *
 */
@Controller
@RequestMapping("/segments")

public class SegmentController {

	@Autowired
	SegmentServiceImp segmentServiceImp;
	@Autowired
	ShortCodeRepository shortcodeRepo;

	/**
	 * getSegmentPage
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getSegmentPage(Model model) {
		List<Segment> Segmentes = segmentServiceImp.get_All_Segment();
		model.addAttribute("Segmentes", Segmentes);
		return "segments/segment-list";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping({ "/getSegment" })
	@ResponseBody
	public ResponseEntity<Segment> getSegment(@RequestParam Long SegmentID) {
		Segment Segment = this.segmentServiceImp.get_Segment_ById(SegmentID);

		return new ResponseEntity(Segment, HttpStatus.OK);
	}

	/**
	 * saveSegment
	 * 
	 * @param segment
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping({ "/saveSegment" })
	public String saveSegment(@ModelAttribute Segment segment, RedirectAttributes redirectAttributes) {
		try {
			this.segmentServiceImp.add_Segment(segment);
			redirectAttributes.addFlashAttribute("success", "Segment added successfuly!");

		} catch (Exception e) {

			redirectAttributes.addFlashAttribute("failure", e.getMessage());
		}
		return "redirect:/segments/list";
	}

	/**
	 * updateSegment
	 * 
	 * @param segment
	 * @param redirectAttributes
	 * @return
	 */

	@PostMapping({ "/updateSegment" })
	public String updateSegment(@ModelAttribute Segment segment, RedirectAttributes redirectAttributes) {
		this.segmentServiceImp.update_Segment(segment);

		redirectAttributes.addFlashAttribute("success", "Segment updated successfuly!");
		return "redirect:/segments/list";
	}

	/**
	 * deleteSegment
	 * 
	 * @param SegmentID
	 * @param redirectAttributes
	 * @return
	 */
	@GetMapping({ "/deleteSegment" })
	public String deleteSegment(@RequestParam Long SegmentID, RedirectAttributes redirectAttributes) {

		if (shortcodeRepo.countshortcodebySegmentID(SegmentID) > 0) {
			redirectAttributes.addFlashAttribute("failure", "Segment is currently used by Shortcode!");
		} else {

			this.segmentServiceImp.delete_Segment_ById(SegmentID);
			redirectAttributes.addFlashAttribute("success", "Segment deleted successfuly!");
		}
		return "redirect:/segments/list";
	}
}
