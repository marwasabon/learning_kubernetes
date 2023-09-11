package com.zain.shortcode.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author m.sabon
 *
 */
public class DateHelper {
	/**
	 * addDays
	 * @param date
	 * @param duration
	 * @return
	 */
  public static Date addDays(Date date, int duration) {
    Calendar cal = getCalendar(date);
    cal.set(11, 23);
    cal.set(12, 59);
    cal.set(13, 59);
    cal.add(7, duration - 1);
    return cal.getTime();
  }
  /**
   * endDay
   * @param date
   * @return
   */
  public static Date endDay(Date date) {
    Calendar cal = getCalendar(date);
    cal.set(11, 23);
    cal.set(12, 59);
    cal.set(13, 59);
    cal.add(7, 1);
    return cal.getTime();
  }
  /**
   * getCalendar
   * @param date
   * @return
   */
  
  private static Calendar getCalendar(Date date) {
    Calendar cal = Calendar.getInstance(Locale.US);
    cal.setTime(date);
    return cal;
  }
}
