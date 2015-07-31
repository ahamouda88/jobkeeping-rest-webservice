package com.queue.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

/**
 * An abstract class that represents the main attributes for an employee's ID. 
 * 
 * @author ahamouda
 *
 */
public abstract class EmployeeWorkOrder implements Serializable, Comparable<EmployeeWorkOrder> {	
	
	private static final long serialVersionUID = -1278762727599316159L;
	
	/*
	 * Fields
	 */
	private long id;
	@JsonSerialize(using=DateSerializer.class)
	private Date enteredDate;	
	@JsonIgnore
	private long order;
	
	/*
	 * Constructors
	 */
	public EmployeeWorkOrder(long id, Date enteredDate){
		this.id = id;
		this.enteredDate = enteredDate;
	}

	/*
	 * Setters and Getters
	 */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@JsonSerialize(using=CustomDateSerializer.class)
	public Date getEnteredDate() {
		return enteredDate;
	}

	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
	}
	
	public long getOrder() {
		return order;
	}

	public void setOrder(long order) {
		this.order = order;
	}

	/**
	 * A Method to get the rank of Employee according to his ID, given the current date.
	 * Current date should be later than the entered date.
	 * 
	 * @param date - date to be compared with the employee's entered date.
	 * @return employee's ID rank.
	 */
	public abstract long getRank(Date date);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((enteredDate == null) ? 0 : enteredDate.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeWorkOrder other = (EmployeeWorkOrder) obj;
		if (enteredDate == null) {
			if (other.enteredDate != null)
				return false;
		} else if (!enteredDate.equals(other.enteredDate))
			return false;
		if (id != other.id)
			return false;
		if (order != other.order)
			return false;
		return true;
	}
	
	/*
	 *  Implemented Comparable, to check in case if two work-orders have the same Rank.
	 *  It will use the order they have entered the queue in the comparison.
	 */	
	@Override
	public int compareTo(EmployeeWorkOrder emp) {
		return Long.compare(this.getOrder(), emp.getOrder());
	}
	
}
