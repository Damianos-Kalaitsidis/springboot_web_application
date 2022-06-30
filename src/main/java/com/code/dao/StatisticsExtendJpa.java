package com.code.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.code.entity.StatisticsTable;

@Repository
public interface StatisticsExtendJpa extends JpaRepository<StatisticsTable, Integer> {
	public List<StatisticsTable> findAll();
	public StatisticsTable findById(int theId);
	public void deleteById(int theId);
	public void save(Double theGrade);
}
