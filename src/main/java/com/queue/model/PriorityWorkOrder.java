package com.queue.model;

import java.util.Date;

import com.queue.util.DateUtil;

/**
 * Priority ID is a class that inherent the characteristics of the employee ID class, and calculate rank.
 * 
 * @author ahamouda
 *
 */
public class PriorityWorkOrder extends EmployeeWorkOrder{

	private static final long serialVersionUID = -572760449651491850L;

	public PriorityWorkOrder(long id, Date enteredDate) {
		super(id, enteredDate);
	}

	@Override
	public long getRank(Date date) {
		long numberOfSeconds = DateUtil.numberOfSecondsBetween(getEnteredDate(), date);
		long rank = (long) Math.max(3, numberOfSeconds * Math.log(numberOfSeconds));
		return rank;
	}

}
