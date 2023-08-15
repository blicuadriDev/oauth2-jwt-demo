package com.godknows.oauth2jwt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.godknows.oauth2jwt.entities.Role;
import com.godknows.oauth2jwt.entities.User;
import com.godknows.oauth2jwt.projections.UserDetailsProjection;
import com.godknows.oauth2jwt.repositores.UserRepository;

public class UserService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<UserDetailsProjection> result = userRepository.searchUserAndRolesByEmail(username);
		if( result.size() == 0) {
			 throw new UsernameNotFoundException("User Not found!");
		}
		
		User user = new User();
		user.setEmail(username);
		user.setPassword(result.get(0).getPassword());
		
		for(UserDetailsProjection projection : result) {
			user.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
		}
		
		return user;
	}

}
