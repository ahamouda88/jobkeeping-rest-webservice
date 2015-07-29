package com.queue.impl;

import java.util.Set;

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
		return treeSet;
	}

}
