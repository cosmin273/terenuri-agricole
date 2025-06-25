package com.ferma.terenuri_agricole.parcela;

import com.ferma.terenuri_agricole.productie.Productie;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="teren")
public class Teren {
    @Column(name = "id_teren")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTeren;
    private String denumire;
    private double suprafata;
    private double perimetru;
    private String nume_proprietar;
    private String zona;
    @OneToMany(mappedBy = "teren",
            cascade = CascadeType.ALL,orphanRemoval = true)
    List<Productie> productii = new ArrayList<>();

    public Teren() {
    }

    public Teren(long idTeren, String denumire, double suprafata,
                 double perimetru, String nume_proprietar, String zona) {
        this.idTeren = idTeren;
        this.denumire = denumire;
        this.suprafata = suprafata;
        this.perimetru = perimetru;
        this.nume_proprietar = nume_proprietar;
        this.zona = zona;
    }

    public Teren(String denumire, double suprafata, double perimetru,
                 String nume_proprietar, String zona) {
        this.denumire = denumire;
        this.suprafata = suprafata;
        this.perimetru = perimetru;
        this.nume_proprietar = nume_proprietar;
        this.zona = zona;
    }

    public long getIdTeren() {
        return idTeren;
    }

    public void setIdTeren(long idTeren) {
        this.idTeren = idTeren;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public double getSuprafata() {
        return suprafata;
    }

    public void setSuprafata(double suprafata) {
        this.suprafata = suprafata;
    }

    public double getPerimetru() {
        return perimetru;
    }

    public void setPerimetru(double perimetru) {
        this.perimetru = perimetru;
    }

    public String getNume_proprietar() {
        return nume_proprietar;
    }

    public void setNume_proprietar(String nume_proprietar) {
        this.nume_proprietar = nume_proprietar;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    @Override
    public String toString() {
        return "Teren{" +
                "id_teren=" + idTeren +
                ", denumire='" + denumire + '\'' +
                ", suprafata=" + suprafata +
                ", perimetru=" + perimetru +
                ", nume_proprietar='" + nume_proprietar + '\'' +
                ", zona='" + zona + '\'' +
                '}';
    }
}
