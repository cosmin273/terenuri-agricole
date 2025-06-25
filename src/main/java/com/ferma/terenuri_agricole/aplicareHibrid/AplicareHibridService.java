package com.ferma.terenuri_agricole.aplicareHibrid;

import com.ferma.terenuri_agricole.hibrid.Hibrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AplicareHibridService {

    private final AplicareHibridRepository repository;

    @Autowired
    public AplicareHibridService(AplicareHibridRepository repository) {
        this.repository = repository;
    }

    public List<AplicareHibrid> getAll() {
        return repository.findAll();
    }

    public Optional<AplicareHibrid> getById(Long id) {
        return repository.findById(id);
    }

    public AplicareHibrid add(AplicareHibrid aplicare) {
        return repository.save(aplicare);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public AplicareHibrid update(Long id, AplicareHibrid updated) {
        AplicareHibrid existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aplicarea hibridului nu a fost găsită"));

        existing.setLucrareAplicata(updated.getLucrareAplicata());
        existing.setHibrid(updated.getHibrid());
        existing.setCantitate(updated.getCantitate());

        return repository.save(existing);
    }
    public Optional<AplicareHibrid> getByLucrareAplicataId(Long lucrareId) {
        return repository.findByLucrareAplicataId(lucrareId);
    }


    /*public Optional<String> getTipSamantaByAplicareId(Long aplicareId) {
        return repository.findTipSamantaByAplicareId(aplicareId);
    }*/

}
