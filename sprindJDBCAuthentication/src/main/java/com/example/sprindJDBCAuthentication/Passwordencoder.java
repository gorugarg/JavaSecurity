package com.example.sprindJDBCAuthentication;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Passwordencoder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String encoded=new BCryptPasswordEncoder().encode("gaurav@123");
		System.out.println(encoded);
		//String decoded = new BC

	}

}
