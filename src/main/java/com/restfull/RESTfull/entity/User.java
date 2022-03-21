package com.restfull.RESTfull.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class User implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="username",unique = true)
    private String userName;

    @Column(name="password")
    private String password;

    @Column(name="role")
    private byte role;

    @Column(name="active")
    private boolean active;

    public Long getId() {
        return id;
    }

    public byte getRole() {
        return role;
    }

    public boolean isActive() {
        return active;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRole(byte role) {
        this.role = role;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
