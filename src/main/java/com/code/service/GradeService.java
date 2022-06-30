package com.code.service;

import java.util.List;

import com.code.entity.ConnectionWithGradeTable;

public interface GradeService {

	public List<ConnectionWithGradeTable> findAll();

	public ConnectionWithGradeTable findById(int theId);
	public void save(ConnectionWithGradeTable theGrade);
	public void deleteById(int theId);

}
