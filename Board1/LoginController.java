package com.fastcampus.ch3;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ResponseCache;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@RequestMapping("/index")
	public String index() {
		System.out.println("hello");
		return "index";
	}
	@PostMapping("/loginForm")
	public String login(HttpServletRequest request, String id, String pwd, String checkbox, HttpSession session, HttpServletResponse response, Model model) {
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
			session.setAttribute("loginId", id);
			
			return "redirect:/index";
		} else {
			return "redirect:/loginForm";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpSession session) {
		session.invalidate();
//		request.getContextPath();
		return "redirect:/index";
	}
	
	@GetMapping("/loginForm") 
	public String loginForm(HttpServletRequest request, Model model) {
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
		return "loginForm";
	}
}