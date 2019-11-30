package com.money.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {
	
	//senha: $2a$10$kesM69UIOJw5q6CDAfYy9eivkoyIs3ZPRuqaHn76nfW12uOcYUaMO
	
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("admin"));
	}
	
}