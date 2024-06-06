package com.ensah.ExamPlanner.core.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//Ce controleur affiche la page index 
@Controller
@RequestMapping("/")
public class InitiController {

	public String index(Model model) {

		return "redirect:/admin/showForm";
	}
}
