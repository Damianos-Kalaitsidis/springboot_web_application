package com.example1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import com.code.Application;

@SpringBootTest
@ContextConfiguration(classes = {Application.class})
public class ApplicationTest {
	@Test
	public void contextLoads() {
		
	}

}