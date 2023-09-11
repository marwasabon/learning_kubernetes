package com.zain.shortcode.services.Imp;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.zain.shortcode.models.AdditionalService;
import com.zain.shortcode.models.Classes;
import com.zain.shortcode.models.Segment;
import com.zain.shortcode.models.ShortCode;
import com.zain.shortcode.models.Status;
import com.zain.shortcode.repository.AdditionalServiceRepository;
import com.zain.shortcode.repository.ClassesRepository;
import com.zain.shortcode.repository.SegmentRepository;
import com.zain.shortcode.repository.ShortCodeRepository;
import com.zain.shortcode.repository.StatusRepository;
import com.zain.shortcode.services.NotificationService;
import com.zain.shortcode.services.ShortCodeService;

/**
 * @author m.sabon
 *
 */
@Service
public class ShortCodeServiceImp implements ShortCodeService {

	@Autowired
	private ShortCodeRepository ShortCodeRepositsory;

	@Autowired
	NotificationService notificationService;

	@Autowired
	private StatusRepository statusRepositsory;

	@Autowired
	private ClassesRepository classesRepositsory;
	@Autowired
	private SegmentRepository segmentRepositsory;
	@Autowired
	private AdditionalServiceRepository additionalRepositsory;
	// private ModelMapper modelMapper;

	@Override
	public ShortCode get_ShortCode_ById(Long id) {
		// TODO Auto-generated method stub
		return ShortCodeRepositsory.findById(id).get();

	}

	@Override
	public List<ShortCode> get_All_ShortCode() {
		// TODO Auto-generated method stub
		return (List<ShortCode>) ShortCodeRepositsory.findAll();
	}

	@Override
	public void delete_ShortCode_ById(Long id) {
		// TODO Auto-generated method stub
		ShortCodeRepositsory.deleteById(id);
	}

	@Transactional
	public void updateExpiredShortcodes() {
		List<ShortCode> expiredShortcodes = ShortCodeRepositsory.findByExpiryDateBefore(new Date());
		Status status1 = null;

		for (ShortCode shortcode : expiredShortcodes) {
			Optional<Status> status = statusRepositsory.findBystatusName("Disconnect".trim());

			status1 = status.get();
			shortcode.setStatuses(status1);
			ShortCodeRepositsory.save(shortcode);

		}
	}

	public ShortCode add_ShortCode(ShortCode shortcode) throws Exception {
		// TODO Auto-generated method stub
		// ShortCode shortcode12 = modelMapper.map(shortcode1,ShortCode.class);

		Optional<ShortCode> op = ShortCodeRepositsory.findByshortcodeNO(shortcode.getShortcodeNO());

		if (op.isPresent()) {
			throw new Exception("ShortCode with Number  " + shortcode.getShortcodeNO() + "  Already Exists");
		}

		try {

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String username = authentication.getName();
			String role = authentication.getAuthorities().toString();

			shortcode.setCreatedBy(username);
			shortcode.setCreatedByRole(role);
			shortcode.setCreationDate(new Date());

			ShortCode ShortCode1 = null;
			Optional<Status> status = statusRepositsory.findBystatusName("New");
			if (status.isPresent()) {
				Status status1 = status.get();
				shortcode.setStatuses(status1);

				ShortCode1 = ShortCodeRepositsory.save(shortcode);
			}

			/*
			 * //no need for this line because every status New is already there
			 * 
			 * else { Status newstatus = new Status(); newstatus.setStatusName("New");
			 * shortcode.setStatuses(newstatus);
			 * 
			 * ShortCode1 = ShortCodeRepositsory.save(shortcode);
			 * 
			 * }
			 */
			return ShortCode1;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Something went wrong");
		}
	}

	@Override
	public boolean validateShortcodeNo(String shortid) {

		// TODO Auto-generated method stub

		if (ShortCodeRepositsory.findByshortcodeNO(shortid) == null)
			return true;

		return false;
	}

	public void update_ShortCode(ShortCode shortcode, Long shortcodeId) {
		// TODO Auto-generated method stub

		ShortCode shortcodeob = this.ShortCodeRepositsory.findByshortcodeID(shortcodeId).get();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		String username = authentication.getName();
		String role = authentication.getAuthorities().toString();

		shortcodeob.setShortcodeNO(shortcode.getShortcodeNO());
		shortcodeob.setAccountName(shortcode.getAccountName());
		shortcodeob.setActivationDate(shortcode.getActivationDate());
		shortcodeob.setComment(shortcode.getComment());
		shortcodeob.setCustomerName(shortcode.getCustomerName());
		shortcodeob.setExpiryDate(shortcode.getActivationDate());
		shortcodeob.setFollowUpNumber(shortcode.getFollowUpNumber());
		shortcodeob.setShortCodePrice(shortcode.getShortCodePrice());
		shortcodeob.setZainRequesterAccount(shortcode.getZainRequesterAccount());
		shortcodeob.setZainRequesterEmail(shortcode.getZainRequesterEmail());
		shortcodeob.setClasses(shortcode.getClasses());
		shortcodeob.setSegments(shortcode.getSegments());
		shortcodeob.setAdditionalServices(shortcode.getAdditionalServices());
		shortcodeob.setStatuses(shortcode.getStatuses());
		shortcodeob.setActivationDate(shortcode.getActivationDate());
		shortcodeob.setCreatedBy(username);
		shortcodeob.setCreatedByRole(role);
		shortcodeob.setCreationDate(new Date());
		this.ShortCodeRepositsory.save(shortcode);
		// return shortcodeob;
	}

