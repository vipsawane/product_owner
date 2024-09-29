package net.odk.volunteerdesk_api.controllers;


import net.odk.volunteerdesk_api.models.TypeEvenement;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import net.odk.volunteerdesk_api.services.TypeEvenementService;

@RestController
@RequestMapping("/typeEvenement")
public class TypeEvenementController {
    
    @Autowired
    TypeEvenementService cService;

    @PostMapping("/addTypeEvenement")
    @Operation(summary="Création de TypeEvenement")
    public ResponseEntity<TypeEvenement> createTypeEvenement(@RequestBody TypeEvenement typeEvenement) {
        System.out.println(typeEvenement.toString());
        return new ResponseEntity<>(cService.save(typeEvenement) , HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @Operation(summary="Modification")
    public ResponseEntity<TypeEvenement> updateTypeEvenement(@PathVariable Long id, @RequestBody TypeEvenement typeEvenement) {
        return new ResponseEntity<>(cService.update(typeEvenement, id), HttpStatus.OK);
    }

    @GetMapping("/getAllTypeEvenement")
    @Operation(summary="Liste de tout les Types Evenement")
    public ResponseEntity<List<TypeEvenement>> getAll(){
        return new ResponseEntity<>(cService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTypeEvenement(@PathVariable("id") Long id) {
        cService.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK); 
    }
    
}
