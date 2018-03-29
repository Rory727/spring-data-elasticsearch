package com.ebay.util;

import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * <pre>
 * Title:          DateUtil
 * Description:    A Date Util Class which will be used by all CBT Projects.
 * Copyright:      Copyright (c) 2016
 * Company:        eBay
 * @author shixie
 * @version 1.0
 * </pre>
 */
public class DateUtil {
	private final static String simple_date_format = "yyyyMMdd";
    private static final String simple_date_format_dot = "yyyy.MM.dd";
    private static final String simple_date_format_dash = "yyyy-MM-dd";
    private static final String date_time_format = "yyyy-MM-dd-HH:mm:ss";
    private static final String date_time_complex_format = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    /**-- add start ziczhou 2015.06.02 --*/
    /** "yyyy-MM-dd HH:mm:ss" format */
    private static final String DATE_TIME_DATABASE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_TIME_ALL_DASH = "yyyy-MM-dd HH-mm-ss";
    
    private static final String DATE_FORMAT_SLASH_DATE = "yyyy/MM/dd";
    private static final String DATE_FORMAT_SLASH_DATE_TIME = "yyyy/MM/dd HH:mm";
    
    private final static TimeZone GMT_TIMEZONE = TimeZone.getTimeZone("GMT");
    private final static TimeZone PST_TIMEZONE = TimeZone.getTimeZone("PST");
    public final static TimeZone GMT_PLUS8_TIMEZONE = TimeZone.getTimeZone("GMT+8");
    
    private static ThreadLocal<DateFormat> simpleDateSlashThread = new ThreadLocal<DateFormat> ();
    private static ThreadLocal<DateFormat> simpleDateThread = new ThreadLocal<DateFormat>();
    private static ThreadLocal<DateFormat> simpleDateWithDashThread = new ThreadLocal<DateFormat>();
    private static ThreadLocal<DateFormat> dateTimeThread = new ThreadLocal<DateFormat>();
    private static ThreadLocal<DateFormat> dateTimeComplexThread = new ThreadLocal<DateFormat>();
 
