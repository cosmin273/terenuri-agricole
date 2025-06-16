package com.ferma.terenuri_agricole.lucrare_aplicata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lucrari-aplicate")
public class LucrareAplicataController {

    private final LucrareAplicataService service;

    @Autowired
    public LucrareAplicataController(LucrareAplicataService service) {
        this.service = service;
    }

    @GetMapping
    public List<LucrareAplicata> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LucrareAplicata> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public LucrareAplicata create(@RequestBody LucrareAplicata lucrareAplicata) {
        return service.add(lucrareAplicata);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LucrareAplicata> update(@PathVariable Long id, @RequestBody LucrareAplicata lucrareAplicata) {
        try {
            return ResponseEntity.ok(service.update(id, lucrareAplicata));
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
