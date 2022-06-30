package com.example1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import com.code.Application;
import com.code.entity.ConnectionWithStudentTable;
import com.code.service.CourseService;
import com.code.service.StudentService;

@SpringBootTest
@ContextConfiguration(classes = {Application.class,StudentService.class})
@TestPropertySource( locations = "classpath:application.properties")
public class TestStudentService {
	@Autowired 
	StudentService studentService;
	
	@Test
	void testStudentDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(studentService);
	}

	@Test
	void testFindByIdReturnsStudent() {
		ConnectionWithStudentTable storedStudent = studentService.findById(1);
		Assertions.assertNotNull(storedStudent);
		Assertions.assertEquals("Eftixia", storedStudent.getFirstName());
	}
}
