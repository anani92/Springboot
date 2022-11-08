package com.axsos.roaster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.axsos.roaster.models.Dorm;
import com.axsos.roaster.models.Student;
import com.axsos.roaster.services.DormService;

@Controller
public class DormsController {
	@Autowired
	private final DormService dormService;
	
	public DormsController(DormService dormService) {
		this.dormService = dormService;
	}
	
	@GetMapping("/dorms")
	public String showDorms(Model model) {
		List <Dorm> dorms = dormService.allDorms();
		model.addAttribute("dorms", dorms);
		return "dorms.jsp";
	} 
	
	@GetMapping("/dorms/new")
	public String newDorm(@ModelAttribute("dorm") Dorm dorm ){
		return "newdorm.jsp";
	}
	@PostMapping("/dorms/new")
	public String addNewDorm(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result) {
		if (result.hasErrors()) {
			return "newdorn.jsp";
		}
		else {
			Dorm newDorm = dormService.create(dorm);
			return "redirect:/dorms/" + newDorm.getId();
		}
	}
	
	@GetMapping("/dorms/{dorm_id}")
	public String showDorm(@PathVariable("dorm_id") Long dorm_id, Model model) {
		Dorm dorm = dormService.findDormById(dorm_id);
		List <Student> dormStudents = dorm.getStudents();
		List <Student> allStudents = dormService.allStudents();
		System.out.println(dormStudents);
		model.addAttribute("dorm", dorm);
		model.addAttribute("allStudents", allStudents);
		model.addAttribute("dormStudents", dormStudents);

		return "showdorm.jsp";
		
	}
	
	@PostMapping("/dorms/addstudent")
	public String addStudentToDorm(@RequestParam("student_id") Long student_id, @RequestParam("dorm_id") Long dormId ) {
		Student studentToAdd  = dormService.findStudent(student_id);
		Dorm dorm = dormService.findDormById(dormId);
		List <Student> dormStudents = dorm.getStudents();
		studentToAdd.setDorm(dorm);
		dormStudents.add(studentToAdd);
		dorm.setStudents(dormStudents);
		System.out.println(studentToAdd.getName() + "hello");
		System.out.println(dormStudents);
		dormService.saveDorm(dorm);
		return "redirect:/dorms/" + dorm.getId();
	}
	
	@GetMapping("/students/new")
	public String newStudent(@ModelAttribute("student") Student student, Model model) {
		model.addAttribute("dorms", dormService.allDorms());
		return "newstudent.jsp";
	}
	
	@PostMapping("/students/new")
	public String addNewStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/students/new";
		} else {
			dormService.create(student);
			return "redirect:/dorms";
		}
	}
}
