package com.code.service;
import java.util.List;

import com.code.dao.CourseExtendJpa;
import com.code.entity.ConnectionWithCourseTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseExtendJpa CourseRepository;
	
	public CourseServiceImpl() {
		super();
	}

	@Autowired
	public CourseServiceImpl(CourseExtendJpa theCourseRepository) {
		CourseRepository = theCourseRepository;
	}
	@Override
	@Transactional
	public List<ConnectionWithCourseTable> findAll() {
		return CourseRepository.findAll();
	}

	@Override
	@Transactional
	public ConnectionWithCourseTable findById(int theId) {
		ConnectionWithCourseTable result = CourseRepository.findById(theId);
		if (result != null ) {
			return result;
		}
		else {
			// we didn't find the student
			System.out.println("Did not find course id - " + theId);
			return null;
		}
	}

	@Override
	@Transactional
	public void save(ConnectionWithCourseTable theCourse) {
		CourseRepository.save(theCourse);

	}
	
	@Override
	@Transactional
	public void deleteById(int theId) {
		CourseRepository.deleteById(theId);
	}
}
