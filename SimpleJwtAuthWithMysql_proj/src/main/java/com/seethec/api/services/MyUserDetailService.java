package com.seethec.api.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.seethec.api.entity.UserTable;
import com.seethec.api.entity.UserTableRepository;
import com.seethec.api.model.AppUserDetails;

@Service
public class MyUserDetailService implements UserDetailsService  {
	
	@Autowired
	UserTableRepository mUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserTable> lUser = mUserRepository.findByUsername(username);
		lUser.orElseThrow(()-> new UsernameNotFoundException("Invalid username"));
		return lUser.map(AppUserDetails::new).get();
	}
}
