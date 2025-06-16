package com.ferma.terenuri_agricole.aplicareIerbicid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aplicari-ierbicid")
public class AplicareIerbicidController {

    private final AplicareIerbicidService service;

    @Autowired
    public AplicareIerbicidController(AplicareIerbicidService service) {
        this.service = service;
    }

    @GetMapping
    public List<AplicareIerbicid> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AplicareIerbicid> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AplicareIerbicid create(@RequestBody AplicareIerbicid aplicare) {
        return service.add(aplicare);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AplicareIerbicid> update(@PathVariable Long id, @RequestBody AplicareIerbicid aplicare) {
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
