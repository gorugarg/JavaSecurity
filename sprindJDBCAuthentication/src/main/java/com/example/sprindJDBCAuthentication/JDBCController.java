package com.example.sprindJDBCAuthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JDBCController {
	
	@GetMapping("/display")
	public String display()
	{
		System.out.println("hiii");
		return "Success";
	}
	@GetMapping("/display1")
	public String display1()
	{
		System.out.println("hiii");
		return "Successiaono";
	}


}
