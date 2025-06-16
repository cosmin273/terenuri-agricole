package com.ferma.terenuri_agricole.coordonate;

import com.ferma.terenuri_agricole.parcela.Teren;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CoordonateRepository extends JpaRepository<Coordonate,Long> {

    Optional<Coordonate> findByLatAndLonAndTeren_IdTeren(double lat, double lon, long id_teren);
    List<Coordonate> findAllByTeren_IdTeren(Long terenId);
    void deleteByTeren_IdTeren(Long idTeren);
}
