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
import com.code.service.CourseService;


@Controller
@RequestMapping("/courses")
public class CourseController {
	@Autowired
	private CourseService courseService;

	public CourseController(CourseService theCourseService) {
		courseService = theCourseService;
	}
	
	@GetMapping("/showCourses-list")
	public String showCourses(Model theModel) {
	/*
	 * return courses-list page
	 * */
		// get courses from db
		List<ConnectionWithCourseTable> theCourses = courseService.findAll();
		// add to the spring model
		theModel.addAttribute("courses", theCourses);
		return "courses/courses-list";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		ConnectionWithCourseTable course = new ConnectionWithCourseTable();
		
		theModel.addAttribute("course", course);
		
		return "courses/register_form_for_courses";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("courseId") int theId,Model theModel) {
		List<ConnectionWithCourseTable> theCourses = (List<ConnectionWithCourseTable>) theModel.getAttribute("courses");
		// get the course from the service
		ConnectionWithCourseTable theCourse = courseService.findById(theId);
		
		// set course as a model attribute to pre-populate the form
		theModel.addAttribute("course", theCourse);
		
		// send over to our form
		return "courses/register_form_for_courses";			
	}
	
	
	@PostMapping("/save")
	public String saveCourse(@ModelAttribute("course") ConnectionWithCourseTable theCourse, Model theModel) {
		
		//save the course
		courseService.save(theCourse);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/courses/showCourses-list";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("courseId") int theId) {
		
		// delete the course
		courseService.deleteById(theId);
		
		// redirect to /courses/showCourse
		return "redirect:/courses/showCourses-list";
		
	}
}
