package com.axsos.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.axsos.dojosninjas.models.Dojo;
import com.axsos.dojosninjas.models.Ninja;
import com.axsos.dojosninjas.service.DojoService;
import com.axsos.dojosninjas.service.NinjaService;

@Controller
public class DojosNinjasControllers {
	@Autowired
	private final DojoService dojoService;
	@Autowired
	private final NinjaService ninjaService;
	
	public DojosNinjasControllers(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}

	@GetMapping("/dojo/{dojo_id}")
	public String showDojo(@PathVariable("dojo_id") Long dojo_id, Model model) {
		Dojo dojo = dojoService.findDojo(dojo_id);
		model.addAttribute("dojo", dojo);
		return "dojo.jsp";
	}

	@GetMapping("/dojo/addnew")
	public String addNewDojo(@Valid @ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}

	@PostMapping("/dojo/new")
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/dojo/addnew";
		} else {
			Dojo newDojo = dojoService.create(dojo);
			return "redirect:/dojo/" + newDojo.getId();
		}

	}

	@GetMapping("/ninja/addnew")
	public String addNewNinja(@ModelAttribute("ninjas") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "newninja.jsp";
	}
	
	@PostMapping("/ninja/new")
	public String addNinja(@Valid @ModelAttribute("ninjas") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/ninja/addnew";
		} else {
			Ninja newNinja = ninjaService.createNinja(ninja);
			return "redirect:/dojo/" + newNinja.getDojo().getId();
		}
	}

}
