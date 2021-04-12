//@Author Andrew Furey
//@Date: 3–15–2021
//@Email:
//@ClassName: Order

package com.example.illustris.order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
@Table(name = "order", schema = "public")
public class Order {
    @Id
    @SequenceGenerator(name = "order_sequence", sequenceName = "order_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "dateCreated", nullable = false)
    private LocalDateTime dateCreated;

    @Column(name = "dateEdited", nullable = false)
    private LocalDateTime dateEdited;

    @Column(name = "visitReason", columnDefinition = "TEXT", nullable = false, length = 350)
    private String visitReason;

    @Column(name = "imagingNeeded", columnDefinition = "TEXT", nullable = false, length = 256)
    private String imagingNeeded;

    @Enumerated(EnumType.STRING)
    @Column(name = "modality", nullable = false)
    private Modality modality;

    @Column(name = "report", columnDefinition = "TEXT", nullable = true, length = 750)
    private String report;

    public Order() {
    }

    public Order(Long id, LocalDateTime dateCreated, LocalDateTime dateEdited, String visitReason, String imagingNeeded,
        Modality modality, String report) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.dateEdited = dateEdited;
        this.visitReason = visitReason;
        this.imagingNeeded = imagingNeeded;
        this.modality=modality;
        this.report = report;
    }

    public Order(LocalDateTime dateCreated, LocalDateTime dateEdited, String visitReason, String imagingNeeded,
        Modality modality, String report) {
        this.dateCreated = dateCreated;
        this.dateEdited = dateEdited;
        this.visitReason = visitReason;
        this.imagingNeeded = imagingNeeded;
        this.modality=modality;
        this.report = report;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getVisitReason() {
        return visitReason;
    }

    public void setVisitReason(String visitReason) {
        this.visitReason = visitReason;
    }

    public String getImagingNeeded() {
        return imagingNeeded;
    }

    public void setImagingNeeded(String imagingNeeded) {
        this.imagingNeeded = imagingNeeded;
    }

    public Modality getModality() {
        return modality;
    }

    public void setModality(Modality modality) {
        this.modality = modality;
    }
    
    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    @Override
    public String toString() {
        
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        String dateCreatedFormat = dateCreated.format(myFormatObj);
        String dateEditedFormat = dateEdited.format(myFormatObj);


        return "Order [dateCreated=" + dateCreatedFormat + ", dateEdited=" + dateEditedFormat + ", id=" + id + ", imagingNeeded="
                + imagingNeeded + ", modality="+ modality +", report=" + report + ", visitReason=" + visitReason + "]";
    }

  

}
