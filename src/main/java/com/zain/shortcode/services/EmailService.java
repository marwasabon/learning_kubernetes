package com.zain.shortcode.services;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.Message;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.zain.shortcode.models.ShortCode;

/**
 * @author m.sabon
 *
 */
@Service
public class EmailService {

	public final Logger logger = LogManager.getLogger(com.zain.shortcode.services.EmailService.class);

	@Autowired
	private JavaMailSender emailSender;

	@Value("${spring.mail.username}")
	private String from;

	private String subject;

	private String body;

	public String recipients(List<String> list) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			builder.append(list.get(i));
			if (i != list.size() - 1)
				builder.append(",");
		}
		return builder.toString();
	}

	/**
	 * sendEmail
	 * 
	 * @param to
	 */
	@Async
	public void sendEmail(List<String> to) {
		try {
			MimeMessage message = this.emailSender.createMimeMessage();
			message.setFrom(this.from);
			message.setContent(this.body, "text/html");
			message.setRecipients(Message.RecipientType.TO, recipients(to));

			// message.setRecipients(Message.RecipientType.TO, to);
			message.setSubject(this.subject);
			this.emailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
			this.logger.info("FAILED to send email: {}", e.getMessage());
		}
	}

	/*
	 * private String recipients(List<String> list) { StringBuilder builder = new
	 * StringBuilder(); for (int i = 0; i < list.size(); i++) {
	 * builder.append(list.get(i)); if (i != list.size() - 1) builder.append(","); }
	 * return builder.toString(); }
	 */
	/**
	 * prepareMessage
	 * 
	 * @param subpointID
	 * @param subpointDesc
	 * @param expiry
	 */

	public void prepareMessageforAbouttToExpired(ShortCode code) {
		this.subject = "Your ShortCode has Expired ";
	    @SuppressWarnings("unused")
		String customerName = code.getCustomerName();

		this.body = "Dear " + new String(code.getCustomerName().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8) + ",\n"
				+ "\n<p>This is a notification that your ShortCode <strong>#" + code.getShortcodeNO()
				+ "</strong> has expired on " + code.getExpiryDate() + ".\n"
				+ "Please make sure to renew it on request.\n"
				+ ".<br> <br><font size=\"2\" face=\"Verdana\" color=\"navy\">Kind regards</font>,<br><font size=\"2\" face=\"Verdana\" color=\"navy\">Zain Shortcode System.</font></p>";

	}

	public void prepareMessageforExpired(ShortCode code) {
		this.subject = "Your ShortCode has Expired ";
	    //String customerName = code.getCustomerName();

		this.body = "Dear " + new String(code.getCustomerName().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8) + ",\n"
				+ "\n<p>This is a notification that your ShortCode <strong>#" + code.getShortcodeNO()
				+ "</strong>  has Expired " + code.getExpiryDate() + ".\n"
				+ ".<br> <br><font size=\"2\" face=\"Verdana\" color=\"navy\">Kind regards</font>,<br><font size=\"2\" face=\"Verdana\" color=\"navy\">Zain Shortcode System.</font></p>";

	}

	public void prepareMessage(List<String> subpointID, String subpointDesc, Date expiry) {
		String date = (new SimpleDateFormat("yyyy-MM-dd")).format(expiry);
		if (from == null)
			from = "Empty Value";
		this.subject = "ShortCode  " + subpointID + ": " + subpointDesc + "Requires your attention!";
		this.body = "Dears,\n<p> Please pay attention that the Following ShortCode <strong>" + subpointID
				+ "</strong>: " + subpointDesc
				+ " requires your immediate attention, as it should be closed by your side on " + date
				+ ".<br> <br><font size=\"2\" face=\"Verdana\" color=\"navy\">Kind regards</font>,<br><font size=\"2\" face=\"Verdana\" color=\"navy\">Zain Audit Management System.</font></p>";
	}
}
