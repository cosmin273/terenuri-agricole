package com.ferma.terenuri_agricole.productie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productii")
public class ProductieController {

    private final ProductieService productieService;

    @Autowired
    public ProductieController(ProductieService productieService) {
        this.productieService = productieService;
    }

    @GetMapping
    public List<Productie> getAll() {
        return productieService.getAllProductii();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Productie> getById(@PathVariable Long id) {
        return productieService.getProductieById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/an/{anAgricol}")
    public List<Productie> getByAnAgricol(@PathVariable int anAgricol) {
        return productieService.getByAnAgricol(anAgricol);
    }

    @PostMapping
    public Productie create(@RequestBody Productie productie) {
        return productieService.addProductie(productie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Productie> update(@PathVariable Long id, @RequestBody Productie productie) {
        try {
            return ResponseEntity.ok(productieService.updateProductie(id, productie));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productieService.deleteProductie(id);
        return ResponseEntity.noContent().build();
    }
}
