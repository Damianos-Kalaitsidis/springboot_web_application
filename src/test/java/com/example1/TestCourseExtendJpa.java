package com.example1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import com.code.Application;
import com.code.dao.CourseExtendJpa;
import com.code.entity.ConnectionWithCourseTable;

@SpringBootTest
@ContextConfiguration(classes = {Application.class})
@TestPropertySource(locations = "classpath:application.properties")
public class TestCourseExtendJpa {
	@Autowired 
	private CourseExtendJpa courseDAO;

	
	@Test
	void testCourseDAOJpaImplIsNotNull() {
		
		Assertions.assertNotNull(courseDAO);
	}
	@Test
	void testFindByIdReturnsCourse() {
		    
		ConnectionWithCourseTable storedCourse = courseDAO.findById(1);
		Assertions.assertNotNull(storedCourse);
		Assertions.assertEquals("Texnologia Logismikou", storedCourse.getName());
	}

}