    /**
     * Adjust current date based on Asia/Shanghai, then compare.
     * 
     * The passed in date is under server timezone, but when it stores in database
     * it just repersents the one date without timezone. From business level,
     * we assume this date is under Asia/Shanghai which is originally input
     * from salesForce. So convert this date to current timezone to make sure
     * the compration is correct.
     * 
     * @param dueDate
     * @return
     */
    public static boolean isDateExpiredBasedOnGMT8(Date dueDate){
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(dueDate);
    	//Date will be UTC timezone datetime
    	long offset = TimeZone.getTimeZone("Asia/Shanghai").getRawOffset();
    	
    	cal.add(Calendar.MILLISECOND, -(int) offset);
    	
    	//Change to current Timezone datetime
    	long serverOffset = TimeZone.getDefault().getRawOffset();
    	
    	cal.add(Calendar.MILLISECOND, (int) serverOffset);
    	cal.add(Calendar.MILLISECOND, TimeZone.getDefault().getDSTSavings());
    	
    	Date now = new Date();
    	return now.after(cal.getTime());
    }
    /**
     * Trandfer the local time to Shanghai time zone
     * @param date
     * @return
     */
    public static Date pstToGmt(Date date) {
    	if(null == date){
    		return null;
    	}
	    Calendar cal = Calendar.getInstance();
	    TimeZone toTimeZone = TimeZone.getTimeZone("GMT+8");
	    long time = date.getTime();
	    cal.setTimeInMillis(time);
	    int zoneOffset = cal.get(Calendar.ZONE_OFFSET); // Get TimeZone difference
	    int dstOffset = cal.get(Calendar.DST_OFFSET); // Get summer time difference
	    cal.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset)); // now update the time
	
	    int zoneOffset2 = toTimeZone.getRawOffset();
	    int dstOffset2 = 0;
	    cal.add(Calendar.MILLISECOND, (zoneOffset2));
	    if (toTimeZone.inDaylightTime(cal.getTime())) {
	        dstOffset2 = toTimeZone.getDSTSavings();
	        cal.add(Calendar.MILLISECOND, (dstOffset2));
	    }
	    return cal.getTime();
	}
    
    public static void main(String[] args) {
    	try {
    		System.out.println(parseDateWithDataBase(formatDateWithDataBaseInSF(new Date())));
			System.out.println(parseDateWithDataBase(formatDateWithDataBaseInSF(pstToGmt(new Date()))));
			Date date = new Date();
		    DateFormat gmtFormat = new SimpleDateFormat();
		    TimeZone gmtTime = TimeZone.getTimeZone("GMT");
		    gmtFormat.setTimeZone(gmtTime);
		    System.out.println("Current Time: "+date);
		    System.out.println("GMT Time: " + gmtFormat.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    /**
     * Check whether now time is bigger than dueDate 
     * @param dueDate
     * @return
     */
    public static boolean isDateExpiredWithoutTimeZone(Date dueDate){
    	Date now = new Date();
    	return now.after(dueDate);
    }
    
    public static boolean isDateExpiredWithNullCheck(Date dueDate) {
    	return dueDate == null ? true : DateUtil.isDateExpired(dueDate);
    }
    
    /**
     * Adjust current date based on Asia/Shanghai, then compare.
     * 
     * The passed in date is under server timezone, but when it stores in database
     * it just repersents the one date without timezone. From business level,
     * we assume this date is under Asia/Shanghai which is originally input
     * from salesForce. So convert this date to current timezone to make sure
     * the compration is correct.
     * 
     * @param dueDate
     * @return
     */
    public static boolean isDateExpired(Date dueDate){
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(dueDate);
    	//Date will be UTC timezone datetime
    	long offset = TimeZone.getTimeZone("Asia/Shanghai").getRawOffset();
    	
    	cal.add(Calendar.MILLISECOND, -(int) offset);
    	
    	//Change to current Timezone datetime
    	long serverOffset = TimeZone.getDefault().getRawOffset();
    	
    	cal.add(Calendar.MILLISECOND, (int) serverOffset);
    	cal.add(Calendar.MILLISECOND, TimeZone.getDefault().getDSTSavings());
    	
    	Date now = new Date();
    	return now.after(cal.getTime());
    }
    
    public static Calendar getCurrentCalendarBasedOnGMT8(){
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(new Date());
    	//Date will be UTC timezone datetime
    	long offset = TimeZone.getTimeZone("Asia/Shanghai").getRawOffset();
    	cal.add(Calendar.MILLISECOND, (int) offset);
    	
    	//Change to current Timezone datetime
    	long serverOffset = TimeZone.getDefault().getRawOffset();
    	cal.add(Calendar.MILLISECOND, (int) -serverOffset);
    	cal.add(Calendar.MILLISECOND, TimeZone.getDefault().getDSTSavings());

    	return cal;
    }
    
    // date format: yyyy/MM/dd
    public static DateFormat getSimpleDateFormatWithSlash() {
    	DateFormat df = simpleDateSlashThread.get();
    	if (df == null) {
    		df = new SimpleDateFormat(DATE_FORMAT_SLASH_DATE);
    		simpleDateSlashThread.set(df);
    	}
    	
    	return df;
    }
    
    public static Date parseSimpleDateWithSlash(String dateStr) throws ParseException {
    	return getSimpleDateFormatWithSlash().parse(dateStr);
    }
 
    // date format: yyyyMMdd
    public static DateFormat getSimpleDateFormat() {
    	DateFormat df = simpleDateThread.get();
    	if (df == null) {
    		df = new SimpleDateFormat(simple_date_format);
    		simpleDateThread.set(df);
    	}
    	
    	return df;
    }
    
    public static Date parseSimpleDate (String dateStr) throws ParseException {
        return getSimpleDateFormat().parse(dateStr);
    }
    
    public static String formatSimpleDate (Date date) {
        return getSimpleDateFormat().format(date);
    }

    // date format: yyyy.MM.dd
    public static DateFormat getSimpleDateFormatWithDot() {
    	DateFormat df = simpleDateThread.get();
    	if (df == null) {
    		df = new SimpleDateFormat(simple_date_format_dot);
    		simpleDateThread.set(df);
    	}
    	
    	return df;
    }
    
    public static Date parseSimpleDateWithDot (String dateStr) throws ParseException {
        return getSimpleDateFormatWithDot().parse(dateStr);
    }
    
    public static String formatSimpleDateWithDot (Date date) {
        return getSimpleDateFormatWithDot().format(date);
    }
    
    // date format: yyyy-MM-dd
    public static DateFormat getSimpleDateFormatWithDash() {
    	DateFormat df = simpleDateWithDashThread.get();
    	if (df == null) {
    		df = new SimpleDateFormat(simple_date_format_dash);
    		simpleDateWithDashThread.set(df);
    	}
    	
    	return df;
    }

    public static Date parseSimpleDateWithDash (String dateStr) throws ParseException {
        return getSimpleDateFormatWithDash().parse(dateStr);
    }

    public static String formatSimpleDateWithDash (Date date) {
    	if(date==null) return null;
        return getSimpleDateFormatWithDash().format(date);
    }
    
    // date format: yyyy-MM-dd HH:mm:ss
    public static DateFormat getDateTimeDataBaseFormat() {
    	DateFormat df = dateTimeThread.get();
    	if (df == null) {
    		df = new SimpleDateFormat(DATE_TIME_DATABASE_FORMAT);
    		dateTimeThread.set(df);
    	}
    	
    	return df;
    }
    
    public static Date parseDateWithDataBase (String dateStr) throws ParseException {
        DateFormat format = getDateTimeDataBaseFormat();
        return format.parse(dateStr);
    }
    
    public static Date formatDateStr2Calender(String dateStr) throws ParseException {
    	if(StringUtils.isEmpty(dateStr))
    		return null;
    	Date date = parseDateWithDataBase(dateStr);
		Calendar calendar = Calendar.getInstance();
        if (date != null) {
          calendar.setTime(date);
          calendar.set(Calendar.HOUR_OF_DAY, 23);
          calendar.set(Calendar.MINUTE, 59);
          calendar.set(Calendar.SECOND, 59);
        }
        return calendar.getTime();
	}
    
    public static Date formatDate2Calender(Date date) throws ParseException {
		Calendar calendar = Calendar.getInstance();
        if (date != null) {
          calendar.setTime(date);
          calendar.set(Calendar.HOUR_OF_DAY, 23);
          calendar.set(Calendar.MINUTE, 59);
          calendar.set(Calendar.SECOND, 59);
          return calendar.getTime();
        }
        return null;
	}
    
    public static Date parseDateWithDataBase (String dateStr, TimeZone timeZone) throws ParseException {
        DateFormat format = getDateTimeDataBaseFormat();
        format.setTimeZone(timeZone);
        return format.parse(dateStr);
    }

    public static String formatDateWithDataBase (Date date) {
        DateFormat format = getDateTimeFormat();
        return format.format(date);
    }
    
    public static String formatDateWithDataBaseInSF (Date date) {
        DateFormat format = getDateTimeDataBaseFormat();
        return format.format(date);
    }
    
    // date format: yyyy-MM-dd-HH:mm:ss
    public static DateFormat getDateTimeFormat() {
    	DateFormat df = dateTimeThread.get();
    	if (df == null) {
    		df = new SimpleDateFormat(date_time_format);
    		dateTimeThread.set(df);
    	}
    	
    	return df;
    }
    
    public static String formatComplexSimpleDate4GMT8TimeZone(Date date) {
        DateFormat format = getDateTimeFormatComplex();
        format.setTimeZone(GMT_PLUS8_TIMEZONE);
        return format.format(date);
     }
    
    public static Date parseDateWithDash (String dateStr) throws ParseException {
        DateFormat format = getDateTimeFormat();
        return format.parse(dateStr);
    }

    public static String formatDateWithDash (Date date) {
        DateFormat format = getDateTimeFormat();
        return format.format(date);
    }
    
    // date format: yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
    public static DateFormat getDateTimeFormatComplex() {
    	DateFormat df = dateTimeComplexThread.get();
    	if (df == null) {
    		df = new SimpleDateFormat(date_time_complex_format);
    		dateTimeComplexThread.set(df);
    	}
    	
    	return df;
    }
    public static Date parseComplexDate (String dateStr) throws ParseException {
        return parseComplexDate(dateStr, GMT_TIMEZONE);
    }
    
    public static Date parseComplexDate (String dateStr, TimeZone zone) throws ParseException {
        DateFormat format = getDateTimeFormatComplex();
        format.setTimeZone(zone);
        return format.parse(dateStr);
    }

    public static String formatComplextSimpleDate (Date date) {
        DateFormat format = getDateTimeFormatComplex();
        return format.format(date);
    }

    /**
     * Compare the day of two dates.
     *
     * @param current    the first date
     * @param another    the other date
     * @return
     */
    public static int compareDateDay (Date current, Date another) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(current);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(another);

        int currYear = calendar1.get(Calendar.YEAR);
        int anotherYear = calendar2.get(Calendar.YEAR);
        int currDay = calendar1.get(Calendar.DAY_OF_YEAR);
        int anotherDay = calendar2.get(Calendar.DAY_OF_YEAR);

        if (currYear > anotherYear) {
            return 1;
        } else if (currYear < anotherYear) {
            return -1;
        }

        if (currDay > anotherDay) {
            return 1;
        } else if  (currDay == anotherDay) {
            return 0;
        } else {
            return -1;
        }
    }

    public static boolean compareDate(Date date1,Date date2){
    	if(date1 == null){
    		return false;
    	}
    	if(date2 == null){
    		return true;
    	}
    	return date1.getTime() > date2.getTime();
    }
    /**
     * Get the beginning datetime of this week.
     *
     * @return
     */
    public static Date getStartDateTimeOfThisWeek (Date today) {
        Calendar cal = Calendar.getInstance();
        if (today != null) {
            cal.setTime(today);
        }
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * Get the end datetime of this week.
     *
     * @return
     */
    public static Date getEndDateTimeOfThisWeek (Date today) {
        Calendar cal = Calendar.getInstance();
        if (today != null) {
            cal.setTime(today);
        }
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    /**
     * Get the date seven days ago.
     *
     * @return
     */
    public static Date getSevenDaysAgoDate (Date today) {
        Calendar cal = Calendar.getInstance();
        if (today != null) {
            cal.setTime(today);
        }
        cal.set(Calendar.DAY_OF_YEAR, cal.get(Calendar.DAY_OF_YEAR) - 7);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    
    /**
     * <p>
     * Return format date string according to seconds
     * 
     * @param millionSeconds
     * @return X h X m Xs
     */
    public static String getHMSFromMillionSeconds(long millionSeconds) {
       StringBuffer time = new StringBuffer("");
       if (millionSeconds == 0) {
          return "0 ms";
       }

       if (!(millionSeconds / 3600000 == 0)) {
          time.append((millionSeconds / 3600000) + " h ");
          millionSeconds = millionSeconds % 3600000;
       }

       if (!(millionSeconds / 60000 == 0)) {
          time.append((millionSeconds / 60000) + " m ");
          millionSeconds = millionSeconds % 60000;
       }

       if (!(millionSeconds / 1000 == 0)) {
          time.append((millionSeconds / 1000) + " s ");
          millionSeconds = millionSeconds % 1000;
       }

       if (millionSeconds != 0) {
          time.append(millionSeconds + " ms ");
       }

       return time.toString();
    }
    
    /////////////////////////
    // Date Parser For PGC //
    /////////////////////////
    
    public static Date parsePGCDate(String date) {
    	DateFormat df = new SimpleDateFormat(simple_date_format_dash);
         try {
			return df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    public static Date parsePGCDateTime(String datetime) {
    	DateFormat df = new SimpleDateFormat(DATE_TIME_DATABASE_FORMAT);
         try {
			return df.parse(datetime);
		} catch (ParseException e) {
			df = new SimpleDateFormat(DATE_TIME_ALL_DASH);
			try {
				return df.parse(datetime);
			} catch (Exception e1) {
			}
			return null;
		}
    }

}
