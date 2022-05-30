package com.example.repository;

import com.example.login.Users;
import com.example.login.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole,Integer> {
    List<UserRole> findAllByUsers(Users users);
}
