package com.code.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This page represents the database of the student's Grade of a particular course
 * */
@Entity
@Table(name="Grades")
public class ConnectionWithGradeTable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="idStudent")
	private int idStudent;
	
	@Column(name="course")
	private String Course;
	
	@Column(name="grade")
	private double Grade;
	
	@Column(name="project")
	private double Project;
	
	@Column(name="FinalGrade")
	private double FinalGrade;
	
	public ConnectionWithGradeTable() {
		// TODO Auto-generated constructor stub
	}
	public ConnectionWithGradeTable(String course) {
		this.Course = course;
	}
	public ConnectionWithGradeTable(int id,int idStudent,String Course,double Grade ,double ProjectGrade) {
		this.id = id;
		this.idStudent = idStudent;
		this.Course = Course;
		this.Grade = Grade;
		this.Project = ProjectGrade;
	}
	public ConnectionWithGradeTable(int idStudent,String Course,double Grade,double ProjectGrade,double FinalGrade) {
		this.idStudent = idStudent;
		this.Course = Course;
		this.Grade = Grade;
		this.Project = ProjectGrade;
		this.Project = ProjectGrade;
		this.FinalGrade = FinalGrade;
	}
	public ConnectionWithGradeTable(int idStudent,String Course,double Grade,double ProjectGrade) {
		this.idStudent = idStudent;
		this.Course = Course;
		this.Grade = Grade;
		this.Project = ProjectGrade;
	}
	// define getter/setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public String getCourse() {
		return Course;
	}

	public void setCourse(String Course) {
		this.Course = Course;
	}

	public double getGrade() {
		return Grade;
	}

	public void setGrade(double Grade) {
		this.Grade = Grade;
	}
	public double getProject() {
		return Project;
	}

	public void setProject(double ProjectGrade) {
		this.Project = ProjectGrade;
	}

	// define tostring
	public void setFinalGrade(Double FinalGrade) {
		this.FinalGrade = FinalGrade;
		
	}
	public double getFinalGrade() {
		return FinalGrade;
		
	}
	@Override
	public String toString() {
		return "Student [id=" + id +" ,idStudent="+idStudent+ ", Course=" + Course + ", Grade=" + Grade + ", ProjectGrade="+Project+"]";
	}
}
