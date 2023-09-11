package com.zain.shortcode.schedule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zain.shortcode.models.ShortCode;
import com.zain.shortcode.repository.ShortCodeRepository;
import com.zain.shortcode.services.EmailService;
import com.zain.shortcode.services.NotificationService;
import com.zain.shortcode.services.Imp.ShortCodeServiceImp;

@Component
public class ScheduledTasks {
	@Autowired
	private ShortCodeRepository repo;
	@Autowired
	private ShortCodeServiceImp serviceimp;
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	NotificationService notificationService;

	@Autowired
	EmailService em;

	@Value("${spring.mail.username}")
	private String from;

	@Scheduled(cron = "0 0 9 * * *") // run every day at 9am
	// @Scheduled(cron = "0 40 10 7 9 *") //

	/**
	 * notifyCustomersOfExpiredShotcodes
	 */
	public void notifyCustomersOfExpiredShotcodes() {
		List<ShortCode> expiredShortcode = repo.findExpiredshortcodes();
		List<String> toEmails = new ArrayList<>();
		List<String> shortcodesNo = new ArrayList<>();

		for (ShortCode shortCode : expiredShortcode) {

			toEmails.add(shortCode.getZainRequesterEmail());
			shortcodesNo.add(shortCode.getShortcodeNO());
			System.out.println(shortCode.getZainRequesterEmail());
			notificationService.sendSMS(formatPhoneNumber(shortCode.getFollowUpNumber()),
					"shortcode with Number #" + shortCode.getShortcodeNO() + "  has expired");

			// delay for 1 hour or something secondss
			/*
			 * try { Thread.sleep(40000); } catch (InterruptedException e) {
			 * e.printStackTrace(); }
			 */
			sendNotificationEmailforExpired(shortCode);

		}

	}

	/**
	 * notifyCustomersOfExpiringShotcodes cron
	 */

	// @Scheduled(cron = "0 23 15 4 4 *") // run at 23 minutes and 0 seconds past
	// the hour, at 15:23 (3:23 PM), on the 4th day
	@Scheduled(cron = "0 0 9 * * *") // run every day at 9am
	public void notifyCustomersOfExpiringShotcodes() {
		// LocalDate now = LocalDate.now();

		List<ShortCode> expiringShortcode = repo.findShortCodeAboutToExpire();
		List<String> toEmails = new ArrayList<>();
		List<String> shortcodesNo = new ArrayList<>();

		for (ShortCode shortCode : expiringShortcode) {

			toEmails.add(shortCode.getZainRequesterEmail());
			shortcodesNo.add(shortCode.getShortcodeNO());
			System.out.println(shortCode.getZainRequesterEmail());
			notificationService.sendSMS(shortCode.getFollowUpNumber(), "shortcode with Number #"
					+ formatPhoneNumber(shortCode.getShortcodeNO()) + "  will expire in 2 Weeks!");

			// delay for 1 hour or something secondss
			/*
			 * try { Thread.sleep(40000); } catch (InterruptedException e) {
			 * e.printStackTrace(); }
			 */

			sendNotificationEmail(shortCode);

		}

	}

	/**
	 * updateExpiredShortcodes to make status disconnect
	 * 
	 */

	@Scheduled(cron = "0 0 00 * * *") // run every day at 12 am
	public void updateExpiredShortcodes() {
		serviceimp.updateExpiredShortcodes();

	}

	/**
	 * sendNotificationEmailforExpired
	 * 
	 * @param code
	 */
	@Async
	private void sendNotificationEmailforExpired(ShortCode code) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(code.getZainRequesterEmail());
		message.setSubject("Your ShortCode has Expired ");
		message.setText("Dear "
				+ (code.getCustomerName() + ",\n\n" + "This is a notification that your ShortCode #"
						+ code.getShortcodeNO() + " has Expired on " + code.getExpiryDate())
				+ ".\n\n" + "Please make sure to renew it on request.\n\n" + "Zain ShortCode System.\n"
				+ "Best regards,\n");

		mailSender.send(message);
	}

	/**
	 * sendNotificationEmail
	 * 
	 * @param code
	 */
	@Async
	private void sendNotificationEmail(ShortCode code) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(code.getZainRequesterEmail());
		message.setSubject("Your ShortCode is Expiring Soon");
		message.setText("Dear "
				+ (code.getCustomerName() + ",\n\n" + "This is a reminder that your ShortCode #" + code.getShortcodeNO()
						+ " will expire on " + code.getExpiryDate())
				+ ".\n\n" + "Please make sure to renew it on request.\n\n" + "Zain ShortCode System.\n"
				+ "Best regards,\n");

		mailSender.send(message);
	}

	/**
	 * formatPhoneNumber
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public String formatPhoneNumber(String phoneNumber) {
		if (phoneNumber.startsWith("0") || phoneNumber.startsWith("9")) {
			phoneNumber = "+249" + phoneNumber.substring(1);
		}
		return phoneNumber;
	}

}
