  package com.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

//		http
//		.authorizeRequests()
//		.antMatchers("/", "/land").permitAll()
//		.anyRequest().authenticated()
//		.and()
//		.formLogin().loginPage("/login").permitAll()
//		.and()
//		.logout().permitAll();
		
		
		/*
		 * For '/admin' URL, only can access the ones that has role ADMIN - that is the only protected link 
		 * For other URLs all the rest is allowed.
		 * And Login will use those parameter (from the form)
		 * And Logout
		 * And for error handling about access denied like 403
		 * And Security for Impersonation of identity attacks 
		 * 
		 * */
		http
		.authorizeRequests()
		.antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
		.anyRequest().permitAll()
		.and().formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password")
		.and().logout().logoutSuccessUrl("/login?logout")
		.and().exceptionHandling().accessDeniedPage("/403")
		.and().csrf();
		
	}
	
	
	
	
	/*
	 * Since it uses DB authentication, we will configure the authentication
	 * */
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
	}

	/* You want to user your own implementation of UserDetails and Password encoder*/
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean(name = "passwordEncoder")
	public PasswordEncoder passwordencoder(){
		return new BCryptPasswordEncoder();
	}
	
}