	@Override
	public ShortCode add_ShortCode1(ShortCode shortcode, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShortCode> findInvoicesAboutToExpire() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Integer> getallshortcodebystatus() {
		// TODO Auto-generated method stub

		Map<String, Integer> respData = new LinkedHashMap<>();

		List<Status> statuses = (List<Status>) this.statusRepositsory.findAll();

		for (Status status : statuses) {

			respData.put(status.getStatusName(), Integer.valueOf(this.ShortCodeRepositsory.countBystatuses(status)));

		}

		return respData;
	}

	@Override
	public Map<String, Integer> getallshortcodebyclasses() {
		// TODO Auto-generated method stub

		Map<String, Integer> respData = new LinkedHashMap<>();

		List<Classes> classes = (List<Classes>) this.classesRepositsory.findAll();

		for (Classes classe : classes) {

			respData.put(classe.getClassName(), Integer.valueOf(this.ShortCodeRepositsory.countByclasses(classe)));

		}

		return respData;
	}

	@Override
	public Map<String, Integer> getallshortcodebysegments() {
		// TODO Auto-generated method stub

		Map<String, Integer> respData = new LinkedHashMap<>();

		List<Segment> segements = (List<Segment>) this.segmentRepositsory.findAll();

		for (Segment segment : segements) {

			respData.put(segment.getSegmentName(), Integer.valueOf(this.ShortCodeRepositsory.countBysegments(segment)));

		}

		return respData;

	}

	@Override
	public Map<String, Integer> getallshortcodebyaddtional() {
		// TODO Auto-generated method stub
		Map<String, Integer> respData = new LinkedHashMap<>();

		List<AdditionalService> aservices = (List<AdditionalService>) this.additionalRepositsory.findAll();

		for (AdditionalService aservice : aservices) {

			respData.put(aservice.getAserviceName(),
					Integer.valueOf(this.ShortCodeRepositsory.countByadditionalServices(aservice)));

		}
		return respData;
	}

	@Override
	public Map<String, Integer> getallshortcodebystatusanddates(Date fromDate, Date toDate) {
		Map<String, Integer> respData = new LinkedHashMap<>();
		List<Object[]> ibj = this.ShortCodeRepositsory.getcountstatus(fromDate, toDate);

		// TODO Auto-generated method stub
		for (Object[] row : ibj) {

			String name = (String) row[0];

			Integer count = (((Number) row[1]).intValue());

			respData.put(name, count);

		}
		return respData;

	}

	@Override
	public Map<String, Integer> getallshortcodebysegmentanddates(Date fromDate, Date toDate) {
		// TODO Auto-generated method stub

		Map<String, Integer> respData = new LinkedHashMap<>();
		List<Object[]> ibj = this.ShortCodeRepositsory.getcountsegment(fromDate, toDate);

		// TODO Auto-generated method stub
		for (Object[] row : ibj) {

			String name = (String) row[0];

			Integer count = (((Number) row[1]).intValue());

			respData.put(name, count);

		}
		return respData;
	}

	@Override
	public Map<String, Integer> getallshortcodebyclassesanddates(Date fromDate, Date toDate) {
		// TODO Auto-generated method stub

		Map<String, Integer> respData = new LinkedHashMap<>();

		List<Object[]> ibj = this.ShortCodeRepositsory.getcountclasses(fromDate, toDate);
		// TODO Auto-generated method stub
		// List<Classes> classes = (List<Classes>) this.classesRepositsory.findAll();
		for (Object[] row : ibj) {

			String name = (String) row[0];

			Integer count = (((Number) row[1]).intValue());

			respData.put(name, count);

		}
		return respData;
	}

	@Override
	public Map<String, Integer> getallshortcodebyadditonalserviceanddates(Date fromDate, Date toDate) {
		Map<String, Integer> respData = new LinkedHashMap<>();
		List<Object[]> ibj = this.ShortCodeRepositsory.getcountadditonal(fromDate, toDate);

		// TODO Auto-generated method stub

		for (Object[] row : ibj) {

			String name = (String) row[0];

			Integer count = (((Number) row[1]).intValue());

			respData.put(name, count);

		}
		return respData;
	}

}
