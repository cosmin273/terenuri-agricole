package com.ferma.terenuri_agricole.zona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/zone")
public class ZonaController {

    private final ZonaService zonaService;

    @Autowired
    public ZonaController(ZonaService zonaService) {
        this.zonaService = zonaService;
    }

    @GetMapping
    public List<Zona> getAllZone() {
        return zonaService.getAllZone();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zona> getZonaById(@PathVariable Long id) {
        return zonaService.getZonaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Zona createZona(@RequestBody Zona zona) {
        return zonaService.addZona(zona);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Zona> updateZona(@PathVariable Long id, @RequestBody Zona zona) {
        try {
            return ResponseEntity.ok(zonaService.updateZona(id, zona));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZona(@PathVariable Long id) {
        zonaService.deleteZona(id);
        return ResponseEntity.noContent().build();
    }
}
