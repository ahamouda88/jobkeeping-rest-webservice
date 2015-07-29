package com.queue.impl;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public interface IQueueImpl<E> {

	/**
	 * A Method to add an element to the queue. 
	 * This method returns <b>'true'</b> if element is added successfully.
	 * 
	 * @param element - object to be added.
	 * @return true if added successfully.
	 */
	public boolean add(E element);
	
	/**
	 * A Method to remove and get the first element from the queue.
	 * This method returns <b>'null'</b> if queue is empty.
	 * 
	 * @return top object in queue.
	 */
	public E poll();
	
	/**
	 * A Method to get the first element from the queue. Without removing it from the queue. 
	 * This method returns <b>'null'</b> if queue is empty.
	 * 
	 * @return top object in queue.
	 */
	public E peek();
	
	/**
	 * A Method to return all elements in the queue, after sorting them.
	 * 
	 * @return list of sorted elements in the queue.
	 */
	public List<E> getAll();
	
	/**
	 * A Method to remove an element from the queue. Given the element to be removed.
	 * This method returns <b>'false'</b> if queue is empty, or element is null.
	 * 
	 * @param element - element to be removed
	 * @return true if successfully removed.
	 */
	public boolean remove(E element);
	
	/**
	 * A Method to return the number of elements in the queue.
	 * 
	 * @return number of elements in the queue.
	 */
	public int size();
	
	/**
	 * A Method to return an iterator over the elements in this queue.
	 * 
	 * @return iterator over the elements.
	 */
	public Iterator<E> iterator();
	
	/**
	 * A Method to return the comparator used or it will return <b>'null'</b> if queue sorted in natural order.
	 * 
	 * @return the comparator used.
	 */
	public Comparator<? super E> comparator();
	
	/**
	 * A Method to remove all elements in this queue.
	 * 
	 */
	public void clear();
}
