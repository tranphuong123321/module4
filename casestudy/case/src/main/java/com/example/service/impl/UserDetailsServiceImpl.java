package com.example.service.impl;


import com.example.login.UserRole;

import com.example.login.Users;
import com.example.repository.IUserRepository;
import com.example.repository.IUserRoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private IUserRoleRepository iUserRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users users = this.iUserRepository.findByUserName(userName);

        if (users == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        System.out.println("Found User: " + users);

        // [ROLE_USER, ROLE_ADMIN,..]
        List<UserRole> userRoleList = this.iUserRoleRepository.findAllByUsers(users);

        List<GrantedAuthority> grantList = new ArrayList<>();
        if (userRoleList != null) {
            for (UserRole userRole : userRoleList) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(userRole.getRole().getRoleName());
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new User(users.getUserName(), //
               new BCryptPasswordEncoder().encode(users.getPassWord()) ,grantList);

        return userDetails;
    }

}
