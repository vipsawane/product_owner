package net.odk.volunteerdesk_api.controllers;

import net.odk.volunteerdesk_api.models.Sanction;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import net.odk.volunteerdesk_api.services.SanctionService;

@RestController
@RequestMapping("/sanction")
public class SanctionController {
    @Autowired
    SanctionService cService;

    @PostMapping("/addSanction")
    @Operation(summary="Création de Sanction")
    public ResponseEntity<Sanction> createSanction(@RequestBody Sanction sanction) {
        System.out.println(sanction.toString());
        return new ResponseEntity<>(cService.save(sanction) , HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @Operation(summary="Modification")
    public ResponseEntity<Sanction> updateSanction(@PathVariable Long id, @RequestBody Sanction sanction) {
        return new ResponseEntity<>(cService.update(sanction, id), HttpStatus.OK);
    }

    @GetMapping("/getAllSanction")
    @Operation(summary="Liste de tout les Sanction")
    public ResponseEntity<List<Sanction>> getAll(){
        return new ResponseEntity<>(cService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getById")
    @Operation(summary=" lire une Sanction")
    public ResponseEntity<Sanction> getAllById(@PathVariable Long idSanction){
        return new ResponseEntity<>(cService.findById(idSanction), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSanction(@PathVariable("id") Long id) {
        cService.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK); 
    }
   
}
