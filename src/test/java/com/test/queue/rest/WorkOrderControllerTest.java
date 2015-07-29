package com.test.queue.rest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.queue.model.URIConstants;
import com.queue.spring.SpringConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfiguration.class)
@WebAppConfiguration
public class WorkOrderControllerTest {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;

	
    @Before
    public void setUp() throws Exception{
    	mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    	
    	mockMvc.perform(MockMvcRequestBuilders.get(URIConstants.ADD_WORKORDER + "?id=10&date=2015-7-27_09:18:22"))
			.andExpect(MockMvcResultMatchers.status().isCreated()).andDo(MockMvcResultHandlers.print());
	
    	mockMvc.perform(MockMvcRequestBuilders.get(URIConstants.ADD_WORKORDER + "?id=15&date=2015-7-27_09:19:23"))
    		.andExpect(MockMvcResultMatchers.status().isCreated()).andDo(MockMvcResultHandlers.print());
    	
    	mockMvc.perform(MockMvcRequestBuilders.get(URIConstants.ADD_WORKORDER + "?id=30&date=2015-7-27_09:19:21"))
			.andExpect(MockMvcResultMatchers.status().isCreated()).andDo(MockMvcResultHandlers.print());
    }
	
	@Test
	public void testRestGetAll() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get(URIConstants.GETALL_WORKORDER))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
	}
	
	@After
	public void testRemoveAndGetTopId() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get(URIConstants.GET_WORKORDER))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
		
		long id = 10;
		mockMvc.perform(MockMvcRequestBuilders.get(URIConstants.REMOVE_WORKORDER, id))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
		
		mockMvc.perform(MockMvcRequestBuilders.get(URIConstants.GETPOS_WORKORDER, id))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
	}
}
