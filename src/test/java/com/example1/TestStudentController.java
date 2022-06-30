package com.example1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import com.code.Application;
import com.code.controller.CourseController;
import com.code.controller.StudentController;
import com.code.entity.ConnectionWithCourseTable;
import com.code.entity.ConnectionWithStudentTable;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ContextConfiguration(classes = {Application.class,StudentController.class})
@AutoConfigureMockMvc
public class TestStudentController {
	@Autowired
    private WebApplicationContext context;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	StudentController studentController;

	@BeforeEach
    public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
	
	@Test
	void testCourseControllerIsNotNull() {
		Assertions.assertNotNull(studentController);
	}
	
	@Test
	void testMockMvcIsNotNull() {
		Assertions.assertNotNull(mockMvc);
	}
	
	
	@WithMockUser(value = "Mr.Zarras")
	@Test 
	void testListCoursesReturnsPage() throws Exception {
		mockMvc.perform(get("/courses/showCourses-list")).
		andExpect(status().isOk()).
		andExpect(model().attributeExists("courses")).
		andExpect(view().name("courses/courses-list"));		
		
		/*
		 * A way to check stuff that are in the model
		 * andExpect(MockMvcResultMatchers.model().attribute("msg", "Hi there, Joe."))
		 */
	}

	@WithMockUser(value = "Mr.Zarras")
	@Test 
	void testSaveCourseReturnsPage() throws Exception {
		
	    ConnectionWithStudentTable student = new ConnectionWithStudentTable(0,4441,"Eftixia", "Bourli","eftixia@gmail.com");
	    	    
	    MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
	    multiValueMap.add("id", Integer.toString(student.getId()));
	    multiValueMap.add("First Name", student.getFirstName());
	    multiValueMap.add("Last Name", student.getLastName());
	    multiValueMap.add("Email", student.getEmail());
	 
		mockMvc.perform(
				post("/students/save").
			    params(multiValueMap)).
				andExpect(status().isFound()).
				andExpect(view().name("redirect:/students/showStudents-list"));	
	}
}
