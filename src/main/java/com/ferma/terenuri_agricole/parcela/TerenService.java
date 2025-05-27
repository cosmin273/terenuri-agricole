package com.ferma.terenuri_agricole.parcela;

import java.util.List;

public class TerenService {
    public List<Teren> getTerenuri(){
        return List.of(new Teren(
                1L,
                "Teren1",
                234.9,
                123.0,
                "gheroghita",
                "Dealu fastacului"));
    }
}
