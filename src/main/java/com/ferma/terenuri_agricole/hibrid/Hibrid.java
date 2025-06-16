package com.ferma.terenuri_agricole.hibrid;

import jakarta.persistence.*;

@Entity
public class Hibrid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hibrid")
    private Long id;

    private String tip_samanta;
    private String denumire;
    private String provenienta;

    public Hibrid() {
    }

    public Hibrid(String tip_samanta, String denumire, String provenienta) {
        this.tip_samanta = tip_samanta;
        this.denumire = denumire;
        this.provenienta = provenienta;
    }

    public Hibrid(Long id, String tip_samanta, String denumire, String provenienta) {
        this.id = id;
        this.tip_samanta = tip_samanta;
        this.denumire = denumire;
        this.provenienta = provenienta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTip_samanta() {
        return tip_samanta;
    }

    public void setTip_samanta(String tip_samanta) {
        this.tip_samanta = tip_samanta;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getProvenienta() {
        return provenienta;
    }

    public void setProvenienta(String provenienta) {
        this.provenienta = provenienta;
    }
}
