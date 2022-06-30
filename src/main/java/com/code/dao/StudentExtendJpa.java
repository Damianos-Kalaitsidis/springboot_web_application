package com.code.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.code.entity.ConnectionWithStudentTable;

@Repository
public interface StudentExtendJpa extends JpaRepository<ConnectionWithStudentTable, Integer> {
	public List<ConnectionWithStudentTable> findAll();
	public ConnectionWithStudentTable findById(int theId);
	public void deleteById(int theId);
}