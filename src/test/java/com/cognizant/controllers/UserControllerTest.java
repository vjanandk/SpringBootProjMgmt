package com.cognizant.controllers;

import static org.junit.Assert.assertEquals;

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

import com.cognizant.models.Users;
import com.cognizant.repositories.UsersRepo;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UsersRepo usersRepo;

	@Test
	public void getusers() throws Exception {

		String expected = "[{\"userId\":1,\"projId\":1,\"taskId\":1,\"firstName\":\"Vijay\",\"lastName\":\"Kannadasan\",\"empId\":1},{\"userId\":2,\"projId\":2,\"taskId\":2,\"firstName\":\"Anand\",\"lastName\":\"Kannadasan\",\"empId\":2}]";

		Users users1 = new Users();
		users1.setUserId(1);
		users1.setProjId(1);
		users1.setTaskId(1);
		users1.setEmpId(1);
		users1.setFirstName("Vijay");
		users1.setLastName("Kannadasan");

		Users users2 = new Users();
		users2.setUserId(2);
		users2.setProjId(2);
		users2.setTaskId(2);
		users2.setEmpId(2);
		users2.setFirstName("Anand");
		users2.setLastName("Kannadasan");

		List<Users> mockUsersList = new LinkedList<>();
		mockUsersList.add(users1);
		mockUsersList.add(users2);

		Mockito.when(usersRepo.findAll()).thenReturn(mockUsersList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/users").accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(mvcResult.getResponse());
		System.out.println("Test Out :" + mvcResult.getResponse().getContentAsString());
		JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);

	}

	@Test
	public void postuser() throws Exception {

		String sampleContent = "{\"userId\":1,\"projId\":1,\"taskId\":1,\"firstName\":\"Vijay\",\"lastName\":\"Kannadasan\",\"empId\":1}";

		Users mockUser = new Users();
		mockUser.setUserId(1);
		mockUser.setProjId(1);
		mockUser.setTaskId(1);
		mockUser.setEmpId(1);
		mockUser.setFirstName("Vijay");
		mockUser.setLastName("Kannadasan");

		Mockito.when(usersRepo.save(Mockito.any(Users.class))).thenReturn(mockUser);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/users").accept(MediaType.APPLICATION_JSON)
				.content(sampleContent).contentType(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse httpResponse = mvcResult.getResponse();
		assertEquals(HttpStatus.OK.value(), httpResponse.getStatus());
//		assertEquals("http://localhost/api/parenttasks", httpResponse.getHeader(HttpHeaders.LOCATION));
	}
	
	@Test
	public void putuser() throws Exception {

		String sampleContent = "{\"userId\":1,\"projId\":1,\"taskId\":1,\"firstName\":\"Vijay\",\"lastName\":\"Kannadasan\",\"empId\":1}";

		Users mockUser = new Users();
		mockUser.setUserId(1);
		mockUser.setProjId(1);
		mockUser.setTaskId(1);
		mockUser.setEmpId(1);
		mockUser.setFirstName("Vijay");
		mockUser.setLastName("Kannadasan");

		Mockito.when(usersRepo.save(Mockito.any(Users.class))).thenReturn(mockUser);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/users").accept(MediaType.APPLICATION_JSON)
				.content(sampleContent).contentType(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse httpResponse = mvcResult.getResponse();
		assertEquals(HttpStatus.OK.value(), httpResponse.getStatus());
//		assertEquals("http://localhost/api/parenttasks", httpResponse.getHeader(HttpHeaders.LOCATION));
	}

}
