package com.queue.model;

import java.util.Date;

import com.queue.util.DateUtil;

/**
 * VIP ID is a class that inherent the characteristics of the employee ID class, and calculate rank.
 * 
 * @author ahamouda
 *
 */
public class VipWorkOrder extends EmployeeWorkOrder{

	private static final long serialVersionUID = -6910804357383692036L;

	public VipWorkOrder(long id, Date enteredDate) {
		super(id, enteredDate);
	}

	@Override
	public long getRank(Date date) {
		long numberOfSeconds = DateUtil.numberOfSecondsBetween(getEnteredDate(), date);
		long rank = (long) Math.max(4, 2 * numberOfSeconds * Math.log(numberOfSeconds));
		return rank;
	}
	
}
