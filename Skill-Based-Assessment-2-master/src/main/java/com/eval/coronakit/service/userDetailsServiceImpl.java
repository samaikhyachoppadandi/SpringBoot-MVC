package com.eval.coronakit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eval.coronakit.dao.RolesRepository;
import com.eval.coronakit.dao.UserRepository;
import com.eval.coronakit.entity.Roles;
import com.eval.coronakit.entity.Users;



@Service
public class userDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	private UserRepository userRepo; 
	@Autowired
	private RolesRepository roleRepo; 
	@Autowired
	private PasswordEncoder pEnc;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserDetails userDetails;

		Users user = userRepo.findByusername(userName);
		Roles r = roleRepo.findByuserName(userName);
		
		if(user==null && r == null) {
			throw new UsernameNotFoundException("No Such User Found  ");
		}
		
		List<GrantedAuthority> authorities= new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(r.getRole()));
		
		
		userDetails = (UserDetails) new User(
				user.getUsername(),
				user.getEncodedPassword(),
				authorities);
		
		
		return userDetails;
}
	public Users save(Users user) {
		user.setEncodedPassword(pEnc.encode(user.getPassword()));
		return userRepo.save(user);
	}
	
	public Roles rsave(Users user) {
		Roles ruser = new Roles();
		ruser.setUsername(user.getUsername());
		ruser.setRole("USER");
		return roleRepo.save(ruser);
	}
}
