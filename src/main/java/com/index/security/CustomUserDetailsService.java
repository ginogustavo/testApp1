package com.index.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.index.model.User;
import com.index.model.UserRole;
import com.index.repository.UserRepository;
import com.index.repository.UserRoleRepository;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	private final UserRepository userRepository;
	private final UserRoleRepository userRoleRepository;
	
	@Autowired
	public CustomUserDetailsService(UserRepository userRepo, UserRoleRepository userRoleRepo){
		this.userRepository = userRepo;
		this.userRoleRepository = userRoleRepo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUserName(username);
		if (user.equals(null)){
			throw new UsernameNotFoundException("No user present with username: "+ username);
		}else{
			
			List<String> userRoles = userRoleRepository.findRoleByUserName( username );
			return new CustomUserDetails(user, userRoles);
		}

	}

}
