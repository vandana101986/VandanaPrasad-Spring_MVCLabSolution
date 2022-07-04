package com.gl.debateEvent.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.gl.debateEvent.entity.Student;
import com.gl.debateEvent.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	//spring managed
	@Autowired
	private StudentService studService;

	//get list of all students
	@RequestMapping("/list")
	public String showAllStudents(Model model) {
		List<Student> studentList = studService.showAll();
		model.addAttribute("studList", studentList);
		return "students";
	}
	
	//Add/Edit student record form
	@RequestMapping("/addOrEditRecord")
	public String goToForm(@RequestParam("studId") Integer id, Model model) 
	{
		if (id != 0) {
			Student student = studService.findById(id);
			model.addAttribute("stud", student);
		}
		else
		{
			Student student=new Student();			
			model.addAttribute("stud",student);
		}
		return "studentForm";
	}


	//save student record
	@RequestMapping("/save")
	public String save(Integer studId, 
			@RequestParam("fName") String firstName, 
			@RequestParam("lName") String lastName,
			@RequestParam("country") String country) 
	{
		Student s;
		if (studId != 0) {
			s = studService.findById(studId);
			s.setFirstName(firstName);
			s.setLastName(lastName);
			s.setCountry(country);
		} else {
			// if id does not exist, create it
			s = new Student(firstName, lastName, country);

	}
		// addStudent() consists save & update functions
		studService.addStudent(s);
		return "redirect:list";
	}
	
	//delete a student's record
	@RequestMapping("/deleteRecord")
	public String deleteRecord(@RequestParam("studId") Integer id) 
	{
		Student s=null;
		if (id !=0) {
			s=studService.findById(id);
			studService.deleteStudentRecord(s);
		}
		return "redirect:list";
	}

	//search for student list based on country
	@RequestMapping("/searchByCountry")
	public String searchByCountry(@RequestParam("country") String country, Model model) {
		List<Student> studentList = studService.searchByCountry(country);
		if (!studentList.isEmpty()) {
			model.addAttribute("studList", studentList);

		} else {
			model.addAttribute("error", "No student found..!!");
		}
		return "students";
	}

}
