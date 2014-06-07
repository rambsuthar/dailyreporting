package com.gsli.dr.common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

import com.gsli.dr.common.logger.GslLogger;

/**
 * @com.wellpoint.cii.util
 * 
 *                         Util which helps in manipulating date in the
 *                         Application
 * 
 * @filename DateUtil.java
 * @date Apr 24, 2014
 * @author Deloitte
 * 
 */
public class DateUtil {

	private static final GslLogger ciiLogger = GslLogger
			.getGslLogger(DateUtil.class);

	/**
	 * Converts Date to given format
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String convertDateToFmt(Date date, String format) {
		ciiLogger.debug("Enterred DateUtil.convertDateToFmt method");

		SimpleDateFormat formatter = new SimpleDateFormat(format);

		ciiLogger.debug("Exited DateUtil.convertDateToFmt method");

		return formatter.format(date);
	}

	/**
	 * Converts Current Date to given format
	 * 
	 * @param format
	 * @return
	 */
	public static String currentDateInFmt(String format) {
		ciiLogger.debug("Enterred DateUtil.currentDateInFmt method");
		Date currentDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(format);

		ciiLogger.debug("Exited DateUtil.currentDateInFmt method");

		return formatter.format(currentDate);
	}

	/**
	 * Gets CurrentTimeStamp from current date
	 * 
	 * @return
	 */
	public static Timestamp getCurrentTimeStamp() {
		ciiLogger.debug("Enterred DateUtil.getCurrentTimeStamp method");

		Date currentDate = new Date();
		Timestamp currentTimestamp = new Timestamp(currentDate.getTime());

		ciiLogger.debug("Exited DateUtil.getCurrentTimeStamp method");
		return currentTimestamp;
	}

	/**
	 * Gets current date
	 * 
	 * @return
	 */
	public static Date getCurrentDate() {
		ciiLogger.debug("Enterred DateUtil.getCurrentDate method");

		Date currentDate = new Date();

		ciiLogger.debug("Exited DateUtil.getCurrentDate method");
		return currentDate;
	}

	/**
	 * Gets TimeStamp from date
	 * 
	 * @return
	 */
	public static Timestamp getTimeStampFrmDate(Date date) {
		ciiLogger.debug("Enterred DateUtil.getTimeStampFrmDate method");

		Timestamp timestamp = new Timestamp(date.getTime());

		ciiLogger.debug("Exited DateUtil.getTimeStampFrmDate method");
		return timestamp;
	}

	/**
	 * Gets current Date form current TimeStamp
	 * 
	 * @return
	 */
	public static Date getCurrDateFrmTmStmp(Timestamp currentTimestamp) {
		ciiLogger.debug("Enterred DateUtil.getCurrDateFrmTmStmp method");

		Date currentDate = new Date(currentTimestamp.getTime());

		ciiLogger.debug("Exited DateUtil.getCurrDateFrmTmStmp method");
		return currentDate;
	}

	/**
	 * Gets Date from String by parsing
	 * 
	 * @return
	 */
	public static Date getDatefromString(String dateString, String format) {
		ciiLogger.debug("Enterred DateUtil.getDatefromString method");
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = formatter.parse(dateString);
		} catch (ParseException e) {
			ciiLogger.error(e.getMessage(), e);
		}
		ciiLogger.debug("Exited DateUtil.getDatefromString method");
		return date;

	}
	
	/**
	 * Gets Date from String by parsing
	 * 
	 * @return
	 */
	public static Timestamp getTimestampfromString(String dateString, String format) {
		ciiLogger.debug("Enterred DateUtil.getTimestampfromString method");
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		Timestamp timestamp = null;
		try {
			Date date = formatter.parse(dateString);
			timestamp = new Timestamp(date.getTime());
		} catch (ParseException e) {
			ciiLogger.error(e.getMessage(), e);
		}
		ciiLogger.debug("Exited DateUtil.getTimestampfromString method");
		return timestamp;

	}


	public static Date getDateFromMonthYear(String monthYear){
		ciiLogger.debug("Enterred DateUtil.getDateFromMonthYear method");
		StringTokenizer st = new StringTokenizer(monthYear, " ");
		String month=GSLConstants.EMPTY_STRING;
		String year=GSLConstants.EMPTY_STRING;
		while(st.hasMoreElements()){
			month=st.nextToken();
			year=st.nextToken();
		}		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, GSLConstants.MONTH.valueOf(month).ordinal());
		calendar.set(Calendar.YEAR, Integer.parseInt(year));
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);            // set hour to midnight
		calendar.set(Calendar.MINUTE, 0);                 // set minute in hour
		calendar.set(Calendar.SECOND, 0);                 // set second in minute
		calendar.set(Calendar.MILLISECOND, 0); 
		Date date = calendar.getTime();
		ciiLogger.debug("Exiting DateUtil.getDateFromMonthYear method : "+date);
		return date;		
	}
	
	public static Date getNextMonthDate(Date date){
		ciiLogger.debug("Enterred DateUtil.getNextMonthDate() method ");
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);            // set hour to midnight
		c.set(Calendar.MINUTE, 0);                 // set minute in hour
		c.set(Calendar.SECOND, 0);                 // set second in minute
		c.set(Calendar.MILLISECOND, 0); 
		date = c.getTime();
		ciiLogger.debug("Exiting DateUtil.getNextMonthDate() method : "+date);
		return date;
	}
	
	 public static Date addDays(Date date, int days)
	 {
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(date);
		 cal.add(Calendar.DATE, days); //minus number would decrement the days
		 return cal.getTime();
	 }
}
