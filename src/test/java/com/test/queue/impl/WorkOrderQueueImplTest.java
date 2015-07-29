package com.test.queue.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.queue.factory.WorkOrderFactory;
import com.queue.impl.IQueueImpl;
import com.queue.model.EmployeeWorkOrder;
import com.queue.spring.SpringConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfiguration.class)
public class WorkOrderQueueImplTest {

	@Autowired
	private IQueueImpl<EmployeeWorkOrder> workOrderQueue;
	
	private Date defaultDate;
	private Calendar cal;
	
	@Before
	public void initialize(){
		cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, 6);
		cal.set(Calendar.DAY_OF_MONTH, 26);
		cal.set(Calendar.HOUR_OF_DAY, 22);
		cal.set(Calendar.MINUTE, 8);
		cal.set(Calendar.SECOND, 2);
		defaultDate = cal.getTime();
		workOrderQueue.clear();
	}
	
	@Test
	public void testAdd(){		
		EmployeeWorkOrder wo1 = WorkOrderFactory.produceID(1200l, defaultDate);
		boolean expected = true;
		boolean checkAdd = workOrderQueue.add(wo1);		
		Assert.assertEquals(expected, checkAdd);
		
		EmployeeWorkOrder wo2 = WorkOrderFactory.produceID(-1, defaultDate);
		expected = false;
		checkAdd = workOrderQueue.add(wo2);		
		Assert.assertEquals(expected, checkAdd);
		
	}
	
	@Test
	public void testOrder(){	
		long expectedFirstID = 15;
		
		EmployeeWorkOrder wo1 = WorkOrderFactory.produceID(5, defaultDate);
		
		cal.set(Calendar.SECOND, 9);
		Date date2 = cal.getTime();
		EmployeeWorkOrder wo2 = WorkOrderFactory.produceID(7, date2);
		
		cal.set(Calendar.MINUTE, 10);
		Date date3 = cal.getTime();
		EmployeeWorkOrder wo3 = WorkOrderFactory.produceID(15, date3);

		workOrderQueue.add(wo1);
		workOrderQueue.add(wo2);
		workOrderQueue.add(wo3);

		long resultID = workOrderQueue.poll().getId();
		Assert.assertEquals(expectedFirstID, resultID);

		Iterator<EmployeeWorkOrder> itr = workOrderQueue.iterator();
		while(itr.hasNext()){
			EmployeeWorkOrder empWorkOrder = itr.next();
			System.out.println("Employee ID: "+empWorkOrder.getId() + " - " + empWorkOrder.getEnteredDate());
		}
	}
	
	@Test
	public void testRemove(){	
		boolean expected = true;
		EmployeeWorkOrder wo = WorkOrderFactory.produceID(5, defaultDate);

		workOrderQueue.add(wo);		
		boolean result = workOrderQueue.remove(wo);
		Assert.assertEquals(expected, result);
	}

}
