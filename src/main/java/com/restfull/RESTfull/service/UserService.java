package com.restfull.RESTfull.service;

import com.restfull.RESTfull.entity.User;
import com.restfull.RESTfull.repository.ManageUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserService implements UserDetailsService {
    @Autowired
    @Qualifier("manageUser")
    private ManageUser repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        return (UserDetails) new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),
                user.isActive(),user.isActive(),user.isActive(),user.isActive(),buildGrante(user.getRole()));
    }

    public List<GrantedAuthority> buildGrante(byte rol){
        String[] roles = {"Lector","User","Admin"};
        List<GrantedAuthority> auths = new ArrayList<>();
        for(int i = 0; i < roles.length; i++){
            auths.add(new SimpleGrantedAuthority(roles[i]));
        }
        return auths;
    }
}
