package com.bookmanager.bookmanager.security;



import com.bookmanager.bookmanager.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bookmanager.bookmanager.Entity.User;
import com.bookmanager.bookmanager.repository.UserRepository;



public class UserDetailsServiceImple implements UserDetailsService{

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if(user == null)
            throw new UsernameNotFoundException("Could not found user");
        CustomUserDetails customUserDetails = new CustomUserDetails(user);

        return customUserDetails;
    }
    
}