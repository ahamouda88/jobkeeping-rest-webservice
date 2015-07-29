package com.queue.model;

import java.util.Date;

import com.queue.util.DateUtil;

/**
 * Normal ID is a class that inherent the characteristics of the employee ID class, and calculate rank.
 * 
 * @author ahamouda
 *
 */
public class NormalWorkOrder extends EmployeeWorkOrder{
	
	private static final long serialVersionUID = 3494976464972305111L;

	public NormalWorkOrder(long id, Date enteredDate) {
		super(id, enteredDate);
	}
	
	@Override
	public long getRank(Date date) {
		long rank = DateUtil.numberOfSecondsBetween(getEnteredDate(), date);
		return rank;
	}
}
