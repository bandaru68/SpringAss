package com.ash.common.controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validUser")
public class ValidController {
	@RequestMapping(value="/{id}/{name}", method=RequestMethod.GET)
	public String validateUser(@PathVariable int id, @PathVariable String name) {
		if(id == 1268 && name.equals("Ashwithabandaru")) {
			return "Hi ashwitha bandaru";
		}
		return "Invalid User";
	}
}