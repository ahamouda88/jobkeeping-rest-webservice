package com.queue.impl;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * An Abstract class that contains the common methods for manipulating a queue.
 * The add, remove, and poll methods take O(logN) time complexity. While the peek takes only O(1).
 * 
 * @author ahamouda
 *
 * @param <E>
 */
public abstract class AbstractQueueImpl<E> implements IQueueImpl<E>{
	
	/*
	 * Used the the same data type as both Key and Value. To have the same functionality as a priority queue.
	 */
	protected TreeMap<E, E> treeMap;
	
	/*
	 *  This counter variable is used to check the number of elements entered. It is different than the size() method.
	 *  It count all elements entered the queue.
	 */	
	protected long count;
	
	public AbstractQueueImpl(Comparator<E> comparator){
		treeMap = new TreeMap<E, E>(comparator);
	}

	@Override
	public boolean add(E element){
		boolean result = false;
		if(element != null){
			treeMap.put(element, element);
			result = true;
		}
		return result;
	}
	
	@Override
	public E poll(){
		E element = null;
		if(!treeMap.isEmpty()){
			element = treeMap.firstKey();
			treeMap.remove(element);
		}
		return element;
	}
	
	@Override
	public E peek(){
		E element = null;
		if(!treeMap.isEmpty()){
			element = treeMap.firstKey();
		}
		return element;
	}
	
	@Override
	public boolean remove(E element){
		boolean result = false;
		if(element != null && !treeMap.isEmpty()){
			E removed = treeMap.remove(element);
			if(removed != null){
				result = true;
			}
		}
		return result;
	}

	
	@Override
	public int size(){
		return treeMap.size();
	}
	
	@Override
	public void clear(){
		treeMap.clear();
	}
}
