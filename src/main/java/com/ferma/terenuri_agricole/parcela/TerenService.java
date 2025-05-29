package com.ferma.terenuri_agricole.parcela;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TerenService {
    private final TerenRepository terenRepository;

    @Autowired
    public TerenService(TerenRepository terenRepository) {
        this.terenRepository = terenRepository;
    }

    public List<Teren> getTerenuri(){
        return terenRepository.findAll();
    }

    public void addNewTeren(Teren teren) {
        Optional<Teren> terenByDenumire= terenRepository.findTerenByDenumire(teren.getDenumire());
        if(terenByDenumire.isPresent()){
            throw new IllegalStateException("denumire taken");
        }
        terenRepository.save(teren);
        System.out.println(teren);
    }

    public void deleteTeren(Long teren_id) {
        boolean exists = terenRepository.existsById(teren_id);
        if(!exists){
            throw new IllegalStateException("teren with id "+ teren_id + " does not exist");
        }
        terenRepository.deleteById(teren_id);
    }
    @Transactional
    public void updateTeren(Long terenId, String denumire, String numeProprietar) {
        Teren teren=terenRepository.findById(terenId).orElseThrow(()->new IllegalStateException("teren with "+ terenId + " does not exist"));
        if(denumire!=null && !denumire.isEmpty() && !Objects.equals(teren.getDenumire(),denumire)){
            teren.setDenumire(denumire);
        }
        if(numeProprietar!=null && !numeProprietar.isEmpty() && !Objects.equals(teren.getNume_proprietar(),numeProprietar)){
            teren.setNume_proprietar(numeProprietar);
        }
    }
}
