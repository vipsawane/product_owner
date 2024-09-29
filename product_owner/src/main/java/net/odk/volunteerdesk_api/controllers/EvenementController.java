package net.odk.volunteerdesk_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import net.odk.volunteerdesk_api.models.Evenement;
import net.odk.volunteerdesk_api.services.EvenementService;

@RestController
@RequestMapping("/evenement")
public class EvenementController {

   @Autowired
   EvenementService cService;

    @PostMapping("/addEvenement")
    @Operation(summary = "création de l'evenement")
    public ResponseEntity<Evenement> create(
            @Valid @RequestParam("evenement") String eventString,
            @RequestParam(value = "image", required = false) MultipartFile imageFile)
            throws Exception {
                Evenement ev = new Evenement();
                try {
                    ev = new JsonMapper().readValue(eventString, Evenement.class);
                } catch (JsonProcessingException e) {
                    throw new Exception(e.getMessage());
                }
        
                Evenement saved = cService.save(ev, imageFile);
                System.out.println("evenement controller :" + saved);

                return new ResponseEntity<>(saved, HttpStatus.CREATED);
            }

    @PutMapping("/update/{id}")
    @Operation(summary="Modification")
    public ResponseEntity<Evenement> updateEvent(
            @Valid @RequestParam("evenement") String eventString,
            @PathVariable Long id,
            @RequestParam(value = "image", required = false) MultipartFile imageFile)
            throws Exception {
                Evenement ev = new Evenement();
                try {
                    ev = new JsonMapper().readValue(eventString, Evenement.class);
                } catch (JsonProcessingException e) {
                    throw new Exception(e.getMessage());
                }
        
                Evenement saved = cService.update(ev, id, imageFile);
                System.out.println("evenement controller :" + saved);

                return new ResponseEntity<>(saved, HttpStatus.CREATED);
            }

    @GetMapping("/getAllEvenement")
    @Operation(summary="Liste de tout lesEvenement")
    public ResponseEntity<List<Evenement>> getAll(){
        return new ResponseEntity<>(cService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getAllById")
    @Operation(summary="Liste d'un Evenement")
    public ResponseEntity<Evenement> getAllById(@PathVariable Long idEvenement){
        return new ResponseEntity<>(cService.findById(idEvenement), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEvenement(@PathVariable("id") Long id) {
        cService.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK); 
    }
}
