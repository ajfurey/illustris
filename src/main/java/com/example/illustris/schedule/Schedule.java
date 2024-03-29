package com.example.illustris.schedule;

import java.time.LocalDateTime;

import com.example.illustris.order.Order;
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
import javax.persistence.ManyToOne;
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

    
    //works@ManyToOne( targetEntity = Patient.class, cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    //@JoinColumn(name = "patient",referencedColumnName = "patient_id", insertable = true, updatable = true)
    //private Long patient;
    @ManyToOne(cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "patient_id", insertable = true)
    private Patient patient;

    //@Column(name = "orderId", nullable = false)
    @ManyToOne(cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "order_id", insertable = true)
    private Order order;

    @Column(name = "dateCreated", nullable = false)
    private LocalDateTime dateCreated;

    @Column(name = "dateEdited", nullable = false)
    private LocalDateTime dateEdited;

    public Schedule() {
    }

    public Schedule(Long id, LocalDateTime apptTime, Patient patient, Order order, LocalDateTime dateCreated,
            LocalDateTime dateEdited) {
        this.id = id;
        this.apptTime = apptTime;
        this.patient = patient;
        this.order = order;
        this.dateCreated = dateCreated;
        this.dateEdited = dateEdited;
        
    }

    public Schedule(LocalDateTime apptTime, Patient patient, Order order, LocalDateTime dateCreated,
            LocalDateTime dateEdited) {
        this.apptTime = apptTime;
        this.patient = patient;
        this.order = order;
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
                + ", id=" + id + ", order=" + order + ", patient=" + patient + "]";
    }

    
}
