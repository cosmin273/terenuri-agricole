package com.ferma.terenuri_agricole.zona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZonaService {

    private final ZonaRepository zonaRepository;

    @Autowired
    public ZonaService(ZonaRepository zonaRepository) {
        this.zonaRepository = zonaRepository;
    }

    public List<Zona> getAllZone() {
        return zonaRepository.findAll();
    }

    public Optional<Zona> getZonaById(Long id) {
        return zonaRepository.findById(id);
    }

    public Zona addZona(Zona zona) {
        return zonaRepository.save(zona);
    }

    public void deleteZona(Long id) {
        zonaRepository.deleteById(id);
    }

    public Zona updateZona(Long id, Zona zonaDetails) {
        Zona zona = zonaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Zona nu a fost găsită"));

        zona.setNume(zonaDetails.getNume());
        zona.setTip_sol(zonaDetails.getTip_sol());

        return zonaRepository.save(zona);
    }
}
