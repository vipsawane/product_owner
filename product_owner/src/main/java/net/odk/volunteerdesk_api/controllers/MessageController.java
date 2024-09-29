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
import net.odk.volunteerdesk_api.models.Message;
import net.odk.volunteerdesk_api.services.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService cService;
 
     @PostMapping("/addMessage")
     @Operation(summary = "création de Message")
     public ResponseEntity<Message> create(
             @Valid @RequestParam("message") String eventString,
             @RequestParam(value = "image", required = false) MultipartFile imageFile)
             throws Exception {
                 Message ev = new Message();
                 try {
                     ev = new JsonMapper().readValue(eventString, Message.class);
                 } catch (JsonProcessingException e) {
                     throw new Exception(e.getMessage());
                 }
         
                 Message saved = cService.save(ev, imageFile);
                 System.out.println("message controller :" + saved);
 
                 return new ResponseEntity<>(saved, HttpStatus.CREATED);
             }
 
     @PutMapping("/update/{id}")
     @Operation(summary="Modification")
     public ResponseEntity<Message> updateEvent(
             @Valid @RequestParam("Message") String eventString,
             @PathVariable Long id,
             @RequestParam(value = "image", required = false) MultipartFile imageFile)
             throws Exception {
                 Message ev = new Message();
                 try {
                     ev = new JsonMapper().readValue(eventString, Message.class);
                 } catch (JsonProcessingException e) {
                     throw new Exception(e.getMessage());
                 }
         
                 Message saved = cService.update(ev, id, imageFile);
                 System.out.println("message controller :" + saved);
 
                 return new ResponseEntity<>(saved, HttpStatus.CREATED);
             }
 
     @GetMapping("/getAllMessage")
     @Operation(summary="Liste de tout les Messages")
     public ResponseEntity<List<Message>> getAll(){
         return new ResponseEntity<>(cService.findAll(), HttpStatus.OK);
     }
 
     @GetMapping("/getAllById")
     @Operation(summary="Liste d'un Message")
     public ResponseEntity<Message> getAllById(@PathVariable Long idMessage){
         return new ResponseEntity<>(cService.findById(idMessage), HttpStatus.OK);
     }
 
     @DeleteMapping("/delete/{id}")
     public ResponseEntity<Void> deleteMessage(@PathVariable("id") Long id) {
         cService.deleteById(id);
         return  new ResponseEntity<>(HttpStatus.OK); 
     }
 }
 