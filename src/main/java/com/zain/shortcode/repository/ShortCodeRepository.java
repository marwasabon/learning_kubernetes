package com.zain.shortcode.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zain.shortcode.models.AdditionalService;
import com.zain.shortcode.models.Classes;
import com.zain.shortcode.models.Segment;
import com.zain.shortcode.models.ShortCode;
import com.zain.shortcode.models.Status;

/**
 * 
 * @author m.sabon
 *
 */
public interface ShortCodeRepository extends DataTablesRepository<ShortCode, Long> {

	// Optional<ShortCode> findByshortcodeID(Long shortcodeID);
	Optional<ShortCode> findByshortcodeID(Long shortcodeId);

	Optional<ShortCode> findByshortcodeNO(String shortcodeNo);
	// List<ShortCode>findBystatuses(Status status);

	List<ShortCode> findByExpiryDateBefore(Date expiryDate);

	int countBystatuses(Status param);

	int countByclasses(Classes param);

	int countByadditionalServices(AdditionalService param);

	int countBysegments(Segment param);

	/**
	 * countshortcodebyStatusID
	 * @param statusID
	 * @return
	 */
	@Query(value = " SELECT COUNT(*) FROM shortcode WHERE status_id =:statusID", nativeQuery = true)
	int countshortcodebyStatusID(@Param("statusID") Long statusID);

	/**
	 * countshortcodebySegmentID
	 * @param segmentID
	 * @return
	 */
	@Query(value = " SELECT COUNT(*) FROM shortcode WHERE segment_id =:segmentID", nativeQuery = true)
	int countshortcodebySegmentID(@Param("segmentID") Long segmentID);

	/**
	 * countshortcodebyClassID
	 * @param ClassID
	 * @return
	 */

	@Query(value = " SELECT COUNT(*) FROM shortcode WHERE class_id =:classID", nativeQuery = true)
	int countshortcodebyClassID(@Param("classID") Long ClassID);

	/**
	 * countshortcodebyadditionalID
	 * @param segmentID
	 * @return
	 */
	@Query(value = " SELECT COUNT(*) FROM shortcode WHERE aservice_id =:aserviceID", nativeQuery = true)
	int countshortcodebyadditionalID(@Param("aserviceID") Long segmentID);

	/**
	 * findShortCodeAboutToExpire
	 * @return
	 */
	@Query(value = "SELECT * FROM shortcode WHERE expiry_date BETWEEN NOW() AND DATE_ADD(NOW(), INTERVAL 2 WEEK)", nativeQuery = true)
	List<ShortCode> findShortCodeAboutToExpire();

	/**
	 * findExpiredshortcodes
	 * @return
	 */
 
	@Query(value = "SELECT * FROM shortcode WHERE DATE(expiry_date) = CURDATE()", nativeQuery = true)
	List<ShortCode> findExpiredshortcodes();

	/**
	 * findShortCodesByExpiryDate
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
	List<ShortCode> findByexpiryDateBetween(LocalDate fromDate, LocalDate toDate);
	// int countBystatusesAndactivationDateBetween(Status param,LocalDate fromDate,
	// LocalDate toDate);

	@Query(value = "SELECT * FROM shortcode WHERE creation_date BETWEEN :fromDate AND :toDate", nativeQuery = true)
	List<ShortCode> findShortCodesByExpiryDate(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

	/**
	 * getcountstatus
	 * @param fromDate
	 * @param toDate
	 * @return
	 */

	@Query(value = "select status_name ,count(*)  from shortcode s inner join status r on s.status_id = r.statusID and creation_date BETWEEN :fromDate AND :toDate group by status_name", nativeQuery = true)
	List<Object[]> getcountstatus(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

	/**
	 * getcountclasses
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
	@Query(value = "select r.class_name ,count(*) from shortcode s inner join classes r on s.class_id = r.classID  and creation_date BETWEEN :fromDate AND :toDate group by r.class_name", nativeQuery = true)
	List<Object[]> getcountclasses(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

	/**
	 * getcountsegment
	 * @param fromDate
	 * @param toDate
	 * @return
	 */

	@Query(value = "select segment_name ,count(*)  from shortcode s inner join segment r on s.segment_id = r.segmentID  and creation_date BETWEEN :fromDate AND :toDate group by r.segment_name ", nativeQuery = true)
	List<Object[]> getcountsegment(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

	/**
	 * getcountadditonal
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
	@Query(value = "select aservice_name, count(*)  from shortcode s inner join additional_service r on s.aservice_id = r.aserviceID  and creation_date BETWEEN :fromDate AND :toDate group by r.aservice_name ", nativeQuery = true)
	List<Object[]> getcountadditonal(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

}
