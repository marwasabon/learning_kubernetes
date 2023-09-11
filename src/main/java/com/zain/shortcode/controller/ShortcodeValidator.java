package com.zain.shortcode.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;
import com.zain.shortcode.models.ShortCode;
import java.util.regex.Pattern;

public class ShortcodeValidator {

	public static List<String> isValidShortcode(@ModelAttribute ShortCode shortcode) {
		// Check if the shortcode is empty or null

		List<String> errors = new ArrayList<>();

		if (shortcode.getShortcodeNO() == null || shortcode.getShortcodeNO().isEmpty()) {
			errors.add("ShortCode is required.");

			return errors;
		}

		/*
		 * if (shortcode.getComment() == null || shortcode.getComment().isEmpty()) {
		 * errors.add("shortcode Comment is required.");
		 * 
		 * return errors; }
		 */
		// Check the length of the shortcode
		if (shortcode.getShortcodeNO().length() < 4 || shortcode.getShortcodeNO().length() > 10) {
			errors.add("ShortCode is greator than 4.");
			return errors;
		}

		// Check if the shortcode contains only alphanumeric characters
		if (!shortcode.getShortcodeNO().matches("^[a-zA-Z0-9]+$")) {
			errors.add("ShortCode should contain only alphanumeric characters.");

			return errors;
		}
		// Check if the shortcode Customer Name only text
		String arabicNamePattern = "^[\\p{IsArabic}\\s]+$";

		// English name regex pattern
		String englishNamePattern = "^[a-zA-Z\\s]+$";

		// Check if the name matches either Arabic or English name pattern
		if (!Pattern.matches(arabicNamePattern, shortcode.getCustomerName())
				&& !Pattern.matches(englishNamePattern, shortcode.getCustomerName())) {

			errors.add("Customer Name should contain only text.");
		}

		// Check if the shortcode Zain Requester Account only text
		// (!shortcode.getZainRequesterAccount().matches("[a-zA-Z]+")) {
		if (!Pattern.matches(arabicNamePattern, shortcode.getZainRequesterAccount())
				&& !Pattern.matches(englishNamePattern, shortcode.getZainRequesterAccount())) {

			errors.add("Zain Requester Account Name should contain only be Text.");

			return errors;
		}
		// Check if the shortcode Account Name only text
		String englishNamePattern2 = "^[a-zA-Z\\d\\s]+$";

		String arabicNamePattern2 = "^[\\p{IsArabic}\\d\\s]+$";

		if (!Pattern.matches(arabicNamePattern2, shortcode.getAccountName())
				&& !Pattern.matches(englishNamePattern2, shortcode.getAccountName())) {

			errors.add("Account Name should contain only be Text.");

			return errors;
		}
		if (!shortcode.getZainRequesterEmail().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
			errors.add("Invalid email address.");

			return errors;
		}
		// Additional custom validations can be added here
 		if (!shortcode.getFollowUpNumber().matches("^(00|\\+249|0)?(9|1)\\d{8}$")) {

			errors.add("Invalid phone number.");

			return errors;
		}

		double price = Double.parseDouble(shortcode.getShortCodePrice());
		if (price <= 0) {
			errors.add("Price must be greater than 0");
		}

		return errors;

	}

	/*
	 * public static void validateShortcode(@ModelAttribute ShortCode shortcode,
	 * RedirectAttributes redirectAttributes) { if (!isValidShortcode(shortcode)) {
	 * redirectAttributes.addFlashAttribute("failure", "Invalid shortcode: " +
	 * shortcode); } }
	 */
}