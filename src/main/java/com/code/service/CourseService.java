package com.code.service;

import java.util.List;
import com.code.entity.ConnectionWithCourseTable;

public interface CourseService {
	public List<ConnectionWithCourseTable> findAll();
	
	public ConnectionWithCourseTable findById(int theId);
	
	public void save(ConnectionWithCourseTable theCourse);
	
	public void deleteById(int theId);
}
