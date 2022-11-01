package com.axsos.datedisplay;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class CounterController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		} else {
			Integer currentCount =  (Integer) session.getAttribute("count");
			currentCount += 1;
			session.setAttribute("count", currentCount);
		}
		
		return "index.jsp";
	}
	@RequestMapping("/counter")
	public String showCounter(HttpSession session, Model model) {
		Integer visitTimes = (Integer) session.getAttribute("count");
		model.addAttribute("count", visitTimes);
		return "counter.jsp";
	}
	@RequestMapping("/countbytwo")
	public String increaseCountByTwo(HttpSession session, Model model) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		} else {
			Integer currentCount =  (Integer) session.getAttribute("count");
			currentCount += 2;
			session.setAttribute("count", currentCount);
		}
		
		return "countTwo.jsp";
	}
	@RequestMapping("/reset")
	public String showCounter(HttpSession session) {
		session.setAttribute("count", 0);
		return "counter.jsp";
	}
}
