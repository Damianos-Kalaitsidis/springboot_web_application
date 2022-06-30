package com.example1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import com.code.Application;
import com.code.entity.ConnectionWithCourseTable;
import com.code.service.CourseService;

@SpringBootTest
@ContextConfiguration(classes = {Application.class,CourseService.class})
@TestPropertySource( locations = "classpath:application.properties")
public class TestCourseService {
	@Autowired 
	CourseService courseService;
	
	@Test
	void testEmployeeDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(courseService);
	}

	@Test
	void testFindByIdReturnsEmployee() {
		
		ConnectionWithCourseTable storedCourse = courseService.findById(1);
		Assertions.assertNotNull(storedCourse);
		Assertions.assertEquals("Robotiki", storedCourse.getName());
	}
}
