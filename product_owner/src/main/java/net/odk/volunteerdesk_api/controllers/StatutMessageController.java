package net.odk.volunteerdesk_api.controllers;


import net.odk.volunteerdesk_api.models.StatutMessage;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import net.odk.volunteerdesk_api.services.StatutMessageService;

@RestController
@RequestMapping("/statutMessage")
public class StatutMessageController {

    @Autowired
    StatutMessageService cService;

    @PostMapping("/addStatutMessage")
    @Operation(summary="Création de StatutMessage")
    public ResponseEntity<StatutMessage> createStatutMessage(@RequestBody StatutMessage statutMessage) {
        System.out.println(statutMessage.toString());
        return new ResponseEntity<>(cService.save(statutMessage) , HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @Operation(summary="Modification")
    public ResponseEntity<StatutMessage> updateStatutMessage(@PathVariable Long id, @RequestBody StatutMessage statutMessage) {
        return new ResponseEntity<>(cService.update(statutMessage, id), HttpStatus.OK);
    }

    @GetMapping("/getAllStatutMessage")
    @Operation(summary="Liste de tout les StatutMessage")
    public ResponseEntity<List<StatutMessage>> getAll(){
        return new ResponseEntity<>(cService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStatutMessage(@PathVariable("id") Long id) {
        cService.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK); 
    }

}
