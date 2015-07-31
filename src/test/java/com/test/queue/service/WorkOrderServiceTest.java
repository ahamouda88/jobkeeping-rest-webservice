package com.test.queue.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.queue.exception.IdAlreadyExistsException;
import com.queue.model.EmployeeWorkOrder;
import com.queue.service.IQueueService;
import com.queue.spring.SpringConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfiguration.class)
public class WorkOrderServiceTest {

	@Autowired
	private IQueueService workOrderService;
	
	@Before
	public void testAddWorkOrder(){	
		workOrderService.clearQueue();
		
		EmployeeWorkOrder actual;

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, 6);
		cal.set(Calendar.DAY_OF_MONTH, 26);
		cal.set(Calendar.HOUR_OF_DAY, 22);
		cal.set(Calendar.MINUTE, 8);
		cal.set(Calendar.SECOND, 1);
		Date date1 = cal.getTime();		
		actual = workOrderService.addWorkOrder(9, date1);
		Assert.assertNotNull(actual);
		
		cal.set(Calendar.SECOND, 2);
		Date date2 = cal.getTime();
		actual = workOrderService.addWorkOrder(3, date2);
		Assert.assertNotNull(actual);
		
		cal.set(Calendar.SECOND, 5);
		Date date3 = cal.getTime();
		actual = workOrderService.addWorkOrder(15, date3);
		Assert.assertNotNull(actual);
		
		cal.set(Calendar.SECOND, 1);
		Date date4 = cal.getTime();
		actual = workOrderService.addWorkOrder(30, date4);
		Assert.assertNotNull(actual);
		
		cal.set(Calendar.SECOND, 20);
		Date date5 = cal.getTime();
		actual = workOrderService.addWorkOrder(10, date5);
		Assert.assertNotNull(actual);
		
		cal.set(Calendar.SECOND, 20);
		actual = workOrderService.addWorkOrder(20, date5);
		Assert.assertNotNull(actual);
	}
	
	@Test(expected=IdAlreadyExistsException.class)
	public void testExistingId(){		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, 6);
		cal.set(Calendar.DAY_OF_MONTH, 26);
		Date date = cal.getTime();
		
		workOrderService.addWorkOrder(9, date);
	}
	
	@Test()
	public void testRemoveWorkOrder(){
		EmployeeWorkOrder actual = workOrderService.removeId(9);
		Assert.assertNotNull(actual);
				
		long fakeId = 120;
		actual = workOrderService.removeId(fakeId);
		Assert.assertNull(actual);
	}
	
	@Test
	public void testTopOnTheQueue(){
		long expectedId = 30;		
		EmployeeWorkOrder empWorkOrder = workOrderService.getTopWorkOrder();
		long actualId = empWorkOrder.getId();
		Assert.assertEquals(expectedId, actualId);
		
		expectedId = 15;
		empWorkOrder = workOrderService.getTopWorkOrder();
		actualId = empWorkOrder.getId();
		Assert.assertEquals(expectedId, actualId);
	}
	
	@Test
	public void testGetPosition(){		
		long expectedPos = 2;
		long actualPos = workOrderService.getIdPosition(10);
		Assert.assertEquals(expectedPos, actualPos);
		
		expectedPos = 5;
		actualPos =  workOrderService.getIdPosition(3);
		Assert.assertEquals(expectedPos, actualPos);
	}
	
	@Test
	public void testGetAllIds(){
		String expectedOrder = "3015102093";
		StringBuilder actualOrder = new StringBuilder();
		List<Long> actualList = workOrderService.getSortedIds();
		for(Long id : actualList){
			actualOrder.append(id);
		}
		Assert.assertEquals(expectedOrder, actualOrder.toString());
	}
}
