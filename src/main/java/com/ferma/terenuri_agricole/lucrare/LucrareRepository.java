package com.ferma.terenuri_agricole.lucrare;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LucrareRepository extends JpaRepository<Lucrare,Long> {
}
