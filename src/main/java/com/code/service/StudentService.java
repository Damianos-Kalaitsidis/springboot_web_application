package com.code.service;
import java.util.List;

import com.code.entity.ConnectionWithStudentTable;

public interface StudentService {
	public List<ConnectionWithStudentTable> findAll();
	
	public ConnectionWithStudentTable findById(int theId);
	
	public void save(ConnectionWithStudentTable theStudent);
	
	public void deleteById(int theId);
}
