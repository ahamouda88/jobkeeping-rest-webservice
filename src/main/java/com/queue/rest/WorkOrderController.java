package com.queue.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.queue.exception.BadRequestException;
import com.queue.exception.NotFoundException;
import com.queue.model.EmployeeWorkOrder;
import com.queue.model.URIConstants;
import com.queue.service.IQueueService;

@RestController
public class WorkOrderController {
	
	@Autowired
	private IQueueService queueService;

	@RequestMapping(value = URIConstants.ADD_WORKORDER,  method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public EmployeeWorkOrder addWorkOrder(@RequestParam(value = "id") long id,
			@RequestParam(value = "date") String enteredDate) {
		
		EmployeeWorkOrder empWorkOrder = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_hh:mm:ss");
	    try {
			Date date = sdf.parse(enteredDate);
			empWorkOrder = queueService.addWorkOrder(id, date);
			checkBadRequest(empWorkOrder);
		} catch (ParseException ex) {
			throw new BadRequestException();
		}
	    return empWorkOrder;		
	}
	
	@RequestMapping(value = URIConstants.GET_WORKORDER,  method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public long getTopId(){
		EmployeeWorkOrder empWorkOrder = queueService.getTopWorkOrder();
		checkNotFound(empWorkOrder);
		return empWorkOrder.getId();
	}	
	
	@RequestMapping(value = URIConstants.GETALL_WORKORDER, method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<Long> getAllIds(){
		List<Long> listOfIds = queueService.getSortedIds();
		return listOfIds;
	}
	
	@RequestMapping(value = URIConstants.GETPOS_WORKORDER, method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public long getPos(@PathVariable("id") long id){
		long position = queueService.getIdPosition(id);
		return position;
	}
	
	@RequestMapping(value = URIConstants.REMOVE_WORKORDER, method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public EmployeeWorkOrder removeId(@PathVariable("id") long id){
		EmployeeWorkOrder employeeWorkOrder = queueService.removeId(id);
		checkNotFound(employeeWorkOrder);
		return employeeWorkOrder;
	}
	
	@RequestMapping(value = URIConstants.GETAVGTIME_WORKORDER, method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public double getAvgTime(@PathVariable("id") long id){
		Calendar cal = Calendar.getInstance();
		Date currentDate = cal.getTime();
		double avgTime = queueService.getAverageTime(currentDate);
		return avgTime;
	}
	
	private void checkBadRequest(EmployeeWorkOrder emp){
		if(emp == null){
			throw new BadRequestException();
		}
	}
	
	private void checkNotFound(EmployeeWorkOrder emp){
		if(emp == null){
			throw new NotFoundException();
		}
	}
}
