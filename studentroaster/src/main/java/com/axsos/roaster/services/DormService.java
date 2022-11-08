package com.axsos.roaster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.roaster.models.Dorm;
import com.axsos.roaster.models.Student;
import com.axsos.roaster.repository.DormRepo;
import com.axsos.roaster.repository.StudentRepo;

@Service
public class DormService {
	public final DormRepo dormRepo;
	public final StudentRepo studentRepo;

	public DormService(DormRepo dormRepo, StudentRepo studentRepo) {
		this.dormRepo = dormRepo;
		this.studentRepo = studentRepo;
	}

	public List<Dorm> allDorms() {
		return dormRepo.findAll();
	}

	public Dorm create(Dorm dorm) {
		return dormRepo.save(dorm);
	}

	public Dorm findDormById(Long dorm_id) {
		Optional<Dorm> dorm = dormRepo.findById(dorm_id);
		if (dorm.isPresent()) {
			return dorm.get();
		} else {
			return null;
		}
	}


	public List<Student> allStudents() {
		return studentRepo.findAll();
	}

	public Student create(Student student) {
		return studentRepo.save(student);
	}

	public Student findStudent(Long student_id) {
		Optional<Student> student = studentRepo.findById(student_id);
		if (student.isPresent()) {
			return student.get();
		} else {
			return null;
		}
	}
	
	public void saveDorm(Dorm dorm) {
		dormRepo.save(dorm);
	}



}
