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
	@GetMapping("/login")
    public String showLoginForm(HttpServletRequest request, Model model) {
        String saveId = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("rememberId".equals(c.getName())) {
                    saveId = c.getValue();
                    break;
                }
            }
        }
        model.addAttribute("saveId", saveId);
        return "login";
    }
	
	@PostMapping("/login")
	public String login(HttpServletRequest request, String id, String password, String rememberId,
	                    HttpServletResponse response, Model model) {
	    if ("asdf".equals(id) && "1234".equals(password)) {
	        if (rememberId != null) {
	            Cookie cookie = new Cookie("rememberId", id);
	            cookie.setMaxAge(30 * 60);
	            cookie.setPath("/");
	            response.addCookie(cookie);
	        } else {
	            Cookie cookie = new Cookie("rememberId", null);
	            cookie.setMaxAge(0);
	            cookie.setPath("/");
	            response.addCookie(cookie);
	        }

	        model.addAttribute("id", id);
	        model.addAttribute("password", password);
	        return "forward:/userInfo.jsp";

	    } else {
	        return "redirect:/login";
	    }
	}

}