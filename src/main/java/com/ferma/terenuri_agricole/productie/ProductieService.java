package com.ferma.terenuri_agricole.productie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductieService {

    private final ProductieRepository productieRepository;

    @Autowired
    public ProductieService(ProductieRepository productieRepository) {
        this.productieRepository = productieRepository;
    }

    public List<Productie> getAllProductii() {
        return productieRepository.findAll();
    }

    public Optional<Productie> getProductieById(Long id) {
        return productieRepository.findById(id);
    }

    public Productie addProductie(Productie productie) {
        return productieRepository.save(productie);
    }

    public void deleteProductie(Long id) {
        productieRepository.deleteById(id);
    }

    public Productie updateProductie(Long id, Productie data) {
        Productie existing = productieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producția nu a fost găsită"));

        existing.setCantitate(data.getCantitate());
        existing.setDataRecoltare(data.getDataRecoltare());
        existing.setAnAgricol(data.getAnAgricol());
        existing.setTeren(data.getTeren());

        return productieRepository.save(existing);
    }
}
