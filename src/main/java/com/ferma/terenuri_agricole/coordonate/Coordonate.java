package com.ferma.terenuri_agricole.coordonate;

import com.ferma.terenuri_agricole.parcela.Teren;
import jakarta.persistence.*;

@Entity
public class Coordonate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double lat;
    private double lon;
    @ManyToOne
    @JoinColumn(name = "teren_id",nullable = false)
    private Teren teren;

    public Coordonate() {
    }

    public Coordonate(double lat, double lon, Teren teren) {
        this.lat = lat;
        this.lon = lon;
        this.teren = teren;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public Teren getTeren() {
        return teren;
    }

    public void setTeren(Teren teren) {
        this.teren = teren;
    }
}
