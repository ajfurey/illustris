//@Author Andrew Furey
//@Date: 3–15–2021
//@Email:
//@ClassName: User

package com.example.illustris.user;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//TODO: add all user fields
@Entity
@Table(name = "user", schema = "public")
public class User {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String phone;
    private LocalDate dob;
    private Boolean is_active;
    private Boolean is_medical;
    private Boolean is_admin;
    private String position;
    private LocalDate hireDate;

    //empty constructor
    public User() {
    }

    //complete constructor
    public User(Long id, String firstName, String lastName, String username, String email, String password,
            String phone, LocalDate dob, Boolean is_active, Boolean is_medical, Boolean is_admin, String position,
            LocalDate hireDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.dob = dob;
        this.is_active = is_active;
        this.is_medical = is_medical;
        this.is_admin = is_admin;
        this.position = position;
        this.hireDate = hireDate;
    }

    //complete constructor with no id variable
    public User(String firstName, String lastName, String username, String email, String password, String phone,
            LocalDate dob, Boolean is_active, Boolean is_medical, Boolean is_admin, String position,
            LocalDate hireDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.dob = dob;
        this.is_active = is_active;
        this.is_medical = is_medical;
        this.is_admin = is_admin;
        this.position = position;
        this.hireDate = hireDate;
    }

    //Gets the user's ID number
    //The code automatically generates a user ID
    public Long getId() {
        return id;
    }

    //Sets the user's ID number
    public void setId(Long id) {
        this.id = id;
    }

    //Gets the user's First name
    public String getFirstName() {
        return firstName;
    }

    //Sets the user's First name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

     //Gets the user's Last name
    public String getLastName() {
        return lastName;
    }

    //Sets the user's Last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Gets the user's Username
    public String getUsername() {
        return username;
    }

    //Sets the user's Username
    public void setUsername(String username) {
        this.username = username;
    }

    //Gets the user's Email address
    public String getEmail() {
        return email;
    }

    //Sets the user's Email address
    public void setEmail(String email) {
        this.email = email;
    }
    
    //Gets the user's Password
    public String getPassword() {
        return password;
    }

    //Sets the user's Password
    public void setPassword(String password) {
        this.password = password;
    }

    //Gets the user's phone number
    public String getPhone() {
        return phone;
    }

    //Sets the user's phone number
    public void setPhone(String phone) {
        this.phone = phone;
    }

    //Gets the user's Date of birth
    public LocalDate getDob() {
        return dob;
    }

    //Sets the user's Date of birth
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    //Gets whether the user is an active user
    public Boolean getIs_active() {
        return is_active;
    }

    //Sets whether the user is an active user
    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    //Gets whether the user is on the medical staff
    public Boolean getIs_medical() {
        return is_medical;
    }

    //Sets whether the user is on the medical staff
    public void setIs_medical(Boolean is_medical) {
        this.is_medical = is_medical;
    }

    //Gets whether the user is a system administrator
    public Boolean getIs_admin() {
        return is_admin;
    }

    //Sets whether the user is a system administrator
    public void setIs_admin(Boolean is_admin) {
        this.is_admin = is_admin;
    }

    //Gets the user's Position
    public String getPosition() {
        return position;
    }

    //Sets the user's Position
    public void setPosition(String position) {
        this.position = position;
    }

    //Gets the date the user was hired
    public LocalDate getHireDate() {
        return hireDate;
    }

    //Sets the date the user was hired
    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }    

    //Overrides the toString() method
    @Override
    public String toString() {
        return "User [id="+ id +", firstName="+firstName+", lastName=" + lastName + ", username=" + username +", email=" 
                + email + ", password=" + password + ", phone=" + phone + ", dob=" + dob + ", is_active=" + is_active + 
                ", is_medical=" + is_medical + ", is_admin=" + is_admin+ ", position=" + position+ ", hireDate=" + hireDate+"]";
    }
}
