package net.odk.volunteerdesk_api.services;

import java.time.LocalDateTime;

import net.odk.volunteerdesk_api.models.Commentaire;
import net.odk.volunteerdesk_api.repositories.CommentaireRepository;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommentaireService {

    @Autowired
    private CommentaireRepository cRepository;

    public Commentaire save(Commentaire c) {

        String pattern = "yyyy-MM-dd HH:mm";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = now.format(formatter);
        c.setDateCommentaire(formattedDateTime);
        return cRepository.save(c);
    }

    public Commentaire update(Commentaire c, Long id ){
        Commentaire co =  cRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun commentaire trouvé"));

        co.setContenuCommentaire(c.getContenuCommentaire());
        return cRepository.save(co);
    }

    public List<Commentaire> findAll(){ 
        return cRepository.findAll();
    }

    public List<Commentaire> findByPublication(Long id){
        List<Commentaire> c = cRepository.findByPublication_idPublication(id);
        
        if(c.isEmpty())
            throw new IllegalStateException("Aucun commenatire trouvée");
        
        c.sort(Comparator.comparing(Commentaire::getDateCommentaire).reversed());
        return c;
    }

    public Commentaire findById(Long id) {
        Commentaire c =  cRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun commentaire trouvé"));
        return c;
    }

    public void deleteById(Long id) {
        cRepository.deleteById(id);
    }

}
