package com.code.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This page represent the database of the statistics
 * */
@Entity
@Table(name="Statistics")
public class StatisticsTable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="min")
	private double min;
	
	@Column(name="max")
	private double max;
	
	@Column(name="mean")
	private double mean;
	
	@Column(name="medianValue")
	private double medianValue;
	
	@Column(name="StandardDeviation")
	private double StandardDeviation;
	
	@Column(name="VarianceValue")
	private double VarianceValue;

	@Column(name="percentilesValue")
	private double percentilesValue;

	@Column(name="Pass")
	private double Pass;

	@Column(name="Fail")
	private double Fail;


	
	public StatisticsTable() {
		// TODO Auto-generated constructor stub
	}

	public StatisticsTable(int id,double min ,double max,double mean ,double medianValue,double Standard ,double Variance,double percentiles,double Pass,double Fail) {
		this.id = id;
		this.min = min;
		this.max = max;
		this.mean = mean ;
		this.medianValue = medianValue;
		this.StandardDeviation = Standard; 
		this.VarianceValue  = Variance;
		this.percentilesValue = percentiles;
		this.Pass = Pass;
		this.Fail = Fail;
	}
	
	// define getter/setter
	public double getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double Max) {
		this.max = Max;
	}
	public double getMean() {
		return mean;
	}

	public void setMean(double Mean) {
		this.mean = Mean;
	}

	public double getMedianValue() {
		return medianValue;
	}

	public void setMedianValue(double MedianValue) {
		this.medianValue = MedianValue;
	}
	public double getStandardDeviation() {
		return StandardDeviation;
	}

	public void setStandardDeviation(double StandardDeviation) {
		this.StandardDeviation = StandardDeviation;
	}
	public double getVarianceValue() {
		return VarianceValue;
	}

	public void setVarianceValue(double VarianceValue) {
		this.VarianceValue = VarianceValue;
	}
	public double getPercentilesValue() {
		return percentilesValue;
	}

	public void setPercentilesValue(double percentilesValue) {
		this.percentilesValue = percentilesValue;
	}
	public double getPass() {
		return Pass;
	}

	public void setPass(double Pass) {
		this.Pass = Pass;
	}
	public double getFail() {
		return Fail;
	}

	public void setFail(double Fail) {
		this.Fail = Fail;
	}
}
