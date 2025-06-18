package com.ferma.terenuri_agricole.productie;

import com.ferma.terenuri_agricole.hibrid.Hibrid;
import com.ferma.terenuri_agricole.hibrid.HibridRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductieMedieService {

    @Autowired
    private ProductieMedieRepository repo;

    @Autowired
    private HibridRepository hibridRepository;

    public List<ProductieMedie> getByAnAgricol(int an) {
        return repo.findAllByAnAgricol(an);
    }

    public ProductieMedie addOrUpdate(ProductieMedie pm) {
        // Caută entitatea Hibrid
        Hibrid hib = hibridRepository.findById(pm.getHibrid().getId())
                .orElseThrow(() -> new EntityNotFoundException("Hibrid nu a fost găsit: " + pm.getHibrid().getId()));

        // Verifică dacă există deja
        Optional<ProductieMedie> existent =
                repo.findByAnAgricolAndHibrid_Id(pm.getAnAgricol(), hib.getId());

        if (existent.isPresent()) {
            ProductieMedie update = existent.get();
            update.setKgPerHa(pm.getKgPerHa());
            return repo.save(update);
        }

        // Înregistrează nou
        pm.setHibrid(hib);
        return repo.save(pm);
    }
}

