package com.queue.model;

import java.util.Date;

import com.queue.util.DateUtil;

/**
 * Management Override ID is a class that inherent the characteristics of the employee ID class, and calculate rank.
 * 
 * @author ahamouda
 *
 */
public class ManagementWorkOrder extends EmployeeWorkOrder{

	private static final long serialVersionUID = -8610304361950064123L;

	public ManagementWorkOrder(long id, Date enteredDate) {
		super(id, enteredDate);
	}

	@Override
	public long getRank(Date date) {
		long numberOfSeconds = DateUtil.numberOfSecondsBetween(getEnteredDate(), date);
		return numberOfSeconds;
	}
}
