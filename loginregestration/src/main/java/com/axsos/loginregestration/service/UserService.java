
package com.axsos.loginregestration.service;
import java.util.Optional;
import org.mindrot.jbcrypt.BCrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.axsos.loginregestration.models.LoginUser;
import com.axsos.loginregestration.models.User;
import com.axsos.loginregestration.repository.UserRepository;

import java.util.List;
import lombok.Data;

@Data
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    public List <User> findAllUsers() {
		return (List <User>) userRepo.findAll();
	}
    
    public User findUserById(Long id) {
    	Optional <User> user = userRepo.findById(id);
    	if (user.isPresent()) {
    		return user.get();
    		
    	}
    	return null;
    }
    
    public User findUserByEmail(String email) {
    	Optional <User> user = userRepo.findByEmail(email);
    	if (user.isPresent()) {
    		return user.get();
    	}
    	return null;
    }
    
    public User register(User newUser, BindingResult result) {
    	Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
    	if (potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "email already exists!");
    	}
    	
    	if (!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "Matches", "User with this email already exist");
    	}
    	if (result.hasErrors()) {
    		return null;
    	}
    	
    	String hashedPW = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashedPW);
    	userRepo.save(newUser);
    	return newUser;
    }
    public User login(LoginUser newLoginObject, BindingResult result) {
    	if (result.hasErrors()) {
    		return null;
    	}
    	Optional <User> user = userRepo.findByEmail(newLoginObject.getEmail());
    	if (!user.isPresent()) {
    		result.rejectValue("email", "Matches", "email not found");
    		return null;
    	}
    	if (!BCrypt.checkpw(newLoginObject.getPassword(), user.get().getPassword())) {
        	result.rejectValue("password", "Matches", "Invalid Password!");

    	}
    	if (result.hasErrors()) {
        	return null;
        }

    	return user.get();
        
    	
    }
}
