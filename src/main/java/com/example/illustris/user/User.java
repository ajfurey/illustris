package com.example.illustris.user;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "user", schema = "public")
public class User {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @Column(name = "id", updatable = false)
    private int id;

    @Column(name = "firstName", nullable = false, length = 30)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 30)
    private String lastName;

    @Column(name = "username", nullable = false, length = 30)
    private String username;

    @Column(name = "email", nullable = false, length = 36)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone", nullable = false, length = 12)
    private String phone;

    @Column(name = "address", length = 128)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "title", nullable = false, length = 30)
    private Title title;

    @Column(name = "hireDate", nullable = false)
    private LocalDate hireDate;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "locked")
    private Boolean locked;

    @Column(name = "userRole", nullable = false)
    private String userRole;
    
    public User() {
    }

    public User(int id, String firstName, String lastName, String username, String email, String password, String phone,
            String address, Title title, LocalDate hireDate, boolean enabled, Boolean locked, String userRole) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.title = title;
        this.hireDate = hireDate;
        this.enabled = enabled;
        this.locked = locked;
        this.userRole = userRole;
    }

    public User(String firstName, String lastName, String username, String email, String password, String phone,
            String address, Title title, LocalDate hireDate, boolean enabled, Boolean locked, String userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.title = title;
        this.hireDate = hireDate;
        this.enabled = enabled;
        this.locked = locked;
        this.userRole = userRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User [address=" + address + ", email=" + email + ", enabled=" + enabled + ", firstName=" + firstName
                + ", hireDate=" + hireDate + ", id=" + id + ", lastName=" + lastName + ", locked=" + locked
                + ", password=" + password + ", phone=" + phone + ", title=" + title + ", userRole=" + userRole
                + ", username=" + username + "]";
    }    
}
