package com.test.queue.util;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.queue.util.DateUtil;

public class DateUtilTest {

	@Test
	public void testSecondsBetweenOne() {
		long numberOfSeconds = 0;
		long expectedResult = 0;

		System.out.println("Testing Dates in wrong order..");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 20);
		cal.set(Calendar.MINUTE, 25);
		cal.set(Calendar.SECOND, 20);
		Date date1 = cal.getTime();
		
		cal.set(Calendar.HOUR_OF_DAY, 20);
		cal.set(Calendar.MINUTE, 23);
		cal.set(Calendar.SECOND, 20);
		Date date2 = cal.getTime();
		
		numberOfSeconds = DateUtil.numberOfSecondsBetween(date1, date2);

		System.out.println("Number Of Seconds:"	+ numberOfSeconds + ", and Expected Result:" + expectedResult);
		Assert.assertEquals(numberOfSeconds, expectedResult);
		System.out.println("==============================================");
	}
	
	@Test
	public void testSecondsBetweenTwo() {
		long numberOfSeconds = 0;
		long expectedResult = 100;

		System.out.println("Testing Seconds between two dates..");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 20);
		cal.set(Calendar.MINUTE, 20);
		cal.set(Calendar.SECOND, 20);
		Date date1 = cal.getTime();
		
		cal.set(Calendar.HOUR_OF_DAY, 20);
		cal.set(Calendar.MINUTE, 21);
		cal.set(Calendar.SECOND, 60);
		Date date2 = cal.getTime();
		
		numberOfSeconds = DateUtil.numberOfSecondsBetween(date1, date2);

		System.out.println("Number Of Seconds:"
						+ numberOfSeconds + ", and Expected Result:" + expectedResult);
		Assert.assertEquals(numberOfSeconds, expectedResult);
		System.out.println("==============================================");
	}
}
