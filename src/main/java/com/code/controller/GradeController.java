package com.code.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.code.entity.ConnectionWithCourseTable;
import com.code.entity.ConnectionWithGradeTable;
import com.code.entity.ConnectionWithStudentTable;
import com.code.service.CourseService;
import com.code.service.GradeService;
import com.code.service.StudentService;

@Controller
@RequestMapping("/grades")
public class GradeController {
	@Autowired
	private GradeService gradeService;
	@Autowired
	private StudentService studentService; 
	@Autowired
	private CourseService courseService;
	private int CourseId; 
	public GradeController(GradeService theGradeService, StudentService theStudentService,CourseService courseService) {
		gradeService = theGradeService;
		studentService = theStudentService;
		this.courseService = courseService;
	}
	
	@GetMapping("/showGrades-list")
	public String showGrades(Model theModel) {
	/*
	 * return Grades-list page
	 * */
		// get Grades from db
		List<ConnectionWithGradeTable> theGrades = gradeService.findAll();
		// add to the spring model
		theModel.addAttribute("grades", theGrades);
				
		return "grade/Grade-list";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(@RequestParam("courseName") String theName,@RequestParam("courseId") int theId,Model theModel) {
		
		// create model attribute to bind form data
		ConnectionWithGradeTable grade = new ConnectionWithGradeTable(theName);
		this.CourseId = theId;
		theModel.addAttribute("grade", grade);
		
		return "grade/register_form_for_grade";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("gradeId") int theId,Model theModel) {
		List<ConnectionWithGradeTable> theGrades = (List<ConnectionWithGradeTable>) theModel.getAttribute("grades");
		// get the Grades from the service
		ConnectionWithGradeTable theGrade = gradeService.findById(theId);
		// set Grades as a model attribute to pre-populate the form
		theModel.addAttribute("grade", theGrade);
		
		return "grade/update_form_for_grade";			
	}
	@GetMapping("/ShowStudentFromCourse")
	public String ShowStudentFromCourse(@RequestParam("courseId") String theId,Model theModel) 
	{
		List<ConnectionWithGradeTable> theGrade = gradeService.findAll();
		List<ConnectionWithGradeTable> theGrades = theGrade;
		int i,N;
		N=theGrade.size();
		for(i=N-1;i>=0;i--) {
			if(!(theGrade.get(i).getCourse().contentEquals(theId)))theGrades.remove(theGrade.get(i));
		}
		// add to the spring model
		theModel.addAttribute("grades", theGrades);
		
		return "grade/Grade-list";
	}
	@PostMapping("/save")
	public String saveGrade(@ModelAttribute("grade") ConnectionWithGradeTable theGrade, Model theModel) {
		List<ConnectionWithStudentTable> theStudents = studentService.findAll();
		ConnectionWithCourseTable theCourse = courseService.findById(CourseId);
		int i,flag=0;
		double finaly = (theGrade.getGrade()*theCourse.getExam()) + (theGrade.getProject()*theCourse.getProject());
		theGrade.setFinalGrade(finaly);
		for(i=0;i<theStudents.size();i++) {
			if(theGrade.getIdStudent() == theStudents.get(i).getIdStudent()) {
				gradeService.save(theGrade);
				flag=1;
				break;
			}
			else continue;
		}
		if(flag == 0) {
			System.out.println("Student can not be found !");
		}
		// use a redirect to prevent duplicate submissions
		return "redirect:/courses/showCourses-list";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("gradeId") int theId) {
		
		// delete the Grade
		gradeService.deleteById(theId);
		
		// redirect to /courses/showCourse
		return "redirect:/grades/showGrades-list";
		
	}
	@PostMapping("/saveAfterUpdate")
	public String saveAfterUpdate(@ModelAttribute("grade") ConnectionWithGradeTable theGrade, Model theModel) {
		List<ConnectionWithStudentTable> theStudents = studentService.findAll();
		ConnectionWithCourseTable theCourse = courseService.findById(CourseId);
		double finaly = (theGrade.getGrade()*theCourse.getExam()) + (theGrade.getProject()*theCourse.getProject());
		theGrade.setFinalGrade(finaly);
		
		gradeService.save(theGrade);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/grades/showGrades-list";
	}
}
