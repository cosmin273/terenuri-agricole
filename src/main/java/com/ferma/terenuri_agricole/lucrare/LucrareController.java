package com.ferma.terenuri_agricole.lucrare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lucrari")
public class LucrareController {

    private final LucrareService lucrareService;

    @Autowired
    public LucrareController(LucrareService lucrareService) {
        this.lucrareService = lucrareService;
    }

    @GetMapping
    public List<Lucrare> getAllLucrari() {
        return lucrareService.getAllLucrari();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lucrare> getLucrareById(@PathVariable Long id) {
        return lucrareService.getLucrareById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Lucrare createLucrare(@RequestBody Lucrare lucrare) {
        return lucrareService.addLucrare(lucrare);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lucrare> updateLucrare(@PathVariable Long id, @RequestBody Lucrare lucrare) {
        try {
            return ResponseEntity.ok(lucrareService.updateLucrare(id, lucrare));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLucrare(@PathVariable Long id) {
        lucrareService.deleteLucrare(id);
        return ResponseEntity.noContent().build();
    }
}
