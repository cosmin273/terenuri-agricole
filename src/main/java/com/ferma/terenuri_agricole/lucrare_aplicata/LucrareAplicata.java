package com.ferma.terenuri_agricole.lucrare_aplicata;

import com.ferma.terenuri_agricole.lucrare.Lucrare;
import com.ferma.terenuri_agricole.parcela.Teren;
import com.ferma.terenuri_agricole.user.User;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class LucrareAplicata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lucrare_aplicata")
    private Long id;

    @Column(name = "data_aplicare", nullable = false)
    private LocalDate dataAplicare;

    @Column(name = "an_agricol", nullable = false)
    private int anAgricol;

    private String descriere;

    @ManyToOne
    @JoinColumn(name = "lucrare_id_lucrare", nullable = false)
    private Lucrare lucrare;

    @ManyToOne
    @JoinColumn(name = "teren_id_teren", nullable = false)
    private Teren teren;

    @ManyToOne
    @JoinColumn(name = "user_user_id", nullable = false)
    private User user;

    public LucrareAplicata() {
    }

    public LucrareAplicata(LocalDate dataAplicare, int anAgricol, String descriere, Lucrare lucrare, Teren teren, User user) {
        this.dataAplicare = dataAplicare;
        this.anAgricol = anAgricol;
        this.descriere = descriere;
        this.lucrare = lucrare;
        this.teren = teren;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataAplicare() {
        return dataAplicare;
    }

    public void setDataAplicare(LocalDate dataAplicare) {
        this.dataAplicare = dataAplicare;
    }

    public int getAnAgricol() {
        return anAgricol;
    }

    public void setAnAgricol(int anAgricol) {
        this.anAgricol = anAgricol;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public Lucrare getLucrare() {
        return lucrare;
    }

    public void setLucrare(Lucrare lucrare) {
        this.lucrare = lucrare;
    }

    public Teren getTeren() {
        return teren;
    }

    public void setTeren(Teren teren) {
        this.teren = teren;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
