package com.axsos.showdate;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DisplayDateController {
    public Date now = new Date();
	@RequestMapping("/")
	public String  showDate(Model model) {	    
		return "index.jsp";
	}
	@RequestMapping("/time")
	public String time(Model model) {
		SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");  
		String time = timeFormatter.format(now);
	    model.addAttribute("time", time);
	    return "time.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy"); 
		String date = dateFormatter.format(now);
	    model.addAttribute("date", date);
	    return "date.jsp";
	}
}
