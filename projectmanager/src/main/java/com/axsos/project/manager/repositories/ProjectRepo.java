package com.axsos.project.manager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.project.manager.models.Project;
import com.axsos.project.manager.models.User;

@Repository
public interface ProjectRepo extends CrudRepository <Project, Long>{
	List <Project> findAll();
	List <Project> findAllByTeam(User user);
	List <Project> findByTeamNotContains(User user);

}
