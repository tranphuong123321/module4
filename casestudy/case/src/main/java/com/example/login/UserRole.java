package com.example.login;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class UserRole {
    @Id
    private  int id;


    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "roleId")
    @JsonBackReference
    private Role role;

    @ManyToOne
    @JoinColumn(name="userName",referencedColumnName = "userName")
    @JsonBackReference
    private Users users;

    public UserRole() {
    }

    public UserRole(Role role, Users users) {
        this.role = role;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
