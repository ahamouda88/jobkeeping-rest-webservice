package com.queue.impl;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * An Abstract class that contains the common methods for manipulating a queue.
 * 
 * @author ahamouda
 *
 * @param <E>
 */
public abstract class AbstractQueueImpl<E> implements IQueueImpl<E>{
	
	protected PriorityQueue<E> priorityQueue;
	
	public AbstractQueueImpl(Comparator<E> comparator){
		priorityQueue = new PriorityQueue<E>(comparator);
	}

	@Override
	public boolean add(E element){
		boolean result = false;
		if(element != null){
			result = priorityQueue.add(element);
		}
		return result;
	}
	
	@Override
	public E poll(){
		E element = null;
		if(!priorityQueue.isEmpty()){
			element = priorityQueue.poll();
		}
		return element;
	}
	
	@Override
	public E peek(){
		E element = null;
		if(!priorityQueue.isEmpty()){
			element = priorityQueue.peek();
		}
		return element;
	}
	
	@Override
	public boolean remove(E element){
		boolean result = false;
		if(element != null && !priorityQueue.isEmpty()){
			result = priorityQueue.remove(element);
		}
		return result;
	}
	
	@Override
	public Iterator<E> iterator(){
		return priorityQueue.iterator();
	}
	
	@Override
	public int size(){
		return priorityQueue.size();
	}
	
	@Override
	public void clear(){
		priorityQueue.clear();
	}
}
