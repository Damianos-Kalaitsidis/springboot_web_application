package com.code.service;

import java.util.List;

import com.code.dao.StudentExtendJpa;
import com.code.entity.ConnectionWithStudentTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentsServiceImpl implements StudentService {
	@Autowired
	private StudentExtendJpa StudentRepository;
	
	public StudentsServiceImpl() {
		super();
	}

	@Autowired
	public StudentsServiceImpl(StudentExtendJpa theStudentRepository) {
		StudentRepository = theStudentRepository;
	}
	@Override
	@Transactional
	public List<ConnectionWithStudentTable> findAll() {
		return StudentRepository.findAll();
	}

	@Override
	@Transactional
	public ConnectionWithStudentTable findById(int theId) {
		ConnectionWithStudentTable result = StudentRepository.findById(theId);
		if (result != null ) {
			return result;
		}
		else {
			// we didn't find the student
			System.out.println("Did not find student with id " + theId);
			return null;
		}
	}

	@Override
	@Transactional
	public void save(ConnectionWithStudentTable theStudent) {
		StudentRepository.save(theStudent);

	}
  
	@Override
	@Transactional
	public void deleteById(int theId) {
		StudentRepository.deleteById(theId);
	}
}
