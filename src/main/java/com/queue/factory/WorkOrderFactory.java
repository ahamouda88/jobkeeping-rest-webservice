package com.queue.factory;

import java.util.Calendar;
import java.util.Date;

import com.queue.model.EmployeeWorkOrder;
import com.queue.model.ManagementWorkOrder;
import com.queue.model.NormalWorkOrder;
import com.queue.model.PriorityWorkOrder;
import com.queue.model.VipWorkOrder;

/**
 * A Factory class that responsible for creating Employee IDs
 * 
 * @author ahamouda
 *
 */
public class WorkOrderFactory {
	
	/**
	 * This Method is used to create an employee work order given the id, and the date entered.
	 * Method will return <b>'null'</b>, if id is less than '0' or entered Date is null or a future date.
	 * 
	 * @param id - employee ID.
	 * @param enteredDate - date entered.
	 * @return employeeID - employee Id object.
	 */
	public static EmployeeWorkOrder produceID(long id, Date enteredDate){
		EmployeeWorkOrder employeeId = null;
		
		Calendar cal = Calendar.getInstance();
		Date currentDate = cal.getTime();
		
		if(id > 0 && enteredDate != null && currentDate.after(enteredDate)){
			if(id % 3 == 0 && id % 5 == 0){
				employeeId = new ManagementWorkOrder(id, enteredDate);
			}else if(id % 3 == 0){
				employeeId = new PriorityWorkOrder(id, enteredDate);
			}else if(id % 5 == 0){
				employeeId = new VipWorkOrder(id, enteredDate);
			}else{
				employeeId = new NormalWorkOrder(id, enteredDate);
			}
		}
		return employeeId;
	}
}
