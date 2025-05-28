package com.ferma.terenuri_agricole.parcela;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerenRepository extends JpaRepository<Teren,Long> {
}
