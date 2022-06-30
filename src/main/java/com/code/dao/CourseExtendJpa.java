package com.code.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.code.entity.ConnectionWithCourseTable;

@Repository
public interface CourseExtendJpa extends JpaRepository<ConnectionWithCourseTable, Integer> {
	public List<ConnectionWithCourseTable> findAll();
	public ConnectionWithCourseTable findById(int theId);	
	public void deleteById(int theId);
}
