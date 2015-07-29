package com.queue.impl;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 * An Abstract class that contains the common methods for manipulating a queue.
 * 
 * @author ahamouda
 *
 * @param <E>
 */
public abstract class AbstractQueueImpl<E> implements IQueueImpl<E>{
	
	protected PriorityQueue<E> priorityQueue;
	protected Set<E> treeSet;
	
	public AbstractQueueImpl(Comparator<E> comparator){
		priorityQueue = new PriorityQueue<E>(comparator);
		treeSet = new TreeSet<E>(comparator);
	}

	@Override
	public boolean add(E element){
		boolean result = false;
		if(element != null){
			result = priorityQueue.add(element);
			if(result){
				treeSet.add(element);
			}
		}
		return result;
	}
	
	@Override
	public E poll(){
		E element = null;
		if(!priorityQueue.isEmpty()){
			element = priorityQueue.poll();
			treeSet.remove(element);
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
			treeSet.remove(element);
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
		treeSet.clear();
	}
}
