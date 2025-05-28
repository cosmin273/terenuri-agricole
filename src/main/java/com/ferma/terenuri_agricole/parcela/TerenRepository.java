package com.ferma.terenuri_agricole.parcela;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TerenRepository extends JpaRepository<Teren,Long> {

    //@Query("SELECT * FROM trenuri_agricole.teren t WHERE t.denumire=?")
    Optional<Teren> findTerenByDenumire(String denumire);
}
