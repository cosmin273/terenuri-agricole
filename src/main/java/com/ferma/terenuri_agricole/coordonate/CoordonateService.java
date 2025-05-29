package com.ferma.terenuri_agricole.coordonate;

import com.ferma.terenuri_agricole.parcela.Teren;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoordonateService {
    private final CoordonateRepository coordonateRepository;

    @Autowired
    public CoordonateService(CoordonateRepository coordonateRepository) {
        this.coordonateRepository = coordonateRepository;
    }


    public List<Coordonate> getCoordonate() {
        return coordonateRepository.findAll();
    }

    public void addNewCoordonata(Coordonate coordonate) {
        Optional<Coordonate> coordonateExistente=coordonateRepository.findByALl(
                coordonate.getLat(),
                coordonate.getLon(),
                coordonate.getTeren().getId_teren()
        );
        if(coordonateExistente.isPresent()){
            throw new IllegalStateException("Coordonatele deja exista pentru acest teren.");
        }
        coordonateRepository.save(coordonate);
    }
}
