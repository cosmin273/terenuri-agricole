package com.ferma.terenuri_agricole.ierbicid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IerbicidService {

    private final IerbicidRepository ierbicidRepository;

    @Autowired
    public IerbicidService(IerbicidRepository ierbicidRepository) {
        this.ierbicidRepository = ierbicidRepository;
    }

    public List<Ierbicid> getAllIerbicide() {
        return ierbicidRepository.findAll();
    }

    public Optional<Ierbicid> getIerbicidById(Long id) {
        return ierbicidRepository.findById(id);
    }

    public Ierbicid addIerbicid(Ierbicid ierbicid) {
        return ierbicidRepository.save(ierbicid);
    }

    public void deleteIerbicid(Long id) {
        ierbicidRepository.deleteById(id);
    }

    public Ierbicid updateIerbicid(Long id, Ierbicid updated) {
        Ierbicid existing = ierbicidRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ierbicidul nu a fost găsit"));

        existing.setProducator(updated.getProducator());
        existing.setNume(updated.getNume());
        existing.setTip(updated.getTip());
        existing.setDescriere(updated.getDescriere());

        return ierbicidRepository.save(existing);
    }
}
