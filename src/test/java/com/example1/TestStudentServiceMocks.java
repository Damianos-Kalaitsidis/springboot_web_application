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
import com.code.entity.ConnectionWithStudentTable;
import com.code.service.CourseService;
import com.code.service.CourseServiceImpl;
import com.code.service.StudentService;
import com.code.service.StudentsServiceImpl;


@ExtendWith(SpringExtension.class)
public class TestStudentServiceMocks {
	@TestConfiguration
    static class StudentServiceImplTestContextConfiguration {
 
        @Bean
        public StudentService StudentService() {
            return new StudentsServiceImpl();
        }
    }

	@Autowired 
	StudentService studentService;
	
	@MockBean
	StudentService studentDAO;
	
	@Test
	void testCourseDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(studentService);
	}

	@Test
	void testFindByIdReturnsCourse() {
		Mockito.when(studentDAO.findById(1)).thenReturn(new ConnectionWithStudentTable(0,4370,"Damianos","Kalaitsidis","dam@gmail.com"));
		ConnectionWithStudentTable storedCourse = studentService.findById(1);
		Assertions.assertNotNull(storedCourse);
		Assertions.assertEquals(4370, storedCourse.getIdStudent());
		Assertions.assertEquals("Damianos", storedCourse.getFirstName());
		Assertions.assertEquals("Kalaitsidis", storedCourse.getLastName());
	}
}
