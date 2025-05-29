package com.ferma.terenuri_agricole.coordonate;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoordonateRepository extends JpaRepository<Coordonate,Long> {
    Optional<Coordonate> findByALl(double lat, double lon, long idTeren);
}
