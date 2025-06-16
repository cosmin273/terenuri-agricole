package com.ferma.terenuri_agricole.hibrid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hibrizi")
public class HibridController {

    private final HibridService hibridService;

    @Autowired
    public HibridController(HibridService hibridService) {
        this.hibridService = hibridService;
    }

    @GetMapping
    public List<Hibrid> getAllHibrizi() {
        return hibridService.getAllHibrizi();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hibrid> getHibridById(@PathVariable Long id) {
        return hibridService.getHibridById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Hibrid createHibrid(@RequestBody Hibrid hibrid) {
        return hibridService.addHibrid(hibrid);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hibrid> updateHibrid(@PathVariable Long id, @RequestBody Hibrid hibrid) {
        try {
            return ResponseEntity.ok(hibridService.updateHibrid(id, hibrid));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHibrid(@PathVariable Long id) {
        hibridService.deleteHibrid(id);
        return ResponseEntity.noContent().build();
    }
}
