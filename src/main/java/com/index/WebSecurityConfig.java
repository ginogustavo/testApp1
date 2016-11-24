  package com.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity // Applying a filter in order to intercept the request.

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {

		/*
		 * Authorize the request 
		 * For '/' and '/home' links, permit all they enter. 
		 * But for the other ones, authentication is required. i.e for '/admin', user must first authenticate.
		 * And
		 * When someone wants to enter directly without authentication it will send to the login view, where everybody can enter.
		 * And
		 * Logout also should be accessible by everybody.
		 */

		http
		.authorizeRequests()
		.antMatchers("/", "/land").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").permitAll()
		.and()
		.logout().permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication()
		.withUser("user").password("password").roles("USER");
	}
	
}
