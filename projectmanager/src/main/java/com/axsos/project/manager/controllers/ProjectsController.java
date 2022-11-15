package com.axsos.project.manager.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.axsos.project.manager.models.Project;
import com.axsos.project.manager.models.User;
import com.axsos.project.manager.service.ProjectService;
import com.axsos.project.manager.service.UserService;

@Controller
public class ProjectsController {
	private final ProjectService proService;
	private final UserService userService;

	public ProjectsController(ProjectService proService, UserService userService) {
		this.proService = proService;
		this.userService = userService;
	}

	@GetMapping("/projects/home")
	public String homePage(HttpSession session, Model model) {
		if (session.getAttribute("user") == null) {
			return "redirect:/";
		}
		User user = (User) session.getAttribute("user");
		
		List<Project> availableProjects = proService.availableProjects(user.getId());
		model.addAttribute("user", user);
		model.addAttribute("availableProjects", availableProjects);
		model.addAttribute("userProjects", proService.userProjects(user.getId()));
		return "home.jsp";
	}

	@GetMapping("/projects/new")
	public String newProject(@ModelAttribute("newProject") Project project, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "redirect:/";
		}
		return "newproject.jsp";
	}

	@PostMapping("/projects/new")
	public String createProject(@Valid @ModelAttribute("newProject") Project project, BindingResult result,
			HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (result.hasErrors()) {

			return "newproject.jsp";
		}
		Project newProject = project;
		proService.addProjectTeamLead(user.getId(), newProject);
		proService.addUserToTeam(user.getId(), newProject);

		return "redirect:/projects/home";
	}

	@GetMapping("/projects/{id}")
	public String showProject(@PathVariable("id") Long id, Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:/";
		}
		Project project = proService.findProject(id);
		model.addAttribute("project", project);
		model.addAttribute("user", user);
		return "showproject.jsp";
	}

	@GetMapping("/projects/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:/";
		}
		Project project = proService.findProject(id);
		model.addAttribute("projectToEdit", project);
		return "edit.jsp";
	}

	@PutMapping("/projects/edit/{id}")
	public String editProject( @Valid @ModelAttribute("projectToEdit") Project project,
			BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			User user = (User) session.getAttribute("user");
			project.setTeamLead(user);
			proService.saveProject(project);
			return "redirect:/projects/" + project.getId();
		}
	}

	@PutMapping("/projects/join/{projectId}")
	public String addTeamMember(@PathVariable("projectId") Long projectId, HttpSession session) {
		User user = (User) session.getAttribute("user");
		Project pro = proService.findProject(projectId);
		proService.addUserToTeam(user.getId(), pro);
		proService.saveProject(pro);
		return "redirect:/projects/home";

	}

	@PutMapping("/projects/leave/{id}")
	public String leaveTeam(@PathVariable("id") Long projectId, HttpSession session) {
		User user = (User) session.getAttribute("user");
		Project pro = proService.findProject(projectId);
		user.getProjects().remove(pro);
		proService.saveProject(pro);
		return "redirect:/projects/home";

	}

	@DeleteMapping("projects/delete/{id}")
	public String deleteProject(@PathVariable("id") Long id) {
		proService.deleteProject(id);
		return "redirect:/projects/home";
	}
	
	

}
