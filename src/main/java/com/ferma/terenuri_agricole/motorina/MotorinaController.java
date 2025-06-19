package com.ferma.terenuri_agricole.motorina;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/motorina")
public class MotorinaController {
    private final MotorinaService service;
    public MotorinaController(MotorinaService service) {
        this.service = service;
    }

    @GetMapping("/{an}")
    public Map<String,Object> getConsum(@PathVariable int an) {
        double total = service.getTotalMotorina(an);
        return Map.of("anAgricol", an, "consumTotal", total);
    }
}

