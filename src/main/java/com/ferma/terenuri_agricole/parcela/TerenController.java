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
    @DeleteMapping(path = "{terenId}")
    public void deleteTeren(@PathVariable("terenId") Long id_teren){
        terenService.deleteTeren(id_teren);
    }
    @PutMapping(path = "{terenId}")
    public void updateTeren(@PathVariable("terenId") Long terenId,
                            @RequestParam(required = false) String denumire,
                            @RequestParam(required = false)String numeProprietar){
                        terenService.updateTeren(terenId,denumire,numeProprietar);
    }

}
