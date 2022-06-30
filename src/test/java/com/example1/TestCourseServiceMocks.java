package com.example1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.code.entity.ConnectionWithCourseTable;
import com.code.service.CourseService;
import com.code.service.CourseServiceImpl;


@ExtendWith(SpringExtension.class)
public class TestCourseServiceMocks {
	@TestConfiguration
    static class CourseServiceImplTestContextConfiguration {
 
        @Bean
        public CourseService courseService() {
            return new CourseServiceImpl();
        }
    }

	@Autowired 
	CourseService courseService;
	
	@MockBean
	CourseService courseDAO;
	
	@Test
	void testCourseDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(courseService);
	}

	@Test
	void testFindByIdReturnsCourse() {
		Mockito.when(courseDAO.findById(1)).thenReturn(new ConnectionWithCourseTable(0, "Robotiki", "","", ""));
		ConnectionWithCourseTable storedCourse = courseService.findById(1);
		Assertions.assertNotNull(storedCourse);
		Assertions.assertEquals("Robotiki", storedCourse.getName());
	}
	/*
	 * See also Mockito.mock(), Mockito.spy(), Mockito.verify(<objectCalled>).<methodCalled>()
	 * 
	 */
}
