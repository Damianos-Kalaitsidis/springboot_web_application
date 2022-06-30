package com.example1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import com.code.Application;
import com.code.dao.StudentExtendJpa;
import com.code.entity.ConnectionWithStudentTable;

@SpringBootTest
@ContextConfiguration(classes = {Application.class})
@TestPropertySource(locations = "classpath:application.properties")
public class TestStudentExtendJpa {
	@Autowired 
	private StudentExtendJpa studentDAO;

	
	@Test
	void testStudentDAOJpaImplIsNotNull() {
		
		Assertions.assertNotNull(studentDAO);
	}
	@Test
	void testFindByIdReturnsStudent() {
		    
		ConnectionWithStudentTable storedStudent = studentDAO.findById(1);
		Assertions.assertNotNull(storedStudent);
		Assertions.assertEquals("Damianos", storedStudent.getFirstName());
		Assertions.assertEquals("Kalaitsidis", storedStudent.getLastName());
	}

}
