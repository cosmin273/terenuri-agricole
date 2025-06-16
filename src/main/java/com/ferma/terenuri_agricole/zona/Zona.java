package com.ferma.terenuri_agricole.zona;

import jakarta.persistence.*;

@Entity
public class Zona {
    @Id
    @GeneratedValue
    @Column(name = "id_zona")
    private Long id;
    private String nume;
    private String tip_sol;

    public Zona() {
    }

    public Zona(String nume, String tip_sol) {
        this.nume = nume;
        this.tip_sol = tip_sol;
    }

    public Zona(Long id, String nume, String tip_sol) {
        this.id = id;
        this.nume = nume;
        this.tip_sol = tip_sol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getTip_sol() {
        return tip_sol;
    }

    public void setTip_sol(String tip_sol) {
        this.tip_sol = tip_sol;
    }
}
