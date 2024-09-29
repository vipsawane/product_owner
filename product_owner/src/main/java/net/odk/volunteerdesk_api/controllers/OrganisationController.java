package net.odk.volunteerdesk_api.controllers;

import org.springframework.web.bind.annotation.*;

import net.odk.volunteerdesk_api.models.Organisation;
import net.odk.volunteerdesk_api.services.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.v3.oas.annotations.Operation;
import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/organisation")
public class OrganisationController {

    @Autowired
    OrganisationService cService;

    @PostMapping("/addOrganisation")
    @Operation(summary="Création de Organisation")
    public ResponseEntity<Organisation> createOrganisation(@RequestBody Organisation organisation) {
        System.out.println(organisation.toString());
        return new ResponseEntity<>(cService.save(organisation) , HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @Operation(summary="Modification")
    public ResponseEntity<Organisation> updateOrganisation(@PathVariable Long id, @RequestBody Organisation organisation) {
        return new ResponseEntity<>(cService.update(organisation, id), HttpStatus.OK);
    }

    @GetMapping("/getAllOrganisation")
    @Operation(summary="Liste de tout les Organisations")
    public ResponseEntity<List<Organisation>> getAll(){
        return new ResponseEntity<>(cService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getAllById")
    @Operation(summary="lire une Organisation")
    public ResponseEntity<Organisation> getAllById(@PathVariable Long idOrganisation){
        return new ResponseEntity<>(cService.findById(idOrganisation), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrganisation(@PathVariable("id") Long id) {
        cService.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK); 
    }

}
