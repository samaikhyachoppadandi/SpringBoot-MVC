package com.eval.coronakit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.eval.coronakit.dao.RolesRepository;
import com.eval.coronakit.dao.UserRepository;
import com.eval.coronakit.entity.Roles;
import com.eval.coronakit.entity.Users;


@Component
public class AppStartUpEventHandler {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private RolesRepository repo1;
	@Autowired
	private PasswordEncoder penc;
	
	@EventListener
	public void appReady(ApplicationReadyEvent event) {

		Users user = repo.findByusername("admin");
		Roles ruser = repo1.findByuserName("admin");
		if(user==null &&  ruser ==null ) {
			
			user = new Users();
			ruser = new Roles();
			user.setUsername("admin");
			user.setEncodedPassword(penc.encode("admin"));
			ruser.setUsername("admin");
			ruser.setRole("ADMIN");
			repo.save(user);
			repo1.save(ruser);
		}
	}
}
