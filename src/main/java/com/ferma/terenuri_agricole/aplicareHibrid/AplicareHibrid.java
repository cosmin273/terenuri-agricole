package com.ferma.terenuri_agricole.aplicareHibrid;

import com.ferma.terenuri_agricole.hibrid.Hibrid;
import com.ferma.terenuri_agricole.lucrare_aplicata.LucrareAplicata;
import jakarta.persistence.*;

@Entity
public class AplicareHibrid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aplicare_hibrid")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_lucrare_aplicata", nullable = false)
    private LucrareAplicata lucrareAplicata;

    @ManyToOne
    @JoinColumn(name = "hibrid_id_hibrid", nullable = false)
    private Hibrid hibrid;

    private String cantitate;

    public AplicareHibrid() {
    }

    public AplicareHibrid(LucrareAplicata lucrareAplicata, Hibrid hibrid, String cantitate) {
        this.lucrareAplicata = lucrareAplicata;
        this.hibrid = hibrid;
        this.cantitate = cantitate;
    }

    public Long getId() {
        return id;
    }

    public LucrareAplicata getLucrareAplicata() {
        return lucrareAplicata;
    }

    public void setLucrareAplicata(LucrareAplicata lucrareAplicata) {
        this.lucrareAplicata = lucrareAplicata;
    }

    public Hibrid getHibrid() {
        return hibrid;
    }

    public void setHibrid(Hibrid hibrid) {
        this.hibrid = hibrid;
    }

    public String getCantitate() {
        return cantitate;
    }

    public void setCantitate(String cantitate) {
        this.cantitate = cantitate;
    }
}
