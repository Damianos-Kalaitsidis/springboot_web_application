package com.code.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.code.dao.StatisticsExtendJpa;
import com.code.entity.StatisticsTable;

@Service
public class StatisticServiceImpl implements StatisticService {
	@Autowired
	private StatisticsExtendJpa StatisticRepository;
	
	public StatisticServiceImpl() {
		super();
	}

	@Autowired
	public StatisticServiceImpl(StatisticsExtendJpa theStatisticRepository) {
		StatisticRepository = theStatisticRepository;
	}
	@Override
	@Transactional
	public void save(StatisticsTable theCourse) {
		StatisticRepository.save(theCourse);

	}
	@Override
	@Transactional
	public List<StatisticsTable> findAll() {
		return StatisticRepository.findAll();
	}
}
