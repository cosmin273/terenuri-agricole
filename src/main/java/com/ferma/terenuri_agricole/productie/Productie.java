package com.ferma.terenuri_agricole.productie;

import com.ferma.terenuri_agricole.parcela.Teren;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Productie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_productie")
    private Long id;

    private double cantitate;

    @Column(name = "data_recoltare")
    private LocalDate dataRecoltare;

    @Column(name = "an_agricol")
    private int anAgricol;

    @ManyToOne
    @JoinColumn(name = "teren_id_teren", nullable = false)
    private Teren teren;

    public Productie() {
    }

    public Productie(double cantitate, LocalDate dataRecoltare, int anAgricol, Teren teren) {
        this.cantitate = cantitate;
        this.dataRecoltare = dataRecoltare;
        this.anAgricol = anAgricol;
        this.teren = teren;
    }

    public Long getId() {
        return id;
    }

    public double getCantitate() {
        return cantitate;
    }

    public void setCantitate(double cantitate) {
        this.cantitate = cantitate;
    }

    public LocalDate getDataRecoltare() {
        return dataRecoltare;
    }

    public void setDataRecoltare(LocalDate dataRecoltare) {
        this.dataRecoltare = dataRecoltare;
    }

    public int getAnAgricol() {
        return anAgricol;
    }

    public void setAnAgricol(int anAgricol) {
        this.anAgricol = anAgricol;
    }

    public Teren getTeren() {
        return teren;
    }

    public void setTeren(Teren teren) {
        this.teren = teren;
    }
}
