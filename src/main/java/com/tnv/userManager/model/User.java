package com.tnv.userManager.model;


import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Table(name = "users")
public class User {

    @Transient
    PasswordEncoder enc = new BCryptPasswordEncoder();

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id", nullable = false)
    private Long id;
    private String name;
    private String surname;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String username;
    private String password;
    private String roles;
    private boolean isEnabled = false;


    public User() {}

    public User(String role) {
        String roleLowerCase = role.toLowerCase();
        this.roles = role;
        this.isEnabled = true;
        this.name = roleLowerCase;
        this.surname = roleLowerCase;
        this.username = roleLowerCase;
        this.email = roleLowerCase + "@TheBoss.com";
        this.password = enc.encode(roleLowerCase);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    @Override
    public String toString() {
        return  "User " + this.id + ": " +
                "\nfirst name = " + this.name +
                "\nlast name = " + this.surname +
                "\nusername = " + this.username +
                "\nemail = " + this.email +
                "\npassword = " + this.password +
                "\nroles = " + this.roles;
    }
}
