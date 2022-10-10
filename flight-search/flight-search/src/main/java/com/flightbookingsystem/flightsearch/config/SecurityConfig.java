package com.flightbookingsystem.flightsearch.config;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.flightbookingsystem.flightsearch.services.MyUserDetailsService;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(getAuthProvider());
	}

	private AuthenticationProvider getAuthProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(myUserDetailsService);
		auth.setPasswordEncoder(getPasswordEncoder());
		return auth;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/search/user").permitAll()
				.antMatchers(HttpMethod.POST, "/search").permitAll()
				.antMatchers(HttpMethod.GET, "/search").permitAll()
				.antMatchers(HttpMethod.GET, "/search/{id}").permitAll()
				.antMatchers(HttpMethod.GET, "/search/origin/{origin}").permitAll()
				.antMatchers(HttpMethod.GET, "/search/destination/{destination}").permitAll()
				.antMatchers(HttpMethod.GET,"/search/origin/destination/{origin}/{destination}").permitAll()
				.antMatchers(HttpMethod.PUT, "/update/{id}").permitAll()
				.antMatchers(HttpMethod.DELETE, "/delete/{id}").permitAll()
				.anyRequest().permitAll()
				.and()
				.httpBasic()
				.and()
				.csrf().disable();
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		// PasswordEncoder encoder = new BCryptPasswordEncoder();
		return NoOpPasswordEncoder.getInstance();
	}

}
