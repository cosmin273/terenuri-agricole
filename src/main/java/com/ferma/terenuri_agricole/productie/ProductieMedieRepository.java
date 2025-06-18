package com.ferma.terenuri_agricole.productie;

import com.ferma.terenuri_agricole.hibrid.Hibrid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductieMedieRepository extends JpaRepository<ProductieMedie, Long> {

    List<ProductieMedie> findAllByAnAgricol(int anAgricol);

    Optional<ProductieMedie> findByAnAgricolAndHibrid_Id(int anAgricol, Long hibridId);
}
