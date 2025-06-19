package com.ferma.terenuri_agricole.lucrare_aplicata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Query("""
        select la.dataAplicare      as dataAplicare,
               la.lucrare.tip       as numeLucrare
        from LucrareAplicata la
        where la.teren.idTeren     = :terenId
          and la.anAgricol         = :anAgricol
        order by la.dataAplicare
        """)
    List<AplicareInfo> findAplicariByTerenAndAn(
            @Param("terenId")   Long terenId,
            @Param("anAgricol") Integer anAgricol
    );
}
