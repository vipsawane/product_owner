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
import net.odk.volunteerdesk_api.models.Publication;
import net.odk.volunteerdesk_api.services.PublicationService;

@RestController
@RequestMapping("/publication")
public class PublicationController {
    
   @Autowired
   PublicationService cService;

    @PostMapping("/addPublication")
    @Operation(summary = "création de Publication")
    public ResponseEntity<Publication> create(
            @Valid @RequestParam("publication") String eventString,
            @RequestParam(value = "image", required = false) MultipartFile imageFile)
            throws Exception {
                Publication ev = new Publication();
                try {
                    ev = new JsonMapper().readValue(eventString, Publication.class);
                } catch (JsonProcessingException e) {
                    throw new Exception(e.getMessage());
                }
        
                Publication saved = cService.save(ev, imageFile);
                System.out.println("Publication controller :" + saved);

                return new ResponseEntity<>(saved, HttpStatus.CREATED);
            }

    @PutMapping("/update/{id}")
    @Operation(summary="Modification")
    public ResponseEntity<Publication> updateEvent(
            @Valid @RequestParam("publication") String eventString,
            @PathVariable Long id,
            @RequestParam(value = "image", required = false) MultipartFile imageFile)
            throws Exception {
                Publication ev = new Publication();
                try {
                    ev = new JsonMapper().readValue(eventString, Publication.class);
                } catch (JsonProcessingException e) {
                    throw new Exception(e.getMessage());
                }
        
                Publication saved = cService.update(ev, id, imageFile);
                System.out.println("Publication controller :" + saved);

                return new ResponseEntity<>(saved, HttpStatus.CREATED);
            }

    @GetMapping("/getAllPublication")
    @Operation(summary="Liste de tout les Publication")
    public ResponseEntity<List<Publication>> getAll(){
        return new ResponseEntity<>(cService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getAllById")
    @Operation(summary="lire un Publication")
    public ResponseEntity<Publication> getAllById(@PathVariable Long idPublication){
        return new ResponseEntity<>(cService.findById(idPublication), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePublication(@PathVariable("id") Long id) {
        cService.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK); 
    }
}
