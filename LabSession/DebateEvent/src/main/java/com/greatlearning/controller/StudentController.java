package com.greatlearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.model.Student;
import com.greatlearning.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentServiceImpl;

	@RequestMapping("/details")
	public String showAllStudent(Model model) {

		List<Student> students = studentServiceImpl.findAllStudent();

		model.addAttribute("students", students);

		return "liststudents";

	}

	@RequestMapping("/addstudent")
	public String addStudent(Model model) {

		return "studentaddform";

	}

	@PostMapping("/save")
	public String saveStudent(@ModelAttribute Student student) {

		Student newStudent;

		if (student.getId() != 0) {
			newStudent = studentServiceImpl.findById(student.getId());
			newStudent.setStudentName(student.getStudentName());
			newStudent.setDepartment(student.getDepartment());
			newStudent.setCountry(student.getCountry());
			student = newStudent;

		}

		studentServiceImpl.save(student);

		return "redirect:/student/details";

	}

	@RequestMapping("/deletestudent")
	public String deleteStudent(@RequestParam("id") int id) {

		System.out.print(id);

		studentServiceImpl.deleteById(id);

		return "redirect:/student/details";
	}

	@RequestMapping("/editstudent")
	public String editStudent(@RequestParam("id") int id, Model model) {

		Student student = studentServiceImpl.findById(id);

		model.addAttribute("student", student);

		return "updatedetails";

	}

}
