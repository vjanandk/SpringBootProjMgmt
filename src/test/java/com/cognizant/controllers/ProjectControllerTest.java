package com.cognizant.controllers;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.validator.internal.util.privilegedactions.NewProxyInstance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
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

	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

	@Test
	public void getprojects() throws Exception {

		Date startDate = format.parse("01-09-2019");
		Date endDate = format.parse("31-12-2019");
		String expected = "[{\"projId\":1,\"projName\":\"Mock Project Name 1\",\"projStartDate\":\"2019-09-01T05:00:00.000+0000\",\"projEndDate\":\"2019-12-31T06:00:00.000+0000\",\"projPriority\":20},{\"projId\":2,\"projName\":\"Mock Project Name 2\",\"projStartDate\":\"2019-09-01T05:00:00.000+0000\",\"projEndDate\":\"2019-12-31T06:00:00.000+0000\",\"projPriority\":15}]";
		
		Projects proj1 = new Projects();
		proj1.setProjId(1);
		proj1.setProjName("Mock Project Name 1");
		proj1.setProjStartDate(startDate);
		proj1.setProjEndDate(endDate);
		proj1.setProjPriority(20);

		Projects proj2 = new Projects();
		proj2.setProjId(2);
		proj2.setProjName("Mock Project Name 2");
		proj2.setProjStartDate(startDate);
		proj2.setProjEndDate(endDate);
		proj2.setProjPriority(15);

		List mockProjectsList = new LinkedList<>();
		mockProjectsList.add(proj1);
		mockProjectsList.add(proj2);

		Mockito.when(projectsRepo.findAll()).thenReturn(mockProjectsList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/projects").accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
	
		System.out.println(mvcResult.getResponse());
		System.out.println("Test Out :" + mvcResult.getResponse().getContentAsString());
		
		JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);
	}

	@Test
	public void postproject() throws Exception {

		Date startDate = format.parse("01-09-2019");
		Date endDate = format.parse("31-12-2019");

		Projects proj = new Projects();
		proj.setProjId(1);
		proj.setProjName("Mock Project Name");
		proj.setProjStartDate(startDate);
		proj.setProjEndDate(endDate);
		proj.setProjPriority(30);

		String sampleContent = "{\"projId\":1,\"projName\":\"Mock Project Name\",\"projStartDate\":\"2019-09-01T05:00:00.000+0000\",\"projEndDate\":\"2019-12-31T06:00:00.000+0000\",\"projPriority\":30}";

		Mockito.when(projectsRepo.save(Mockito.any(Projects.class))).thenReturn(proj);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/projects").accept(MediaType.APPLICATION_JSON)
				.content(sampleContent).contentType(MediaType.APPLICATION_JSON);
		
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse httpResponse = mvcResult.getResponse();
		assertEquals(HttpStatus.OK.value(), httpResponse.getStatus());
//		assertEquals("http://localhost/api/parenttasks", httpResponse.getHeader(HttpHeaders.LOCATION));
	}
}
