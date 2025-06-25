package com.ferma.terenuri_agricole.parcela;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> registerNewTeren(
            @RequestBody Teren teren){
        try{
            Teren savedTeren=terenService.addNewTeren(teren);
            return ResponseEntity.ok(savedTeren);
        }catch (IllegalStateException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.
                    of("message",e.getMessage()));
        }
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
