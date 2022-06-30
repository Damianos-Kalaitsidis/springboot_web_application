package com.code.service;

import java.util.List;

import com.code.entity.StatisticsTable;

public interface StatisticService {

	void save(StatisticsTable theGrade);

	List<StatisticsTable> findAll();

}
