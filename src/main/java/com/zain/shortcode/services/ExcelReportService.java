package com.zain.shortcode.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zain.shortcode.models.Report;
import com.zain.shortcode.models.RoutingMSISDNs;
import com.zain.shortcode.models.ShortCode;
import com.zain.shortcode.repository.ShortCodeRepository;

/**
 * @author m.sabon
 *
 */
@Service
public class ExcelReportService {
	@Autowired
	ShortCodeRepository repo;

	/**
	 * generateShortCodeReport
	 * 
	 * @param report
	 * @return
	 */
	public ByteArrayInputStream generateShortCodeReport(Report report) {
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			Sheet sheet = workbook.createSheet("Short Codes");
			// style
			CellStyle style = workbook.createCellStyle();
			CellStyle headerStyle = workbook.createCellStyle();

			XSSFFont font = (XSSFFont) workbook.createFont();
			font.setBold(true);
			font.setFontHeight(10);
			style.setFont(font);
			style.setWrapText(true);
			headerStyle.setFont(font);
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			headerStyle.setWrapText(false);
			headerStyle.setFillForegroundColor(IndexedColors.BLUE_GREY.index);

			// DateFormat dateFormat;
			// Add header
			Row row = sheet.createRow(0);
			createStringCell(row, 0, "Short Code ", headerStyle);
			createStringCell(row, 1, "RoutingMSISDNs", headerStyle);
			createStringCell(row, 2, "Short Code Price", headerStyle);
			createStringCell(row, 3, "Short Code Status", headerStyle);
			createStringCell(row, 4, "Short Code Class", headerStyle);
			createStringCell(row, 5, "Short Code Segment", headerStyle);
			createStringCell(row, 6, "Short Code Account Name", headerStyle);
			createStringCell(row, 7, "Short Code Activation Name", headerStyle);
			createStringCell(row, 8, "Follow up Number", headerStyle);
			createStringCell(row, 9, "Contact name", headerStyle);
			createStringCell(row, 10, "Expiry Date", headerStyle);
			createStringCell(row, 11, "Created By", headerStyle);
			createStringCell(row, 12, "Creation Date", headerStyle);

			// Fill the sheet with the short code data
			// Replace this with actual data retrieval
			List<ShortCode> shortCodes = getShortCodes(report);
			int rowNum = 1;
			for (ShortCode sc : shortCodes) {
				Row row1 = sheet.createRow(rowNum++);
				row1.createCell(0).setCellValue(sc.getShortcodeNO());

				Cell routingCell = row1.createCell(1);
				StringBuilder routingBuilder = new StringBuilder();

				for (RoutingMSISDNs routing : sc.getRoutingMSISDNs()) {
					routingBuilder.append(routing.getRoutingMSISDN()).append(", ");
				}
				String routingString = routingBuilder.toString().trim();
				if (routingString.isEmpty()) {
					routingCell.setCellValue("NA");
				} else {
					routingString = routingString.substring(0, routingString.length() - 1);
					routingCell.setCellValue(routingString);
				}
				row1.createCell(2).setCellValue(sc.getShortCodePrice());
				row1.createCell(3).setCellValue((sc.getStatuses()).getStatusName());
				row1.createCell(4).setCellValue((sc.getClasses()) == null ? "NA" : sc.getClasses().getClassName());
				row1.createCell(5).setCellValue(sc.getSegments().getSegmentName());
				row1.createCell(6).setCellValue(sc.getAccountName());
				row1.createCell(7).setCellValue(sc.getActivationDate() == null ? "NA" : sc.getActivationDate().toString());
				row1.createCell(8).setCellValue(sc.getFollowUpNumber());
				row1.createCell(9).setCellValue(sc.getCustomerName());
				row1.createCell(10).setCellValue(sc.getExpiryDate() == null ? "NA" : sc.getExpiryDate().toString());
				row1.createCell(11).setCellValue(sc.getCreatedBy() == null ? "NA" : sc.getCreatedBy().toString());
				row1.createCell(12).setCellValue(sc.getCreationDate() == null ? "NA" : sc.getCreationDate().toString());

			}

			// Set the column widths
			// sheet.setColumnWidth(0, 256 * 20);
			sheet.setColumnWidth(1, 256 * 20);
			// sheet.setColumnWidth(2, 256 * 40);

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}

		catch (IOException e) {
			throw new RuntimeException("Failed to generate Excel report", e);
		}

	}

	/**
	 * createStringCell
	 * 
	 * @param row
	 * @param columnCount
	 * @param value
	 * @param style
	 */
	private void createStringCell(Row row, int columnCount, String value, CellStyle style) {
		Cell cell = row.createCell(columnCount);
		cell.setCellValue(value);
		cell.setCellStyle(style);
	}

	/**
	 * getShortCodes
	 * 
	 * @param report
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private List<ShortCode> getShortCodes(Report report) {

		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = null, endDate = null;
		String fromDate = report.getFromDate();
		String toDate = report.getToDate();

		if (fromDate == null || toDate == null)
			return null;
		else {
			try {
				startDate = formatter.parse(fromDate);
				endDate = formatter.parse(toDate);
				endDate.setHours(23);
				endDate.setMinutes(59);
				endDate.setSeconds(59);

				System.out.println("------- From date is " + startDate + " To date is " + endDate);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		List<ShortCode> list = repo.findShortCodesByExpiryDate(startDate, endDate);
		System.out.println(list);
		return list;
	}
}
