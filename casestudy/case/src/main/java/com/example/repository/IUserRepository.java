package com.example.repository;

import com.example.login.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<Users, String> {
    Users findByUserName(String userName);
}
