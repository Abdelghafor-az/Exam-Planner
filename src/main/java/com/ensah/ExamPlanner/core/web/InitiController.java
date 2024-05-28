package com.ensah.ExamPlanner.core.web;

import ch.qos.logback.core.rolling.helper.FileFilterUtil;
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
