package com.example.illustris.schedule;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.example.illustris.patient.Patient;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "schedule", schema = "public")
public class Schedule {
    @Id
    @SequenceGenerator(name = "schedule_sequence", sequenceName = "schedule_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "schedule_sequence")
    @Column(name = "schedule_id", updatable = false)
    private Long id;

    //Appointment time
    @Column(name = "apptTime", nullable = false)
    private LocalDateTime apptTime;

    
    @ManyToOne( targetEntity = Patient.class, cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "patient",referencedColumnName = "patient_id", insertable = true, updatable = true)
    private Long patient;

    @Column(name = "orderId", nullable = false)
    private int orderId;

    @Column(name = "dateCreated", nullable = false)
    private LocalDateTime dateCreated;

    @Column(name = "dateEdited", nullable = false)
    private LocalDateTime dateEdited;

    public Schedule() {
    }

    public Schedule(Long id, LocalDateTime apptTime, Long patient, int orderId, LocalDateTime dateCreated,
            LocalDateTime dateEdited) {
        this.id = id;
        this.apptTime = apptTime;
        this.patient = patient;
        this.orderId = orderId;
        this.dateCreated = dateCreated;
        this.dateEdited = dateEdited;
    }

    public Schedule(LocalDateTime apptTime, Long patient, int orderId, LocalDateTime dateCreated,
            LocalDateTime dateEdited) {
        this.apptTime = apptTime;
        this.patient = patient;
        this.orderId = orderId;
        this.dateCreated = dateCreated;
        this.dateEdited = dateEdited;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getApptTime() {
        return apptTime;
    }

    public void setApptTime(LocalDateTime apptTime) {
        this.apptTime = apptTime;
    }

    public Long getPatient() {
        return patient;
    }

    public void setPatient(Long patient) {
        this.patient = patient;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateEdited() {
        return dateEdited;
    }

    public void setDateEdited(LocalDateTime dateEdited) {
        this.dateEdited = dateEdited;
    }

    @Override
    public String toString() {
        return "Schedule [apptTime=" + apptTime + ", dateCreated=" + dateCreated + ", dateEdited=" + dateEdited
                + ", id=" + id + ", orderId=" + orderId + ", patient=" + patient + "]";
    }

    
}
