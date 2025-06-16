package com.ferma.terenuri_agricole.coordonate;

import com.ferma.terenuri_agricole.parcela.Teren;
import com.ferma.terenuri_agricole.parcela.TerenRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoordonateService {
    private final CoordonateRepository coordonateRepository;
    private final TerenRepository terenRepository;

    @Autowired
    public CoordonateService(CoordonateRepository coordonateRepository, TerenRepository terenRepository) {
        this.coordonateRepository = coordonateRepository;
        this.terenRepository = terenRepository;
    }


    public List<Coordonate> getCoordonate() {
        return coordonateRepository.findAll();
    }
    public List<Coordonate> getCoordonateByTeren_IdTeren(Long teren_IdTeren){
        if(!terenRepository.existsById(teren_IdTeren)){
            throw new IllegalStateException("Terenul cu id "+teren_IdTeren+" nu exista");
        }
        return coordonateRepository.findAllByTeren_IdTeren(teren_IdTeren);
    }
    public void addNewCoordonata(Coordonate coordonate) {
        Long terenId = coordonate.getTeren().getIdTeren();

        // Încarci terenul din DB (dacă nu există, arunci excepție)
        Teren teren = terenRepository.findById(terenId)
                .orElseThrow(() -> new IllegalStateException("Terenul cu id " + terenId + " nu există."));

        // Setezi terenul persistent pe coordonată
        coordonate.setTeren(teren);

        Optional<Coordonate> coordonateExistente = coordonateRepository.findByLatAndLonAndTeren_IdTeren(
                coordonate.getLat(),
                coordonate.getLon(),
                terenId
        );

        if (coordonateExistente.isPresent()) {
            throw new IllegalStateException("Coordonatele deja există pentru acest teren.");
        }

        coordonateRepository.save(coordonate);
    }

@Transactional
    public void deleteCoordonateByTeren_IdTeren(Long idTeren) {
        coordonateRepository.deleteByTeren_IdTeren(idTeren);
    }
}
