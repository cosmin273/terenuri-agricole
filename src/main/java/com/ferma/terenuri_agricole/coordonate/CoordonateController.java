package com.ferma.terenuri_agricole.coordonate;

import com.ferma.terenuri_agricole.parcela.TerenRepository;
import com.ferma.terenuri_agricole.parcela.TerenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/coordonate")
public class CoordonateController {
    private final CoordonateService coordonateService;

    @Autowired
    public CoordonateController(CoordonateService coordonateService,TerenService terenService) {

        this.coordonateService = coordonateService;
    }
    @GetMapping
    public List<Coordonate> getCoorodonate(){
        return coordonateService.getCoordonate();
    }
    @PostMapping
    public void registerNewCoordonata(@RequestBody Coordonate coordonate){
        coordonateService.addNewCoordonata(coordonate);
    }
    @DeleteMapping("/{teren_idTeren}")
    public ResponseEntity<String> deleteCoordonateByIdTeren(@PathVariable Long teren_idTeren){
        coordonateService.deleteCoordonateByTeren_IdTeren(teren_idTeren);
        return ResponseEntity.ok("Coordinatele terenului cu id-ul "+teren_idTeren+" au fost sterse.");
    }

}
