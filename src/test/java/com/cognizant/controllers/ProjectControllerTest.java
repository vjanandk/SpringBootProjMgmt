package com.cognizant.controllers;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.models.Projects;
import com.cognizant.repositories.ProjectsRepo;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProjectController.class, secure = false)
public class ProjectControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProjectsRepo projectsRepo;

	
	@Test
	public void getprojects() throws Exception {
		List mockProjectsList = new LinkedList<>();
		mockProjectsList
				.add(new Projects(1, "Mock Project Name 1", new Date(2019, 9, 1), new Date(2019, 12, 31), 90));
		mockProjectsList
				.add(new Projects(2, "Mock Project Name 2", new Date(2019, 9, 1), new Date(2019, 12, 31), 80));

		Mockito.when(projectsRepo.findAll()).thenReturn(mockProjectsList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/projects").accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(mvcResult.getResponse());
		System.out.println("Test Out :" + mvcResult.getResponse().getContentAsString());
//		String expected = 
	}
}
