package com.queue.impl;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.queue.comparator.RankComparator;
import com.queue.model.EmployeeWorkOrder;

@Component
public class WorkOrderQueue extends AbstractQueueImpl<EmployeeWorkOrder>{
	
	public WorkOrderQueue() {
		super(new RankComparator());	
	}

	@Override
	public boolean add(EmployeeWorkOrder emp){
		boolean result = false;
		if(emp != null){
			// Setting this order value, just to use it to check which work-order has entered the queue first.
			emp.setOrder(count++);
			result = super.add(emp);
		}
		return result;
	}
	
	@Override
	public Collection<EmployeeWorkOrder> getAll() {
		return treeMap.values();
	}

}
