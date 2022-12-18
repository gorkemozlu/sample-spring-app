package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@GetMapping("/")
	public String main(@RequestParam(name="var1", required=false, defaultValue="Gorkem") String name, Model model) {
		model.addAttribute("var1", name);
		return "main";
	}
}
