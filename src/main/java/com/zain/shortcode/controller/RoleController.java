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

import com.zain.shortcode.models.Roles;
import com.zain.shortcode.repository.RolesRepository;
import com.zain.shortcode.services.Imp.RoleServiceImp;

/**
 * @author m.sabon
 *
 */
@Controller
@RequestMapping("/roles")

public class RoleController {

	@Autowired
	RolesRepository roleRepo;

	@Autowired
	RoleServiceImp roleServiceImp;

	/**
	 * getRolePage
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String getRolePage(Model model) {
		List<Roles> Roles = roleServiceImp.get_All_Roles();
		model.addAttribute("Rolees", Roles);
		return "roles/role-list";
	}

	/**
	 * getRole
	 * 
	 * @param RoleID
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping({ "/getRole" })
	@ResponseBody
	public ResponseEntity<Roles> getRole(@RequestParam Long RoleID) {
		Roles Role = this.roleServiceImp.get_Role_ById(RoleID);
		return new ResponseEntity(Role, HttpStatus.OK);
	}

	/**
	 * saveRole
	 * 
	 * @param role
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping({ "/saveRole" })
	public String saveRole(@ModelAttribute Roles role, RedirectAttributes redirectAttributes) {
		try {
			this.roleServiceImp.add_role(role);
			redirectAttributes.addFlashAttribute("success", "Role added successfuly!");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			redirectAttributes.addFlashAttribute("failure", e.getMessage());
		}
		return "redirect:/roles/all";
	}

	/**
	 * updateRole
	 * 
	 * @param role
	 * @param redirectAttributes
	 * @return
	 */

	@PostMapping({ "/updateRole" })
	public String updateRole(@ModelAttribute Roles role, RedirectAttributes redirectAttributes) {

		this.roleServiceImp.update_role(role);
		redirectAttributes.addFlashAttribute("success", "Role updated successfuly!");
		return "redirect:/roles/all";
	}

	/**
	 * deleteRole deletes a role.
	 * 
	 * @param RoleID
	 * @param redirectAttributes
	 * @return
	 */
	@GetMapping({ "/deleteRole" })
	public String deleteRole(@RequestParam Long RoleID, RedirectAttributes redirectAttributes) {
		if (roleRepo.countusersbyroleID(RoleID) > 0) {
			redirectAttributes.addFlashAttribute("failure", "Role is currently assigned to Users!");
		} else {

			this.roleServiceImp.delete_Role_By_ID(RoleID);
			redirectAttributes.addFlashAttribute("success", "Role deleted successfuly!");
		}
		return "redirect:/roles/all";

	}
}
