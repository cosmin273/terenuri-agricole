package com.ferma.terenuri_agricole.lucrare;

import jakarta.persistence.*;

@Entity
public class Lucrare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lucrare")
    private Long id;
    private String tip;
    private double consum_mediu;

    public Lucrare(String tip, double consum_mediu) {
        this.tip = tip;
        this.consum_mediu = consum_mediu;
    }

    public Lucrare(Long id, String tip, double consum_mediu) {
        this.id = id;
        this.tip = tip;
        this.consum_mediu = consum_mediu;
    }

    public Lucrare() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public double getConsum_mediu() {
        return consum_mediu;
    }

    public void setConsum_mediu(double consum_mediu) {
        this.consum_mediu = consum_mediu;
    }
}
