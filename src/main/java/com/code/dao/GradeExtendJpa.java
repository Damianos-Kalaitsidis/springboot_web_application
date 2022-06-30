package com.code.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.code.entity.ConnectionWithGradeTable;

@Repository
public interface GradeExtendJpa extends JpaRepository<ConnectionWithGradeTable, Integer> {
	public List<ConnectionWithGradeTable> findAll();
	public ConnectionWithGradeTable findById(int theId);
	public void deleteById(int theId);
}
