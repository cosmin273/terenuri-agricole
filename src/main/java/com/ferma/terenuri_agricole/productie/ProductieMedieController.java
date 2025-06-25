package com.ferma.terenuri_agricole.productie;

import com.ferma.terenuri_agricole.hibrid.Hibrid;
import com.ferma.terenuri_agricole.hibrid.HibridRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productie-medie")
public class ProductieMedieController {
    @Autowired
    private ProductieMedieService service;
    @Autowired
    private HibridRepository hibridRepository;
    @GetMapping("/an/{an}")
    public List<ProductieMedie> listByAn(@PathVariable int an) {
        return service.getByAnAgricol(an);
    }
    @PostMapping
    public ProductieMedie upsert(@RequestBody ProductieMedie pm) {

        Long hibridId = pm.getHibrid().getId();
        Hibrid hib = hibridRepository.findById(hibridId)
                .orElseThrow(() -> new RuntimeException("Hibrid nu există: " + hibridId));


        pm.setHibrid(hib);


        return service.addOrUpdate(pm);
    }
}

