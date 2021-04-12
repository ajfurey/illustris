//@Author Andrew Furey
//@Date: 3–15–2021
//@Email:
//@ClassName: Patient

package com.example.illustris.patient;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "patient", schema = "public")
public class Patient {
    @Id
    @SequenceGenerator(name = "patient_sequence", sequenceName = "patient_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_sequence")
    @Column(name = "patient_id", updatable = false) 
    private Long id;

    @Column(name = "firstName", nullable = false, length = 30)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 30)
    private String lastName;

    @Column(name = "mInit", nullable = true, length = 1)
    private String mInit;

    @Column(name = "email", nullable = true, length = 36)
    private String email;

    @Column(name = "phone", nullable = false, length = 12)
    private String phone;

    @Column(name = "birthDate", nullable = false)
    private LocalDate birthDate;

    @Column(name = "allergy_asthma", nullable = false)
    private Boolean allergy_asthma;

    @Column(name = "allergy_ltx", nullable = false)
    private Boolean allergy_ltx;

    @Column(name = "allergy_mriDye", nullable = false)
    private Boolean allergy_mriDye;

    @Column(name = "allergy_xrayDye", nullable = false)
    private Boolean allergy_xrayDye;

    @Column(name = "notes", columnDefinition = "TEXT", nullable = true, length = 512)
    private String notes;
    
    //@ManyToOne( targetEntity = Schedule.class, cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    //@JoinColumn(name = "schedule_id", referencedColumnName = "patient")
    //private Set<Schedule> schedule;
    //private Long scheduleId;
    //private Schedule schedule;


    public Patient() {
    }

    public Patient(Long id, String firstName, String lastName, String mInit, String email, String phone,
            LocalDate birthDate, Boolean allergy_asthma, Boolean allergy_ltx, Boolean allergy_mriDye, Boolean allergy_xrayDye,
            String notes) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mInit = mInit;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.allergy_asthma = allergy_asthma;
        this.allergy_ltx = allergy_ltx;
        this.allergy_mriDye = allergy_mriDye;
        this.allergy_xrayDye = allergy_xrayDye;
        this.notes = notes;
    }

    public Patient(String firstName, String lastName, String mInit, String email, String phone, LocalDate birthDate,
            Boolean allergy_asthma, Boolean allergy_ltx, Boolean allergy_mriDye, Boolean allergy_xrayDye,
            String notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mInit = mInit;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.allergy_asthma = allergy_asthma;
        this.allergy_ltx = allergy_ltx;
        this.allergy_mriDye = allergy_mriDye;
        this.allergy_xrayDye = allergy_xrayDye;
        this.notes = notes;
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

    public String getMInit() {
        return mInit;
    }

    public void setMInit(String mInit) {
        this.mInit = mInit;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getAllergy_asthma() {
        return allergy_asthma;
    }

    public void setAllergy_asthma(Boolean allergy_asthma) {
        this.allergy_asthma = allergy_asthma;
    }

    public Boolean getAllergy_ltx() {
        return allergy_ltx;
    }

    public void setAllergy_ltx(Boolean allergy_ltx) {
        this.allergy_ltx = allergy_ltx;
    }

    public Boolean getAllergy_mriDye() {
        return allergy_mriDye;
    }

    public void setAllergy_mriDye(Boolean allergy_mriDye) {
        this.allergy_mriDye = allergy_mriDye;
    }

    public Boolean getAllergy_xrayDye() {
        return allergy_xrayDye;
    }

    public void setAllergy_xrayDye(Boolean allergy_xrayDye) {
        this.allergy_xrayDye = allergy_xrayDye;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Patient [allergy_asthma=" + allergy_asthma + ", allergy_ltx=" + allergy_ltx + ", allergy_mriDye="
                + allergy_mriDye + ", allergy_xrayDye=" + allergy_xrayDye + ", birthDate=" +birthDate + ", email=" + email
                + ", firstName=" + firstName + ", id=" + id + ", lastName=" + lastName + ", mInit=" + mInit
                + ", notes=" + notes + ", phone=" + phone + "]";
    }

    
}
