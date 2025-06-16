package com.ferma.terenuri_agricole.hibrid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HibridService {

    private final HibridRepository hibridRepository;

    @Autowired
    public HibridService(HibridRepository hibridRepository) {
        this.hibridRepository = hibridRepository;
    }

    public List<Hibrid> getAllHibrizi() {
        return hibridRepository.findAll();
    }

    public Optional<Hibrid> getHibridById(Long id) {
        return hibridRepository.findById(id);
    }

    public Hibrid addHibrid(Hibrid hibrid) {
        return hibridRepository.save(hibrid);
    }

    public void deleteHibrid(Long id) {
        hibridRepository.deleteById(id);
    }

    public Hibrid updateHibrid(Long id, Hibrid hibridDetails) {
        Hibrid hibrid = hibridRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hibridul nu a fost găsit"));

        hibrid.setTip_samanta(hibridDetails.getTip_samanta());
        hibrid.setDenumire(hibridDetails.getDenumire());
        hibrid.setProvenienta(hibridDetails.getProvenienta());

        return hibridRepository.save(hibrid);
    }
}
