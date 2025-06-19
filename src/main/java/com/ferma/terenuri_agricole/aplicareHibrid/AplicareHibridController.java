package com.ferma.terenuri_agricole.aplicareHibrid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/v1/aplicari-hibrid")
public class AplicareHibridController {

    private final AplicareHibridService service;

    @Autowired
    public AplicareHibridController(AplicareHibridService service) {
        this.service = service;
    }

    @GetMapping
    public List<AplicareHibrid> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AplicareHibrid> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/tip-samanta")
    public String getTipSamanta(@PathVariable Long id) {
        return (String) service.getTipSamantaByAplicareId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
        

    @PostMapping
    public AplicareHibrid create(@RequestBody AplicareHibrid aplicare) {
        return service.add(aplicare);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AplicareHibrid> update(@PathVariable Long id, @RequestBody AplicareHibrid aplicare) {
        try {
            return ResponseEntity.ok(service.update(id, aplicare));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
