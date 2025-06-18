package com.ferma.terenuri_agricole.productie;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductieRepository extends JpaRepository<Productie,Long> {
    List<Productie> findByAnAgricol(int anAgricol);
}
