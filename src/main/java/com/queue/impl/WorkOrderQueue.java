package com.queue.impl;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Component;

import com.queue.comparator.RankComparator;
import com.queue.model.EmployeeWorkOrder;

@Component
public class WorkOrderQueue extends AbstractQueueImpl<EmployeeWorkOrder>{
	
	public WorkOrderQueue() {
		super(new RankComparator());	
	}

	@Override
	public Set<EmployeeWorkOrder> getAll() {
		Set<EmployeeWorkOrder> setOfOrders = new TreeSet<EmployeeWorkOrder>(priorityQueue.comparator());
		Iterator<EmployeeWorkOrder> itr = this.iterator();
		while(itr.hasNext()){
			setOfOrders.add(itr.next());
		}
		return setOfOrders;
	}

}
