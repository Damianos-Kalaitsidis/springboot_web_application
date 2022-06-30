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
import com.code.entity.ConnectionWithStudentTable;
import com.code.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService studentService;  
	
	public StudentController() {
		
	}

	public StudentController(StudentService theStudentService) {
		studentService = theStudentService;
	}
	
	@GetMapping("/showStudents-list")
	public String showStudents(Model theModel) {
	/*
	 * return students-list page
	 * */
		// get employees from db
		List<ConnectionWithStudentTable>TheStudents = studentService.findAll();
		// add to the spring model
		theModel.addAttribute("students", TheStudents);
		return "students/students-list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		ConnectionWithStudentTable student = new ConnectionWithStudentTable();
		
		theModel.addAttribute("student", student);
		
		return "students/register_form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId,Model theModel) {
		List<ConnectionWithStudentTable> theStudents = (List<ConnectionWithStudentTable>) theModel.getAttribute("students");
		// get the student from the service
		ConnectionWithStudentTable theStudent = studentService.findById(theId);
		
		// set student as a model attribute to pre-populate the form
		theModel.addAttribute("student", theStudent);
		
		// send over to our form
		return "students/register_form";			
	}
	
	
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") ConnectionWithStudentTable theStudent, Model theModel) {
		
		// save the student
		studentService.save(theStudent);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/students/showStudents-list";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {
		
		// delete the student
		studentService.deleteById(theId);
		
		// redirect to /students/showStudents
		return "redirect:/students/showStudents-list";
	}
	
}
