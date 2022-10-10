package com.booking.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
				.antMatchers(HttpMethod.POST, "/book/user").permitAll()
				.antMatchers(HttpMethod.POST, "/book").permitAll()
				.antMatchers(HttpMethod.GET, "/book").permitAll()
				.antMatchers(HttpMethod.GET, "/book/{id}").permitAll()
				.antMatchers(HttpMethod.GET, "/book/class/{classs}").permitAll()
				.antMatchers(HttpMethod.PUT, "/book/{id}").authenticated()
				.antMatchers(HttpMethod.DELETE, "/book/{id}").authenticated()
				.antMatchers(HttpMethod.GET, "/flight").authenticated()
				.antMatchers(HttpMethod.POST, "/publish").authenticated()
				.anyRequest().permitAll()
				.and()
				.httpBasic()
				.and()
				.cors().disable()
				.csrf().disable();
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		// PasswordEncoder encoder = new BCryptPasswordEncoder();
		return NoOpPasswordEncoder.getInstance();
	}

}
