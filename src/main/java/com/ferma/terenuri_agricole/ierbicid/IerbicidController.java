package com.ferma.terenuri_agricole.ierbicid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ierbicide")
public class IerbicidController {

    private final IerbicidService ierbicidService;

    @Autowired
    public IerbicidController(IerbicidService ierbicidService) {
        this.ierbicidService = ierbicidService;
    }

    @GetMapping
    public List<Ierbicid> getAll() {
        return ierbicidService.getAllIerbicide();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ierbicid> getById(@PathVariable Long id) {
        return ierbicidService.getIerbicidById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ierbicid create(@RequestBody Ierbicid ierbicid) {
        return ierbicidService.addIerbicid(ierbicid);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ierbicid> update(@PathVariable Long id, @RequestBody Ierbicid ierbicid) {
        try {
            return ResponseEntity.ok(ierbicidService.updateIerbicid(id, ierbicid));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ierbicidService.deleteIerbicid(id);
        return ResponseEntity.noContent().build();
    }
}
