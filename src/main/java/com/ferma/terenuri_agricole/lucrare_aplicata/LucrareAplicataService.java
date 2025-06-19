package com.ferma.terenuri_agricole.lucrare_aplicata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LucrareAplicataService {

    private final LucrareAplicataRepository repository;

    @Autowired
    public LucrareAplicataService(LucrareAplicataRepository repository) {
        this.repository = repository;
    }

    public List<LucrareAplicata> getAll() {
        return repository.findAll();
    }

    public Optional<LucrareAplicata> getById(Long id) {
        return repository.findById(id);
    }

    public LucrareAplicata add(LucrareAplicata lucrareAplicata) {
        return repository.save(lucrareAplicata);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public LucrareAplicata update(Long id, LucrareAplicata data) {
        LucrareAplicata existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lucrare aplicată nu a fost găsită"));

        existing.setDataAplicare(data.getDataAplicare());
        existing.setAnAgricol(data.getAnAgricol());
        existing.setDescriere(data.getDescriere());
        existing.setLucrare(data.getLucrare());
        existing.setTeren(data.getTeren());
        existing.setUser(data.getUser());

        return repository.save(existing);
    }
    public List<AplicareInfo> getAplicariByTerenAndAn(Long terenId, int anAgricol) {
        return repository.findAplicariByTerenAndAn(terenId, anAgricol);
    }
}
