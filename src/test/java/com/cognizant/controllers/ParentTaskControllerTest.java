package com.cognizant.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.models.ParentTasks;
import com.cognizant.repositories.ParentTasksRepo;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ParentTaskController.class, secure = false)
public class ParentTaskControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ParentTasksRepo parentTasksRepo;

	@Test
	public void getParentTasks() throws Exception {
		List mockPtasksList = new LinkedList<>();
		mockPtasksList.add(new ParentTasks(1, "Mock Parent Task Name 1"));
		mockPtasksList.add(new ParentTasks(2, "Mock Parent Task Name 2"));

		Mockito.when(parentTasksRepo.findAll()).thenReturn(mockPtasksList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/parenttasks")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
//		System.out.println(mvcResult.getResponse());
//		System.out.println("Test Out :" + mvcResult.getResponse().getContentAsString());
		String expected = "[{\"parentId\":1,\"taskNameParent\":\"Mock Parent Task Name 1\"},{\"parentId\":2,\"taskNameParent\":\"Mock Parent Task Name 2\"}]";
		JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);
	}

	@Test
	public void addParentTasks() throws Exception {
		ParentTasks mockPtasks = new ParentTasks(1, "Mock Parent Task Name 1");
		String sampleContent = "{\"parentId\":1,\"taskNameParent\":\"Mock Parent Task Name 1\"}";

		Mockito.when(parentTasksRepo.save(Mockito.any(ParentTasks.class))).thenReturn(mockPtasks);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/parenttasks")
				.accept(MediaType.APPLICATION_JSON).content(sampleContent).contentType(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse httpResponse = mvcResult.getResponse();
//		System.out.println("Test Out Http Status : " + httpResponse.getStatus());
		assertEquals(HttpStatus.OK.value(), httpResponse.getStatus());
//		assertEquals("http://localhost/api/parenttasks", httpResponse.getHeader(HttpHeaders.LOCATION));
	}

}
