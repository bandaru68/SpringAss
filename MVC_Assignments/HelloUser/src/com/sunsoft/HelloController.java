package com.sunsoft;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloController {

	@RequestMapping("/login")
	public String hello(HttpServletRequest req, HttpServletResponse res,Model m) {
		String name=req.getParameter("name");
		String message="Welcome " +name;
		m.addAttribute("message", message);
		return "hellopage";
	}

}