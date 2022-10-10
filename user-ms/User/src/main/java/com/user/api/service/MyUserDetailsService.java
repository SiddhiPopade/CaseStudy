package com.user.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.user.api.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		/*
		   go to DB and check weather this username is present or not
		   if present then fetch the UserDetails
		   if not present then throw UsernameNotFoundException
		*/
		
		com.user.api.model.User userDB = userRepository.findByUsername(username);
		if(userDB == null)
			throw new UsernameNotFoundException("Invalid Credentials");
		
		//convert role to authority
		
		List<GrantedAuthority> list = new ArrayList<>();
		String role = userDB.getRole();
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
		list.add(authority);
		
		/*
		    pass user info from db to spring internal user 
		    that takes username, password and list of GrantedAuthorities
		 */
		
		User springUser = new User(userDB.getUsername(), userDB.getPassword(), list);
		return springUser;
	}

}

