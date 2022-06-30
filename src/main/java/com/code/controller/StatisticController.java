package com.code.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.code.entity.ConnectionWithGradeTable;
import com.code.entity.StatisticsTable;
import com.code.service.GradeService;
import com.code.service.StatisticService;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.stat.descriptive.rank.Median;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;

@Controller
@RequestMapping("/statistics")
public class StatisticController {
	@Autowired
	private GradeService gradeService;
	@Autowired
	private StatisticService statisticService;

	public StatisticController(StatisticService statisticService,GradeService theGradeService) {
		gradeService = theGradeService;
		statisticService = statisticService;
	}
	
	@GetMapping("/Show-statistics")
	public String showStatistics(Model theModel) {
	/*
	 * return Statistics-list page
	 * */
		List<ConnectionWithGradeTable> theGrades = gradeService.findAll();
		theModel.addAttribute("grades", theGrades);
		return "statistics/statistic";
	}
	@GetMapping("/Show-stats")
	public String Showstats(@RequestParam("exam") double exam ,@RequestParam("project") double project ,Model theModel) {
		List<ConnectionWithGradeTable> theGrades = gradeService.findAll();
		List<Double> FinalGrade =new ArrayList<Double>();
		List<StatisticsTable> theStats = null;
		double sum = 0;
		double min, max,mean,StandardDeviation,VarianceValue,medianValue,percentilesValue;
		Median median = new Median();
		StandardDeviation standard =new StandardDeviation();
		Variance variance = new Variance();
		Percentile percentiles = new Percentile(); 
		int pass = 0,percentPass=0;
		for(int i = 0;i < theGrades.size();i++) {
			System.out.println("yes! results");
			FinalGrade.add(theGrades.get(i).getGrade()*exam + theGrades.get(i).getProject()*project);
			sum+=FinalGrade.get(i);
			if(FinalGrade.get(i) >= 5)pass+=1;
		}
		if(FinalGrade.size() >0) {
			percentPass = (pass*100)/FinalGrade.size();
			double[] Array = new double[FinalGrade.size()];
			Collections.sort(FinalGrade);
			min =  FinalGrade.get(0);
			max =  FinalGrade.get(FinalGrade.size()-1);
			mean = sum/FinalGrade.size();
			
			for (int i = 0; i < FinalGrade.size(); i++) {
				Array[i] = FinalGrade.get(i);				
			}
			medianValue = median.evaluate(Array);
			StandardDeviation = standard.evaluate(Array);
			VarianceValue = variance.evaluate(Array);
			percentiles.setData(Array);
			percentilesValue = percentiles.evaluate();
			StatisticsTable stats = new StatisticsTable(1,min,max,mean,medianValue,StandardDeviation,VarianceValue,percentilesValue,percentPass,100-percentPass);
			statisticService.save(stats);
			theStats = statisticService.findAll();
		}
		else {
			System.out.println("NO! results");
		}
		theModel.addAttribute("stats", theStats);
		return "statistics/stats-list";
	}
}
