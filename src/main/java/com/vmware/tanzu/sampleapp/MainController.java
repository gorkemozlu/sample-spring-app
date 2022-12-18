package com.vmware.tanzu.sampleapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Value;

@Controller
public class MainController {
	
	@Value("${MY_NODE_NAME:null}")
    private String MY_NODE_NAME;

	@Value("${MY_POD_NAME:null}")
    private String MY_POD_NAME;

	@Value("${MY_POD_NAMESPACE:null}")
    private String MY_POD_NAMESPACE;

	@Value("${MY_POD_SERVICE_ACCOUNT:null}")
    private String MY_POD_SERVICE_ACCOUNT;

	@Value("${SECRET_USERNAME:null}")
    private String SECRET_USERNAME;

	@Value("${SECRET_PASSWORD:null}")
    private String SECRET_PASSWORD;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(@RequestParam(name="var1", required=false, defaultValue="Gorkem") String name, Model model) {
		model.addAttribute("var1", name);
		model.addAttribute("MY_NODE_NAME", MY_NODE_NAME);
		model.addAttribute("MY_POD_NAME", MY_POD_NAME);
		model.addAttribute("MY_POD_NAMESPACE", MY_POD_NAMESPACE);
		model.addAttribute("MY_POD_SERVICE_ACCOUNT", MY_POD_SERVICE_ACCOUNT);
		model.addAttribute("SECRET_USERNAME", SECRET_USERNAME);
		model.addAttribute("SECRET_PASSWORD", SECRET_PASSWORD);
		return "main";
	}
}
