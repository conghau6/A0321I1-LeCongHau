package com.codegym.blog.service.impl;

import com.codegym.blog.model.User;
import com.codegym.blog.repositories.UserRepositories;
import com.codegym.blog.repositories.UserRoleRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserRepositories userRepositories;

    @Autowired
    UserRoleRepositories userRoleRepositories;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepositories.findByUsername(username);

        if(username == null) {
            throw new UsernameNotFoundException("User " + username + " was not found");
        }

        List<String> roles = userRoleRepositories.findAllRoleByUserId(user.getId());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if(roles!=null){
            for(String roleName : roles) {
                GrantedAuthority authority = new SimpleGrantedAuthority(roleName);
                grantedAuthorities.add(authority);
            }
        }

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
        return userDetails;
    }
}
