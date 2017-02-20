package com.nisum.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nisum.domain.Employee;
import com.nisum.repository.UserRoleRepository;

@Service("customUserService")
public class CustomUserService implements UserDetailsService{
	@Autowired
	UserRoleRepository userRoleRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Employee employee = userRoleRepository.findByUserName(username); 	
		if (employee==null) {
			
			throw new UsernameNotFoundException("No user found with this name" +username);
		}
		return new org.springframework.security.core.userdetails.User(employee.getUserName(), employee.getPassword(), 
				getGrantedAuthorities(employee));
	}
	public Employee findByUserNameAndPassword(String userName, String password) {
		return userRoleRepository.findByUserNameAndPassword(userName, password);
	}
	private List<GrantedAuthority> getGrantedAuthorities(Employee employee){
	       List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	       authorities.add(new SimpleGrantedAuthority("ROLE_"+employee.getRole()));
	       System.out.print("authorities :"+authorities);
	       return authorities;
	   }
	
}
