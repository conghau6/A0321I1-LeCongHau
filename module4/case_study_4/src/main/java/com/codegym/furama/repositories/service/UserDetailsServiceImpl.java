package com.codegym.furama.repositories.service;

import com.codegym.furama.entity.Role;
import com.codegym.furama.entity.User;
import com.codegym.furama.repositories.employee.IRoleRepositories;
import com.codegym.furama.repositories.employee.IUserRepositories;
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
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    IUserRepositories userRepositories;

    @Autowired
    IRoleRepositories roleRepositories;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepositories.findByUsername(username);
        if(username==null){
            throw new UsernameNotFoundException("User " + username + " was not found");
        }

        List<Role> roles = userRepositories.findAllRoleByUsername(username);
        List<String> roleNames = new ArrayList<>();
        for(Role role : roles) {
            roleNames.add(role.getRoleName());
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if(roles!=null){
            for(String roleName : roleNames){
                GrantedAuthority authority = new SimpleGrantedAuthority(roleName);
                grantedAuthorities.add(authority);
            }
        }

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),grantedAuthorities);
       return userDetails;
    }
}
