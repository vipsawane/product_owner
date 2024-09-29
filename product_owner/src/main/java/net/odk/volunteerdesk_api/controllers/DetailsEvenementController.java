package net.odk.volunteerdesk_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import net.odk.volunteerdesk_api.models.DetailsEvenement;
import net.odk.volunteerdesk_api.services.DetailsEvenementService;
import java.util.*;

@RestController
@RequestMapping("/detailEvent")
public class DetailsEvenementController {

    @Autowired
    DetailsEvenementService cService;

    @PostMapping("/addDetailsEvenement")
    @Operation(summary="Création de DetailsEvenement")
    public ResponseEntity<DetailsEvenement> createDetailsEvenement(@RequestBody DetailsEvenement detailsEvenement) {
        return new ResponseEntity<>(cService.save(detailsEvenement) , HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @Operation(summary="Modification")
    public ResponseEntity<DetailsEvenement> updateDetailsEvenement(@PathVariable Long id, @RequestBody DetailsEvenement DetailsEvenement) {
        return new ResponseEntity<>(cService.update(DetailsEvenement, id), HttpStatus.OK);
    }

    @GetMapping("/getAllDetailsEvenement")
    @Operation(summary="Liste de tout les DetailsEvenement")
    public ResponseEntity<List<DetailsEvenement>> getAll(){
        return new ResponseEntity<>(cService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getAllById")
    @Operation(summary="Liste d'un DetailsEvenement")
    public ResponseEntity<DetailsEvenement> getAllById(@PathVariable Long idDetailsEvenement){
        return new ResponseEntity<>(cService.findById(idDetailsEvenement), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDetailsEvenement(@PathVariable("id") Long id) {
        cService.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK); 
    }
}
