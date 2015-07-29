package com.queue.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.queue.comparator.RankComparator;
import com.queue.model.EmployeeWorkOrder;

@Component
public class WorkOrderQueue extends AbstractQueueImpl<EmployeeWorkOrder>{
	
	public WorkOrderQueue() {
		super(new RankComparator());	
	}

	@Override
	public List<EmployeeWorkOrder> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
