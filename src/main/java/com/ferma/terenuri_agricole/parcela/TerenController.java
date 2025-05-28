package com.ferma.terenuri_agricole.parcela;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/teren")
public class TerenController {
    private  final TerenService terenService;

    @Autowired
    public TerenController(TerenService terenService) {
        this.terenService = terenService;
    }

    @GetMapping
    public List<Teren> getTerenuri(){
        return terenService.getTerenuri();
    }

    @PostMapping
    public void registerNewTeren(
            @RequestBody Teren teren){
        terenService.addNewTeren(teren);
    }
}
