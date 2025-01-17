package com.auth.ExpenseTracker.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "users")
public class UserInfo {

    @Id
    @Column(name = "user_id")
    private String userId;

    private String username;

    private String password;
    public UserInfo(String userId, String username, String password,Set<UserRole> roles) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.roles = roles;  // Initialize roles
    }
public UserInfo(){}
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )

    private Set<UserRole> roles = new HashSet<>();




}
