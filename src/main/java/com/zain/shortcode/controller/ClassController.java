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

import com.zain.shortcode.models.Classes;
import com.zain.shortcode.repository.ClassesRepository;
import com.zain.shortcode.repository.ShortCodeRepository;
import com.zain.shortcode.services.Imp.ClassServiceImp;

/**
 * @author m.sabon
 *
 */

@Controller
@RequestMapping("/classes")

public class ClassController {

	@Autowired
	ClassServiceImp classServiceImp;
	@Autowired
	ClassesRepository classRepo;
	@Autowired
	ShortCodeRepository shortcodeRepo;

	/**
	 * getUsersPage
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getUsersPage(Model model) {
		List<Classes> classes = classServiceImp.get_All_Classes();
		model.addAttribute("classes", classes);
		return "classes/classes-list";
	}

	/**
	 * getClass
	 * 
	 * @param ClassID
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping({ "/getClass" })
	@ResponseBody
	public ResponseEntity<Classes> getClass(@RequestParam Long ClassID) {
		Classes classe = this.classServiceImp.get_Class_ById(ClassID);
		return new ResponseEntity(classe, HttpStatus.OK);
	}

	/**
	 * saveClass
	 * 
	 * @param classe
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping({ "/saveClass" })
	public String saveClass(@ModelAttribute Classes classe, RedirectAttributes redirectAttributes) {
		try {
			this.classServiceImp.add_class(classe);
			redirectAttributes.addFlashAttribute("success", "Classe added successfuly!");

		} catch (Exception e) {

			redirectAttributes.addFlashAttribute("failure", e.getMessage());
		}
		return "redirect:/classes/list";
	}

	/**
	 * updateClass
	 * 
	 * @param classe
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping({ "/updateClass" })
	public String updateClass(@ModelAttribute Classes classe, RedirectAttributes redirectAttributes) {
		this.classServiceImp.update_class(classe);
		redirectAttributes.addFlashAttribute("success", "Class updated successfuly!");
		return "redirect:/classes/list";
	}

	/**
	 * deleteClass
	 * 
	 * @param ClassID
	 * @param redirectAttributes
	 * @return
	 */
	@GetMapping({ "/deleteClass" })
	public String deleteClass(@RequestParam Long ClassID, RedirectAttributes redirectAttributes) {
		if (shortcodeRepo.countshortcodebyClassID(ClassID) > 0) {
			redirectAttributes.addFlashAttribute("failure", "Class is currently used by Shortcode!");
		} else {
			this.classServiceImp.delete_Class_ById(ClassID);
			redirectAttributes.addFlashAttribute("success", "Class deleted successfuly!");
		}
		return "redirect:/classes/list";
	}
}
