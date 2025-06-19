package com.ferma.terenuri_agricole.motorina;

import com.ferma.terenuri_agricole.lucrare_aplicata.LucrareAplicataRepository;
import org.springframework.stereotype.Service;

@Service
public class MotorinaService {
    private final LucrareAplicataRepository repo;
    public MotorinaService(LucrareAplicataRepository repo) {
        this.repo = repo;
    }
    public double getTotalMotorina(int anAgricol) {
        return repo.getTotalMotorinaByAn(anAgricol);
    }
}

