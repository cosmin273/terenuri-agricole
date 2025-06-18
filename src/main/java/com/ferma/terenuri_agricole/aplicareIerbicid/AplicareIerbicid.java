package com.ferma.terenuri_agricole.aplicareIerbicid;

import com.ferma.terenuri_agricole.ierbicid.Ierbicid;
import com.ferma.terenuri_agricole.lucrare_aplicata.LucrareAplicata;
import jakarta.persistence.*;

@Entity
@Table(name = "aplicareierbicid")
public class AplicareIerbicid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aplicare_ierbicid")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_lucrare_aplicata", nullable = false)
    private LucrareAplicata lucrareAplicata;

    @ManyToOne
    @JoinColumn(name = "ierbicid_id_ierbicid", nullable = false)
    private Ierbicid ierbicid;

    private String doza;

    public AplicareIerbicid() {
    }

    public AplicareIerbicid(LucrareAplicata lucrareAplicata, Ierbicid ierbicid, String doza) {
        this.lucrareAplicata = lucrareAplicata;
        this.ierbicid = ierbicid;
        this.doza = doza;
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

    public Ierbicid getIerbicid() {
        return ierbicid;
    }

    public void setIerbicid(Ierbicid ierbicid) {
        this.ierbicid = ierbicid;
    }

    public String getDoza() {
        return doza;
    }

    public void setDoza(String doza) {
        this.doza = doza;
    }
}
