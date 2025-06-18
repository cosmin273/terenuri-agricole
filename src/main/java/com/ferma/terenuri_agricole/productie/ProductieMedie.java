package com.ferma.terenuri_agricole.productie;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ferma.terenuri_agricole.hibrid.Hibrid;
import jakarta.persistence.*;

@Entity
@Table(name = "productie_medie",
        uniqueConstraints = @UniqueConstraint(columnNames = {"an_agricol","hibrid_id"}))
public class ProductieMedie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "an_agricol", nullable = false)
    private int anAgricol;
    @Column(name = "kg_per_ha", nullable = false)
    private double kgPerHa;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hibrid_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Hibrid hibrid;


    public ProductieMedie(int anAgricol, Hibrid hibrid, double kgPerHa) {
        this.anAgricol = anAgricol;
        this.hibrid = hibrid;
        this.kgPerHa = kgPerHa;
    }

    public ProductieMedie(Long id, int anAgricol, Hibrid hibrid, double kgPerHa) {
        this.id = id;
        this.anAgricol = anAgricol;
        this.hibrid = hibrid;
        this.kgPerHa = kgPerHa;
    }

    public Hibrid getHibrid() {
        return hibrid;
    }

    public void setHibrid(Hibrid hibrid) {
        this.hibrid = hibrid;
    }

    public ProductieMedie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAnAgricol() {
        return anAgricol;
    }

    public void setAnAgricol(int anAgricol) {
        this.anAgricol = anAgricol;
    }


    public double getKgPerHa() {
        return kgPerHa;
    }

    public void setKgPerHa(double kgPerHa) {
        this.kgPerHa = kgPerHa;
    }
}
