package com.queue.util;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Seconds;

/**
 * A Utility class that contains various methods to manipulate Dates.
 *
 * @author ahamouda
 *
 */
public class DateUtil {

	private DateUtil(){}
		
	/**
	 * This method returns the number of seconds between two given dates. 
	 * The first date argument should be before the second date argument, otherwise number of seconds will be <b>'0'</b>.
	 * 
	 * @param date1 - earlier date.
	 * @param date2 - later date. 
	 * @return number of seconds.
	 */
	public static long numberOfSecondsBetween(Date date1, Date date2){
		long numberOfSeconds = 0;	
		
		if(date1 != null && date2 != null && date1.before(date2)){
			DateTime d1 = new DateTime(date1);
			DateTime d2 = new DateTime(date2);
			
			numberOfSeconds = Seconds.secondsBetween(d1, d2).getSeconds();
		}
		return numberOfSeconds;
	}
}
