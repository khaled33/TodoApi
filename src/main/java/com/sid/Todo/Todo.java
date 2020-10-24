package com.sid.Todo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String label;

    private String status= String.valueOf(Status.Ouvert);
    @JsonFormat(pattern = "yyyy-MM-dd")
    @javax.persistence.OrderBy(value = " desc ")
    private Date dateDebut;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date echeance;
    private String descripestion;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Nullable
    private Date datefin;
private String checkd="no" ;
    @Nullable
private String classColor ;

    public String getClassColor() {
        return classColor;
    }

    public void setClassColor(String classColor) {
        this.classColor = classColor;
    }

    public String getCheckd() {
        return checkd;
    }

    public void setCheckd(String checkd) {
        this.checkd = checkd;
    }

    public Todo() {
    }

    public Todo(String label, String status, Date dateDebut, Date echeance, String descripestion, Date datefin) {
        this.label = label;
        this.status = status;
        this.dateDebut = dateDebut;
        this.echeance = echeance;
        this.descripestion = descripestion;
        this.datefin = datefin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getEcheance() {
        return echeance;
    }

    public void setEcheance(Date echeance) {
        this.echeance = echeance;
    }

    public String getDescripestion() {
        return descripestion;
    }

    public void setDescripestion(String descripestion) {
        this.descripestion = descripestion;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
