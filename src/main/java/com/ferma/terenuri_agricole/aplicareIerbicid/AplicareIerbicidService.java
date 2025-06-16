package com.ferma.terenuri_agricole.aplicareIerbicid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AplicareIerbicidService {

    private final AplicareIerbicidRepository repository;

    @Autowired
    public AplicareIerbicidService(AplicareIerbicidRepository repository) {
        this.repository = repository;
    }

    public List<AplicareIerbicid> getAll() {
        return repository.findAll();
    }

    public Optional<AplicareIerbicid> getById(Long id) {
        return repository.findById(id);
    }

    public AplicareIerbicid add(AplicareIerbicid aplicare) {
        return repository.save(aplicare);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public AplicareIerbicid update(Long id, AplicareIerbicid updated) {
        AplicareIerbicid existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aplicarea ierbicidului nu a fost găsită"));

        existing.setLucrareAplicata(updated.getLucrareAplicata());
        existing.setIerbicid(updated.getIerbicid());
        existing.setDoza(updated.getDoza());

        return repository.save(existing);
    }
}
