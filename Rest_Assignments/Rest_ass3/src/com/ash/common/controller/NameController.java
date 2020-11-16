package com.ash.common.controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nameChecker")
public class NameController {
	
	@RequestMapping(value="/{fname}/{lname}", method=RequestMethod.GET)
	public String validateUser(@PathVariable String fname, @PathVariable String lname) {
		if(fname=="ASHWITHA" && lname == "BANDARU") {
		
		return fname+" "+lname;
	}
		else
		return "invalid user";
	}
}