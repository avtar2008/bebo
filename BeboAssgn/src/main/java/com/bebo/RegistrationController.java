package com.bebo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/mvc")
public class RegistrationController {

	
	@RequestMapping(value = "/test")
	public String test() {
		return "enterUserData";
	}
	
	
}
