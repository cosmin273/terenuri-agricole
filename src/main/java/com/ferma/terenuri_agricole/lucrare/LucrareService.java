package com.ferma.terenuri_agricole.lucrare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LucrareService {

    private final LucrareRepository lucrareRepository;

    @Autowired
    public LucrareService(LucrareRepository lucrareRepository) {
        this.lucrareRepository = lucrareRepository;
    }

    public List<Lucrare> getAllLucrari() {
        return lucrareRepository.findAll();
    }

    public Optional<Lucrare> getLucrareById(Long id) {
        return lucrareRepository.findById(id);
    }

    public Lucrare addLucrare(Lucrare lucrare) {
        return lucrareRepository.save(lucrare);
    }

    public void deleteLucrare(Long id) {
        lucrareRepository.deleteById(id);
    }

    public Lucrare updateLucrare(Long id, Lucrare lucrareDetails) {
        Lucrare lucrare = lucrareRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lucrare nu a fost găsită"));

        lucrare.setTip(lucrareDetails.getTip());
        lucrare.setConsum_mediu(lucrareDetails.getConsum_mediu());

        return lucrareRepository.save(lucrare);
    }
}
