package com.eval.coronakit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eval.coronakit.entity.Users;
import com.eval.coronakit.service.userDetailsServiceImpl;

import com.eval.coronakit.entity.Roles;

@Controller
public class LoginController {

	
	@Autowired
	private userDetailsServiceImpl userService;
	
	@RequestMapping("/custom-login")
	public String login() {
		return "login-form";
	}
	
	@RequestMapping("/custom-error")
	public String error() {
		return "error-page";
	}
	
	@PostMapping("/login")
	public String gotoLogin() {
		String view="login-form";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			view="redirect:/home";
		}

		return view; 
	}
	
	@RequestMapping("/register")
	public ModelAndView showRegisterationForm() {
		return  new ModelAndView("register","user",new Users());
	}
	
	@PostMapping("/register-save")
	public ModelAndView doRegisteration(@ModelAttribute("user") Users user) {
		user = userService.save(user);
		Roles ruser = userService.rsave(user);
		return  new ModelAndView("login-form","msg","User got registered! with Email ID#:"+user.getEmail());
	}
}
