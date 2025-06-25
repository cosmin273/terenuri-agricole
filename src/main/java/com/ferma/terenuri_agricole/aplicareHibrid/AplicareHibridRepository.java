package com.ferma.terenuri_agricole.aplicareHibrid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AplicareHibridRepository extends JpaRepository<AplicareHibrid,Long> {
    /*@Query("SELECT a.hibrid.tipSamanta FROM AplicareHibrid a WHERE a.id = :id")
    Optional<String> findTipSamantaByAplicareId(@Param("id") Long id);*/
    Optional<AplicareHibrid> findByLucrareAplicataId(Long lucrareAplicataId);

}
