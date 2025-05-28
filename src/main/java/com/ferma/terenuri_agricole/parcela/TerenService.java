package com.ferma.terenuri_agricole.parcela;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        System.out.println(teren);
    }
}
