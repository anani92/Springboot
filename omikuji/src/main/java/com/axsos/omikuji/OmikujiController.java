package com.axsos.omikuji;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiController {
	@GetMapping("/")
	public String index() {

		return "index.jsp";
	}

	@PostMapping(value = "/process")
	public String handleFortune(
			@RequestParam(value = "year") Integer year,
			@RequestParam(value = "city") String city,
			@RequestParam(value = "person") String person,
			@RequestParam(value = "hoppy") String hoppy,
			@RequestParam(value = "creature") String creature,
			@RequestParam(value = "something-nice") String somethingNice,
			Model model, HttpSession session) {

		session.setAttribute("year", year);
		session.setAttribute("city", city);
		session.setAttribute("hoppy", hoppy);
		session.setAttribute("person", person);
		session.setAttribute("creature", creature);
		session.setAttribute("somethingNice", somethingNice);


		model.addAttribute("year", session.getAttribute("year"));
		model.addAttribute("city", session.getAttribute("city"));
		model.addAttribute("hoppy", session.getAttribute("hoppy"));
		model.addAttribute("person", session.getAttribute("person"));
		model.addAttribute("creature", session.getAttribute("creature"));
		model.addAttribute("somethingNice", session.getAttribute("somethingNice"));

		return "redirect:/show";

	}

	@GetMapping("/show")
	public String show() {
		return "show.jsp";
	}

}