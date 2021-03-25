//@Author Andrew Furey
//@Date: 3–15–2021
//@Email:
//@ClassName: User

package com.example.illustris.user;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



//TODO: add all user fields
@Entity
@Table(name = "user", schema = "public")
//public class User{
public class User implements UserDetails{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "firstName", nullable = false, length = 30)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 30)
    private String lastName;

    @Column(name = "username", nullable = false, length = 30)
    private String username;

    @Column(name = "email", nullable = false, length = 36)
    private String email;

    @Column(name = "password", nullable = false, length = 16)
    private String password;

    @Column(name = "phone", nullable = false, length = 12)
    private String phone;

    @Column(name = "dob", nullable = false)
    private LocalDate dob;

    @Column(name = "isActive", nullable = false)
    private Boolean isActive;

    @Column(name = "userRole", nullable = false)
    private UserRole userRole;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    @Column(name = "locked", nullable = false)
    private Boolean locked;

    //Probably remove later
    @Column(name = "isMedical", nullable = false)
    private Boolean isMedical;

    //Probably remove later
    @Column(name = "isAdmin", nullable = false)
    private Boolean isAdmin;

    @Column(name = "position", nullable = false, length = 30)
    private String position;
    
    @Column(name = "hireDate", nullable = false)
    private LocalDate hireDate;

    

    //empty constructor
    public User() {
    }

    //complete constructor
    public User(Long id, String firstName, String lastName, String username, String email, String password,
            String phone, LocalDate dob, Boolean isActive, UserRole userRole, Boolean enabled, Boolean locked, Boolean isMedical, Boolean isAdmin, String position,
            LocalDate hireDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.dob = dob;
        this.isActive = isActive;
        this.userRole = userRole;
        this.enabled = enabled;
        this.locked = locked;
        this.isMedical = isMedical;
        this.isAdmin = isAdmin;
        this.position = position;
        this.hireDate = hireDate;
    }

    //complete constructor with no id variable
    public User(String firstName, String lastName, String username, String email, String password, String phone,
            LocalDate dob, Boolean isActive, UserRole userRole, Boolean enabled, Boolean locked, Boolean isMedical, Boolean isAdmin, String position,
            LocalDate hireDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.dob = dob;
        this.isActive = isActive;
        this.userRole = userRole;
        this.enabled = enabled;
        this.locked = locked;
        this.isMedical = isMedical;
        this.isAdmin = isAdmin;
        this.position = position;
        this.hireDate = hireDate;
    }

    //*****************Begin Spring Security override methods********//
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }


    public Boolean getIsMedical() {
        return isMedical;
    }

    public void setIsMedical(Boolean isMedical) {
        this.isMedical = isMedical;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    //Overrides the toString() method
    @Override
    public String toString() {
        return "User [id="+ id +", firstName="+firstName+", lastName=" + lastName + ", username=" + username +", email=" 
            + email + ", password=" + password + ", phone=" + phone + ", dob=" + dob + ", isActive=" + isActive 
            + ", userRole=" + userRole + ", enabled=" + enabled + ", locked=" + locked+ ", isMedical=" + isMedical 
            + ", isAdmin=" + isAdmin+ ", position=" + position+ ", hireDate=" + hireDate+"]";
    }      

}
