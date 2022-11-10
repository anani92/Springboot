package com.axsos.loginregestration.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.axsos.loginregestration.models.LoginUser;
import com.axsos.loginregestration.models.User;
import com.axsos.loginregestration.services.UserService;

@Controller
public class LoginRegestrationController {

	// Add once service is implemented:
	@Autowired
	private UserService userServ;
	public LoginRegestrationController(UserService userServ) {
		this.userServ = userServ;
	}
	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		if (session.getAttribute("user_object") != null) {
			return "redirect:/success";
		}
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {

		userServ.register(newUser, result);
		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}

		model.addAttribute("newLogin", new LoginUser());
		return "redirect:/";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {

		User user = userServ.login(newLogin, result);

		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}

		session.setAttribute("user", userServ.findUserByEmail(newLogin.getEmail()));
		session.setAttribute("loggedIn", true);
		return "redirect:/success";
	}

	@GetMapping("/success")
	public String success(HttpSession session, Model model) {
		model.addAttribute("loggedUser", session.getAttribute("user"));
		return "success.jsp";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    session.invalidate();
		return "redirect:/";
	}
}