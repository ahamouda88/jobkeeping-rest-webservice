package com.queue.comparator;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.queue.model.EmployeeWorkOrder;
import com.queue.model.ManagementWorkOrder;

/**
 * A Class that compares work orders according to employees' ranks.
 * 
 * @author ahamouda
 *
 */
@Component
public class RankComparator implements Comparator<EmployeeWorkOrder> {

	@Override
	public int compare(EmployeeWorkOrder emp1, EmployeeWorkOrder emp2) {
		int result = 0;
		
		// Sort Employee work orders in reverse order.
		if((emp1 instanceof ManagementWorkOrder) && !(emp2 instanceof ManagementWorkOrder)){
			result = -1;
		}else if((emp2 instanceof ManagementWorkOrder) && !(emp1 instanceof ManagementWorkOrder)){
			result = 1;
		} else{
			Calendar cal = Calendar.getInstance();
			Date currentDate = cal.getTime();	
			
			long rank1 = emp1.getRank(currentDate);
			long rank2 = emp2.getRank(currentDate);
			result = Long.compare(rank2, rank1);
		}
		
		/*
		 *  If two work-orders have the same rank, then compare them according to the order they entered the queue.
		 */
		if(result == 0){
			result = emp1.compareTo(emp2);
		}
		return result;
	}

}
