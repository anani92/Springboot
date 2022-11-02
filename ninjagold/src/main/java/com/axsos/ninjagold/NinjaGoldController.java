package com.axsos.ninjagold;

import java.util.Date;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.text.DateFormat;

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
		Date date = new Date();
		String datetime = DateFormat.getInstance().format(date);
		if (!process.equals("quest")) {
			int randomMoney = rNumber.nextInt(10) + 10;
			System.out.println(randomMoney);
			gold += randomMoney;
			activities.add(0, String.format("<p class='text text-success'>you Earned %d from %s (%s)</p>", randomMoney,
					process, datetime));
			session.setAttribute("gold", gold);
			session.setAttribute("activities", activities);

		} else {
			int luck = rNumber.nextInt(2);
			Integer randomMoney = rNumber.nextInt(50);
			System.out.println(randomMoney);
			if (luck == 1) {
				gold += randomMoney;
			} else {
				gold -= randomMoney;
			}
			activities.add(0, luck == 1
					? String.format("<p class='text text-success'>you Earned %d from Quest (%s) </p>", randomMoney, datetime)
					: String.format("<p class='text text-danger'>you lost -%d from Quest (%s) </p>", randomMoney, datetime));
			session.setAttribute("gold", gold);
			session.setAttribute("activities", activities);
		}
		model.addAttribute("gold", gold);
		model.addAttribute("activities", activities);

		return "redirect:/";

	}
}
