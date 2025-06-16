package com.ferma.terenuri_agricole.lucrare_aplicata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LucrareAplicataRepository extends JpaRepository<LucrareAplicata,Long> {
}
