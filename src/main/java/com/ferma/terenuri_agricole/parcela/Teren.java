package com.ferma.terenuri_agricole.parcela;

public class Teren {
    private long id_teren;
    private String denumire;
    private double suprafata;
    private double perimetru;
    private String nume_proprietar;
    private String zona;

    public Teren() {
    }

    public Teren(long id_teren, String denumire, double suprafata, double perimetru, String nume_proprietar, String zona) {
        this.id_teren = id_teren;
        this.denumire = denumire;
        this.suprafata = suprafata;
        this.perimetru = perimetru;
        this.nume_proprietar = nume_proprietar;
        this.zona = zona;
    }

    public Teren(String denumire, double suprafata, double perimetru, String nume_proprietar, String zona) {
        this.denumire = denumire;
        this.suprafata = suprafata;
        this.perimetru = perimetru;
        this.nume_proprietar = nume_proprietar;
        this.zona = zona;
    }

    public long getId_teren() {
        return id_teren;
    }

    public void setId_teren(long id_teren) {
        this.id_teren = id_teren;
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
                "id_teren=" + id_teren +
                ", denumire='" + denumire + '\'' +
                ", suprafata=" + suprafata +
                ", perimetru=" + perimetru +
                ", nume_proprietar='" + nume_proprietar + '\'' +
                ", zona='" + zona + '\'' +
                '}';
    }
}
