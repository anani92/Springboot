package com.axsos.ninjagold;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGoldController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		ArrayList<String> activities = new ArrayList<String>();
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		if (session.getAttribute("activities") == null) {
			session.setAttribute("activities", activities);
		}
		return "index.jsp";
	}

	@PostMapping("/processmoney")
	public String processMoney(@RequestParam(value = "whichForm") String process, HttpSession session, Model model) {
		int gold = (int) session.getAttribute("gold");
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		Random rNumber = new Random();
		if (!process.equals("quest")) {
			int randomMoney = rNumber.nextInt(10) + 10;
			System.out.println(randomMoney);
			gold += randomMoney;
			activities.add(String.format("<p class='text text-success'>you Earned %d from %s </p>", randomMoney, process));
			session.setAttribute("gold", gold);
			session.setAttribute("activities", activities);

		} else {
			int luck = rNumber.nextInt(2 - 1) + 1;
			int randomMoney = rNumber.nextInt(50);
			System.out.println(randomMoney);
			if (luck == 1) {
				gold += randomMoney;
			} else {
				gold += (randomMoney * -1);
			}
			activities.add(randomMoney >= 0
					? String.format("<p class='text text-success'>you Earned %d from Quest </p>", randomMoney)
					: String.format("<p class='text text-danger'>you lost %d from Quest </p>", randomMoney));
			session.setAttribute("gold", gold);
			session.setAttribute("activities", activities);
		}
		model.addAttribute("gold", gold);
		model.addAttribute("activities", activities);

		return "redirect:/";

	}
}
