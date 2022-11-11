package com.axsos.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.axsos.bookclub.models.LoginUser;
import com.axsos.bookclub.models.User;
import com.axsos.bookclub.services.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userServ;

	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		if (session.getAttribute("user") != null) {
			return "redirect:/books/home";
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
			return "redirect:/";
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
			return "redirect:/books/home";
		}

		session.setAttribute("user", userServ.findUserByEmail(user.getEmail()));
		session.setAttribute("loggedIn", true);
		return "redirect:/books/home";
	}

	@GetMapping("/books/home")
	public String success(HttpSession session, Model model) {
		model.addAttribute("loggedUser", session.getAttribute("user"));
		return "home.jsp";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
