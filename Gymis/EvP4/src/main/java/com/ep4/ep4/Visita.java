package com.ep4.ep4;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "visitas")
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Local", nullable = false)
    private String  local;

    @Column(name = "AffiliateDNI")
    private String AffiliateDNI;

    @Column(name = "Date")
    private LocalDate date;

    @Column(name = "Time")
    private LocalTime time;

    public Visita() {
    }

    public Visita(Long id, String local, String AffiliateDNI, LocalDate date, LocalTime time) {
        this.id = id;
        this.local = local;
        this.AffiliateDNI = AffiliateDNI;
        this.date = date;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getAffiliateDNI() {
        return AffiliateDNI;
    }

    public void setAffiliateDNI(String AffiliateDNI) {
        this.AffiliateDNI = AffiliateDNI;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}