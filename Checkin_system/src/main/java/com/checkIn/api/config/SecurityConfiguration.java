package com.checkIn.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.checkIn.api.services.MyUserDetailsService;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
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
				.antMatchers(HttpMethod.POST, "/checkin").permitAll()
				.antMatchers(HttpMethod.GET, "/checkin").permitAll()
				.antMatchers(HttpMethod.GET, "/checkin/{Id}").permitAll()
				.antMatchers(HttpMethod.GET, "/checkin/booking/{bookingId}").permitAll()
				.antMatchers(HttpMethod.GET, "/checkin/booking-MS").permitAll()
				.antMatchers(HttpMethod.GET, "/checkin/booking-MS/{bookingId}").permitAll()
				.anyRequest().permitAll()
				.and().httpBasic().and().csrf().disable();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		//PasswordEncoder encoder = new BCryptPasswordEncoder();
		return NoOpPasswordEncoder.getInstance();
	}

}
