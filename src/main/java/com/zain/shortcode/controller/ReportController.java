package com.zain.shortcode.controller;

import java.io.ByteArrayInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.zain.shortcode.models.Report;
import com.zain.shortcode.services.ExcelReportService;

/**
 * @author m.sabon
 *
 */
@Controller
public class ReportController {

	@Autowired
	private ExcelReportService excelReportService;

	@PostMapping("/generate")
/**
 * generateReport
 * @param report
 * @return response
 */
	public ResponseEntity<InputStreamResource> generateReport(@ModelAttribute Report report) {
		ByteArrayInputStream excelReport = excelReportService.generateShortCodeReport(report);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=shortcodes.xlsx");

		return ResponseEntity.ok().headers(headers)
				.contentType(
						MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
				.body(new InputStreamResource(excelReport));
	}
}
