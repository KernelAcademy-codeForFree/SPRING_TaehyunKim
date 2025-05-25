package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public String loginForm(HttpServletRequest request, Model model) {
		System.out.println("Hello");
		String saveId = "";
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(int i = 0; i < cookies.length; i++) {
				Cookie c = cookies[i];
				if("checkbox".equals(c.getName())) {
					saveId = c.getValue();
					break;
				}
			}
		}
		model.addAttribute("saveId", saveId);
		return "login"; 
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request, String id, String pwd, String checkbox, HttpServletResponse response, Model model) {
		
		if("asdf".equals(id) && "1234".equals(pwd)) {
			if(checkbox != null) {
				Cookie cookie = new Cookie("checkbox", id);
				cookie.setMaxAge(30 * 60);
				cookie.setPath("/");
				response.addCookie(cookie);
			} else {
				Cookie cookie = new Cookie("checkbox", null);
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
			model.addAttribute("id", id);
			model.addAttribute("pwd", pwd);
			
			return "userInfo";
		} 
		else {
			return "redirect:/login";
		}
	}
}