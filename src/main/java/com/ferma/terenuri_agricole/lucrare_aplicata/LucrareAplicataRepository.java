package com.ferma.terenuri_agricole.lucrare_aplicata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LucrareAplicataRepository extends JpaRepository<LucrareAplicata,Long> {
    @Query("""
      SELECT COALESCE(
        SUM(l.consum_mediu * la.teren.suprafata / 10000.0),
        0
      )
      FROM LucrareAplicata la
      JOIN la.lucrare l
      WHERE la.anAgricol = :anAgricol
    """)
    double getTotalMotorinaByAn(@Param("anAgricol") int anAgricol);
}
