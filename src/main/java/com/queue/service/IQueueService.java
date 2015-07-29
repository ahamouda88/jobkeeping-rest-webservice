package com.queue.service;

import java.util.Date;
import java.util.List;

import com.queue.exception.IdAlreadyExistsException;
import com.queue.model.EmployeeWorkOrder;


public interface IQueueService {

	/**
	 * A Method for adding a work order. It accepts two parameters the Id, and the time at which the Id is added.
	 * This method returns <b>'null'</b> if failed to create a work order.
	 * 
	 * @param id - id to be added.
	 * @param enteredDate - time Id was added.
	 * @return created work order.
	 * @throws IdAlreadyExistsException - if a work order with this id already exists.
	 */
	public EmployeeWorkOrder addWorkOrder(long id, Date enteredDate) throws IdAlreadyExistsException;
	
	/**
	 * A Method for getting the top work order.This method returns the highest work order in the queue
	 * and remove it from the queue. This method should return <b>'null'</b> if queue is empty.

	 * @return top work order in the queue.
	 */
	public EmployeeWorkOrder getTopWorkOrder();
	
	/**
	 * A Method to get all Ids in the queue, sorted from highest ranked Id to lowest.
	 * This method returns an <b>'empty list'</b> if queue is already empty.
	 * 
	 * @return list of sorted Ids.
	 */
	public List<Long> getSortedIds();
	
	/**
	 * A Method to remove a specific Id from the queue.
	 * This method returns <b>'null'</b> if id doesn't exist in the queue.
	 * 
	 * @param id - the id to be removed.
	 * @return removed work order.
	 */
	public EmployeeWorkOrder removeId(long id);
	
	/**
	 * A Method to get the position of a specified Id in the queue.
	 * This method returns <b>'-1'</b> if id doesn't exist in the queue.
	 * 
	 * @param id - the id to search for.
	 * @return the id's position.
	 */
	public long getIdPosition(long id);
	
	/**
	 * A Method to return the average number of seconds that each Id has been waiting in the queue.
	 * 
	 * @param currentTime - the current time
	 * @return average time.
	 */
	public double getAverageTime(Date currentTime);
	
	/**
	 * A Method to clear all elements in the queue.
	 * 
	 */
	public void clearQueue();	
	
}
