package com.ferma.terenuri_agricole.parcela;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/teren")
public class TerenController {
    private  final TerenService terenService;

    public TerenController(TerenService terenService) {
        this.terenService = terenService;
    }

    @GetMapping
    public List<Teren> getTerenuri(){
        return terenService.getTerenuri();
    }
}
