package net.odk.volunteerdesk_api.controllers;


import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import net.odk.volunteerdesk_api.models.Ressource;
import net.odk.volunteerdesk_api.services.RessourceService;

@RestController
@RequestMapping("/ressource")
public class RessourceController {
    @Autowired
    RessourceService cService;
 
     @PostMapping("/addRessource")
     @Operation(summary = "création de Ressource")
     public ResponseEntity<Ressource> create(
             @Valid @RequestParam("ressource") String eventString,
             @RequestParam(value = "image", required = false) MultipartFile imageFile)
             throws Exception {
                 Ressource ev = new Ressource();
                 try {
                     ev = new JsonMapper().readValue(eventString, Ressource.class);
                 } catch (JsonProcessingException e) {
                     throw new Exception(e.getMessage());
                 }
         
                 Ressource saved = cService.creerRessource(ev, imageFile);
                 System.out.println("Ressource controller :" + saved);
 
                 return new ResponseEntity<>(saved, HttpStatus.CREATED);
             }
 
     @PutMapping("/update/{id}")
     @Operation(summary="Modification")
     public ResponseEntity<Ressource> updateEvent(
             @Valid @RequestParam("ressource") String eventString,
             @PathVariable Long id,
             @RequestParam(value = "image", required = false) MultipartFile imageFile)
             throws Exception {
                 Ressource ev = new Ressource();
                 try {
                     ev = new JsonMapper().readValue(eventString, Ressource.class);
                 } catch (JsonProcessingException e) {
                     throw new Exception(e.getMessage());
                 }
         
                 Ressource saved = cService.update(ev, id, imageFile);
                 System.out.println("Ressource controller :" + saved);
 
                 return new ResponseEntity<>(saved, HttpStatus.CREATED);
             }
 
     @GetMapping("/getAllRessource")
     @Operation(summary="Liste de tout les Ressource")
     public ResponseEntity<List<Ressource>> getAll(){
         return new ResponseEntity<>(cService.findAll(), HttpStatus.OK);
     }
 
     @GetMapping("/getAllById")
     @Operation(summary="lire un Ressource")
     public ResponseEntity<Ressource> getAllById(@PathVariable Long idRessource){
         return new ResponseEntity<>(cService.findById(idRessource), HttpStatus.OK);
     }
 
     @DeleteMapping("/delete/{id}")
     public ResponseEntity<Void> deleteRessource(@PathVariable("id") Long id) {
         cService.deleteById(id);
         return  new ResponseEntity<>(HttpStatus.OK); 
     }
 }
 