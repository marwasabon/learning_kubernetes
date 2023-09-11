package com.zain.shortcode.services;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.zain.shortcode.models.ShortCode;


/**
 * @author m.sabon
 *
 */
public interface ShortCodeService {

	public ShortCode get_ShortCode_ById(Long id);

	public List<ShortCode> get_All_ShortCode();

	public boolean validateShortcodeNo(String id);

	public void delete_ShortCode_ById(Long id);

	ShortCode add_ShortCode1(ShortCode shortcode, Long id);

	ShortCode add_ShortCode(ShortCode shortcode) throws Exception;

	List<ShortCode> findInvoicesAboutToExpire();

	Map<String, Integer> getallshortcodebystatus();

	Map<String, Integer> getallshortcodebyclasses();

	Map<String, Integer> getallshortcodebysegments();

	Map<String, Integer> getallshortcodebyaddtional();

	Map<String, Integer> getallshortcodebystatusanddates(Date fromDate, Date toDate);

	Map<String, Integer> getallshortcodebysegmentanddates(Date fromDate, Date toDate);

	Map<String, Integer> getallshortcodebyclassesanddates(Date fromDate, Date toDate);

	Map<String, Integer> getallshortcodebyadditonalserviceanddates(Date fromDate, Date toDate);

}
