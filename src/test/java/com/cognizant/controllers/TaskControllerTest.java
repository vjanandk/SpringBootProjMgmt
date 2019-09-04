package com.cognizant.controllers;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.models.Tasks;
import com.cognizant.repositories.TasksRepo;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TaskController.class)
public class TaskControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TasksRepo tasksRepo;

	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	@Test
	public void gettasks() throws Exception {

		Date startDate = format.parse("2019-09-01");
		Date endDate = format.parse("2019-12-31");
		String expected = "[{\"taskId\":1,\"parentId\":1,\"projId\":1,\"taskName\":\"Mock Project Name 1\",\"taskStartDate\":\"2019-09-01T05:00:00.000+0000\",\"taskEndDate\":\"2019-12-31T06:00:00.000+0000\",\"taskPriority\":20,\"taskStatus\":\"In Progress\"},{\"taskId\":2,\"parentId\":2,\"projId\":2,\"taskName\":\"Mock Project Name 2\",\"taskStartDate\":\"2019-09-01T05:00:00.000+0000\",\"taskEndDate\":\"2019-12-31T06:00:00.000+0000\",\"taskPriority\":30,\"taskStatus\":\"In Progress\"}]";

		Tasks task1 = new Tasks();
		task1.setTaskId(1);
		task1.setProjId(1);
		task1.setParentId(1);
		task1.setTaskStartDate(startDate);
		task1.setTaskEndDate(endDate);
		task1.setTaskName("Mock Project Name 1");
		task1.setTaskPriority(20);
		task1.setTaskStatus("In Progress");

		Tasks task2 = new Tasks();
		task2.setTaskId(2);
		task2.setProjId(2);
		task2.setParentId(2);
		task2.setTaskStartDate(startDate);
		task2.setTaskEndDate(endDate);
		task2.setTaskName("Mock Project Name 2");
		task2.setTaskPriority(30);
		task2.setTaskStatus("In Progress");

		List<Tasks> mockTaskList = new LinkedList<>();
		mockTaskList.add(task1);
		mockTaskList.add(task2);

		Mockito.when(tasksRepo.findAll()).thenReturn(mockTaskList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/tasks").accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(mvcResult.getResponse());
		System.out.println("Test Out :" + mvcResult.getResponse().getContentAsString());

		JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);
	}

	@Test
	public void posttasks() throws Exception {

		Date startDate = format.parse("2019-09-01");
		Date endDate = format.parse("2019-12-31");
		String sampleContent = "{\"taskId\":1,\"parentId\":1,\"projId\":1,\"taskName\":\"Mock Project Name 1\",\"taskStartDate\":\"2019-09-01T05:00:00.000+0000\",\"taskEndDate\":\"2019-12-31T06:00:00.000+0000\",\"taskPriority\":20,\"taskStatus\":\"In Progress\"}";

		Tasks mockTask = new Tasks();
		mockTask.setTaskId(1);
		mockTask.setProjId(1);
		mockTask.setParentId(1);
		mockTask.setTaskStartDate(startDate);
		mockTask.setTaskEndDate(endDate);
		mockTask.setTaskName("Mock Project Name 1");
		mockTask.setTaskPriority(20);
		mockTask.setTaskStatus("In Progress");

		Mockito.when(tasksRepo.save(Mockito.any(Tasks.class))).thenReturn(mockTask);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/tasks").accept(MediaType.APPLICATION_JSON)
				.content(sampleContent).contentType(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse httpResponse = mvcResult.getResponse();
		assertEquals(HttpStatus.OK.value(), httpResponse.getStatus());

	}
	
	@Test
	public void puttasks() throws Exception {

		Date startDate = format.parse("2019-09-01");
		Date endDate = format.parse("2019-12-31");
		String sampleContent = "{\"taskId\":1,\"parentId\":1,\"projId\":1,\"taskName\":\"Mock Project Name 1\",\"taskStartDate\":\"2019-09-01T05:00:00.000+0000\",\"taskEndDate\":\"2019-12-31T06:00:00.000+0000\",\"taskPriority\":20,\"taskStatus\":\"In Progress\"}";

		Tasks mockTask = new Tasks();
		mockTask.setTaskId(1);
		mockTask.setProjId(1);
		mockTask.setParentId(1);
		mockTask.setTaskStartDate(startDate);
		mockTask.setTaskEndDate(endDate);
		mockTask.setTaskName("Mock Project Name 1");
		mockTask.setTaskPriority(20);
		mockTask.setTaskStatus("In Progress");

		Mockito.when(tasksRepo.save(Mockito.any(Tasks.class))).thenReturn(mockTask);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/tasks").accept(MediaType.APPLICATION_JSON)
				.content(sampleContent).contentType(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse httpResponse = mvcResult.getResponse();
		assertEquals(HttpStatus.OK.value(), httpResponse.getStatus());

	}

}
