package com.example.login;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class Users {
    @Id
    private String  userName;
    private String  passWord;

    @OneToMany(mappedBy = "users")
    private List<UserRole> userRoleList;

    @Column(name = "Encryted_Password", length = 128, nullable = false)
    private String encrytedPassword;

    public Users() {
    }

    public Users(String userName, String passWord, String encrytedPassword) {
        this.userName = userName;
        this.passWord = passWord;
        this.encrytedPassword = encrytedPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }
}
