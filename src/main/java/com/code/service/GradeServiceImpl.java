package com.code.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.code.dao.GradeExtendJpa;
import com.code.entity.ConnectionWithGradeTable;


@Service
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeExtendJpa GradeRepository;
	
	public GradeServiceImpl() {
		super();
	}

	@Autowired
	public GradeServiceImpl(GradeExtendJpa theGradeRepository) {
		GradeRepository = theGradeRepository;
	}
	@Override
	@Transactional
	public List<ConnectionWithGradeTable> findAll() {
		return GradeRepository.findAll();
	}
	@Override
	@Transactional
	public ConnectionWithGradeTable findById(int theId) {
		ConnectionWithGradeTable result = GradeRepository.findById(theId);
		if (result != null ) {
			return result;
		}
		else {
			// we didn't find the student
			throw new RuntimeException("Did not find student id - " + theId);
		}
	}
	@Override
	@Transactional
	public void save(ConnectionWithGradeTable theStudent) {
		GradeRepository.save(theStudent);

	}
  
	@Override
	@Transactional
	public void deleteById(int theId) {
		GradeRepository.deleteById(theId);
	}
}
