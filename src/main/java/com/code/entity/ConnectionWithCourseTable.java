package com.code.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This page represent the database of the courses 
 * */
@Entity
@Table(name="courses")

public class ConnectionWithCourseTable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="year")
	private String Year;
	
	@Column(name="semester")
	private String Semester;
	
	@Column(name="syllabus")
	private String Syllabus;

	@Column(name="Exam")
	private double Exam;
	
	@Column(name="Project")
	private double Project;

	public ConnectionWithCourseTable() {
		// TODO Auto-generated constructor stub
	}
	public ConnectionWithCourseTable(int id,String name, String year,String semester, String Syllabus) {
		this.id = id;
		this.name = name;
		this.Year = year;
		this.Semester = semester;
		this.Syllabus = Syllabus;
	}

	public ConnectionWithCourseTable(String name, String year,String semester,double exam ,double project) {
		this.name = name;
		this.Year = year;
		this.Semester = semester;
		this.Exam = exam;
		this.Project = project;
	}

	// define getter/setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return Year;
	}

	public void setYear(String Year) {
		this.Year = Year;
	}

	public String getSemester() {
		return Semester;
	}

	public void setSemester(String Semester) {
		this.Semester = Semester;
	}
	public String getSyllabus() {
		return Syllabus;
	}

	public void setSyllabus(String Syllabus) {
		this.Syllabus = Syllabus;
	}
	
	
	public double getExam() {
		return Exam;
	}

	public void setExam(double exam) {
		this.Exam = exam;
	}
	
	public double getProject() {
		return Project;
	}

	public void setProject(double project) {
		this.Project = project;
	}
	// define tostring

	@Override
	public String toString() {
		return "Course [id=" + id + ", Name=" + name + ", Year=" + Year + ", Semester=" + Semester + ", Syllabus=" + Syllabus +", exam="+Exam+", project="+Project+ "]";
	}
}

