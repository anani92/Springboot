package com.axsos.project.manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.project.manager.models.Project;
import com.axsos.project.manager.models.User;
import com.axsos.project.manager.repositories.ProjectRepo;

@Service
public class ProjectService {
	private final UserService userService;
	private final ProjectRepo projectRepo;
	
	public ProjectService(UserService userService, ProjectRepo projectRepo) {
		this.projectRepo = projectRepo;
		this.userService = userService;
	}
	
	public List <Project> AllProject() {
		return projectRepo.findAll();
	}
	
	public Project findProject(Long id ) {
		Optional <Project> project =  projectRepo.findById(id);
		if (project.isPresent()) {
			return project.get();
		} else {
			return null;
		}
	}
	
	public Project saveProject(Project pro) {
		return projectRepo.save(pro);
	}
	
	public Project updateProject(Project pro) {
		return projectRepo.save(pro);
	}
	
	public void deleteProject(Long id) {
		Optional<Project> projectToDelete = projectRepo.findById(id);
		if (projectToDelete.isPresent()) {
			projectRepo.deleteById(id);
		}
	}
	
	public void addProjectTeamLead(Long userId, Project pro) {
		User teamLead = userService.findUserById(userId);
		pro.setTeamLead(teamLead);
		projectRepo.save(pro);
		
	}
	
	public void addUserToTeam(Long userId, Project pro) {

		User teamMember = userService.findUserById(userId);
		List <Project> memberProjects = teamMember.getTeamProject();
		memberProjects.add(pro);
		teamMember.setTeamProject(memberProjects);
		userService.save(teamMember);
		projectRepo.save(pro);
	}
	
	public List <Project> userProjects(Long userId){
		User user = userService.findUserById(userId);
		return projectRepo.findAllByTeam(user);

	}
	
	public List <Project> availableProjects(Long userId) {
		User user = userService.findUserById(userId);
		return projectRepo.findByTeamNotContains(user);
	}
	
	
	
}
