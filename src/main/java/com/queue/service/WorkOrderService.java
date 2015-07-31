package com.queue.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.queue.exception.IdAlreadyExistsException;
import com.queue.factory.WorkOrderFactory;
import com.queue.impl.IQueueImpl;
import com.queue.model.EmployeeWorkOrder;
import com.queue.util.DateUtil;

@Service
public class WorkOrderService implements IQueueService{

	// Using a map to make use of O(1) adding, removing, and accessing objects.
	private Map<Long, EmployeeWorkOrder> workOrderMap;
	
	@Autowired
	private IQueueImpl<EmployeeWorkOrder> workOrderQueue;
	
	public WorkOrderService(){
		workOrderMap = new HashMap<Long, EmployeeWorkOrder>();
	}
	
	@Override
	public EmployeeWorkOrder addWorkOrder(long id, Date enteredDate) throws IdAlreadyExistsException{
		EmployeeWorkOrder empWorkOrder = null;
		// Check if ID already exists!
		if(workOrderMap.get(id) != null){
			throw new IdAlreadyExistsException(id);
		}else{
			empWorkOrder = WorkOrderFactory.produceID(id, enteredDate);
			if(empWorkOrder != null){
				workOrderQueue.add(empWorkOrder);
				workOrderMap.put(id, empWorkOrder);
			}
		}
		return empWorkOrder;
	}

	@Override
	public EmployeeWorkOrder getTopWorkOrder() {
		EmployeeWorkOrder empWorkOrder = workOrderQueue.poll();
		if(empWorkOrder != null){
			workOrderMap.remove(empWorkOrder.getId());
		}
		return empWorkOrder;
	}

	@Override
	public List<Long> getSortedIds() {
		List<Long> list = new ArrayList<Long>();
		Collection<EmployeeWorkOrder> setOfOrders = workOrderQueue.getAll();
		for(EmployeeWorkOrder empOrder : setOfOrders){
			list.add(empOrder.getId());
		}		
		return list;
	}

	@Override
	public EmployeeWorkOrder removeId(long id) {
		EmployeeWorkOrder empWorkOrder = null;
		if(workOrderMap.get(id) != null){
			empWorkOrder = workOrderMap.get(id);
			workOrderQueue.remove(empWorkOrder);
			workOrderMap.remove(id);
		}
		return empWorkOrder;
	}

	@Override
	public long getIdPosition(long id) {
		int position = -1;
		if(workOrderMap.get(id) != null){
			Collection<EmployeeWorkOrder> setOfOrders = workOrderQueue.getAll();
			position = 0;
			for(EmployeeWorkOrder empWorkOrder : setOfOrders){
				if(empWorkOrder.getId() == id){
					break;
				}
				position++;
			}
		}
		return position;
	}

	@Override
	public double getAverageTime(Date currentTime) {
		double numberOfSeconds = 0;
		
		Collection<EmployeeWorkOrder> setOfOrders = workOrderQueue.getAll();		
		for(EmployeeWorkOrder empWorkOrder : setOfOrders){
			numberOfSeconds += DateUtil.numberOfSecondsBetween(empWorkOrder.getEnteredDate(), currentTime);
		}
		double size = workOrderQueue.size();
		if(size > 0){
			numberOfSeconds = numberOfSeconds / size;
		}
		return numberOfSeconds;
	}

	@Override
	public void clearQueue() {
		workOrderQueue.clear();
		workOrderMap.clear();		
	}

}
