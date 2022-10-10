package com.user.api.config;

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
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.user.api.service.MyUserDetailsService;

@SuppressWarnings("deprecation")
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

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	http.authorizeRequests()
    				.antMatchers(HttpMethod.GET,"/user/login").permitAll()
    				
			    	.antMatchers(HttpMethod.POST,"/user/register").permitAll()
					.antMatchers(HttpMethod.GET,"/user").permitAll()
					.antMatchers(HttpMethod.GET,"/user/**").permitAll()
					.antMatchers(HttpMethod.PUT,"/user/**").permitAll()
					.antMatchers(HttpMethod.DELETE,"/user/**").permitAll()
					
					.anyRequest().permitAll()
					.and()
					.httpBasic()
					.and()
					.csrf().disable()
    				.cors().disable();

    }
    
}
