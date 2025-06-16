package com.ferma.terenuri_agricole.ierbicid;

import jakarta.persistence.*;

@Entity
public class Ierbicid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ierbicid")
    private Long id;

    private String producator;
    private String nume;
    private String tip;
    private String descriere;

    public Ierbicid() {
    }

    public Ierbicid(String producator, String nume, String tip, String descriere) {
        this.producator = producator;
        this.nume = nume;
        this.tip = tip;
        this.descriere = descriere;
    }

    public Ierbicid(Long id, String producator, String nume, String tip, String descriere) {
        this.id = id;
        this.producator = producator;
        this.nume = nume;
        this.tip = tip;
        this.descriere = descriere;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }
}
