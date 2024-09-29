package net.odk.volunteerdesk_api.controllers;

import net.odk.volunteerdesk_api.models.Notification;
import net.odk.volunteerdesk_api.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    NotificationService cService;

    @PostMapping("/addNotification")
    @Operation(summary="Création de Notification")
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        System.out.println(notification.toString());
        return new ResponseEntity<>(cService.save(notification) , HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @Operation(summary="Modification")
    public ResponseEntity<Notification> updateNotification(@PathVariable Long id, @RequestBody Notification notification) {
        return new ResponseEntity<>(cService.update(notification, id), HttpStatus.OK);
    }

    @GetMapping("/getAllNotification")
    @Operation(summary="Liste de tout le sNotification")
    public ResponseEntity<List<Notification>> getAll(){
        return new ResponseEntity<>(cService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getAllById")
    @Operation(summary="lire une Notification")
    public ResponseEntity<Notification> getAllById(@PathVariable Long idNotification){
        return new ResponseEntity<>(cService.findById(idNotification), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable("id") Long id) {
        cService.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK); 
    }


}
