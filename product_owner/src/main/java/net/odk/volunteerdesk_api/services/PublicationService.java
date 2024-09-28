package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.Publication;
import net.odk.volunteerdesk_api.models.Ressource;
import net.odk.volunteerdesk_api.repositories.PublicationRepository;

import org.apache.logging.log4j.util.PropertySource.Comparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.format.DateTimeFormatter;

import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@Service
public class PublicationService {

    @Autowired
    private PublicationRepository publicationRepository;

    public Publication save(Publication publication , MultipartFile photo) throws Exception {

         //image
         if (photo != null) {
            String location = "C:\\xampp\\htdocs\\photo";
            try {
                Path rootlocation = Paths.get(location);
                if (!Files.exists(rootlocation)) {
                    Files.createDirectories(rootlocation);
                    Files.copy(photo.getInputStream(),
                            rootlocation.resolve(photo.getOriginalFilename()));
                            publication.setImagePublication("photo/"
                            + photo.getOriginalFilename());
                } else {
                    try {
                        String nom = location + "\\" + photo.getOriginalFilename();
                        Path name = Paths.get(nom);
                        if (!Files.exists(name)) {
                            Files.copy(photo.getInputStream(),
                                    rootlocation.resolve(photo.getOriginalFilename()));
                                    publication.setImagePublication("photo/"
                                    + photo.getOriginalFilename());
                        } else {
                            Files.delete(name);
                            Files.copy(photo.getInputStream(), rootlocation.resolve(photo.getOriginalFilename()));
                            publication.setImagePublication("photo/"
                                    + photo.getOriginalFilename());
                        }
                    } catch (Exception e) {
                        throw new Exception("Impossible de télécharger l\'image");
                    }
                }
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
    }

    String pattern = "yyyy-MM-dd HH:mm";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    LocalDateTime now = LocalDateTime.now();
    String formattedDateTime = now.format(formatter);
    publication.setDatePublication(formattedDateTime);

        return publicationRepository.save(publication);
    }

    public Publication update(Publication publication, Long id , MultipartFile photo) throws Exception {
        Publication p = publicationRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune publication trouvé"));
        p.setContenuPublication(publication.getContenuPublication());
        
         //image
         if (photo != null) {
            String location = "C:\\xampp\\htdocs\\photo";
            try {
                Path rootlocation = Paths.get(location);
                if (!Files.exists(rootlocation)) {
                    Files.createDirectories(rootlocation);
                    Files.copy(photo.getInputStream(),
                            rootlocation.resolve(photo.getOriginalFilename()));
                            p.setImagePublication("photo/"
                            + photo.getOriginalFilename());
                } else {
                    try {
                        String nom = location + "\\" + photo.getOriginalFilename();
                        Path name = Paths.get(nom);
                        if (!Files.exists(name)) {
                            Files.copy(photo.getInputStream(),
                                    rootlocation.resolve(photo.getOriginalFilename()));
                                    p.setImagePublication("photo/"
                                    + photo.getOriginalFilename());
                        } else {
                            Files.delete(name);
                            Files.copy(photo.getInputStream(), rootlocation.resolve(photo.getOriginalFilename()));
                            p.setImagePublication("photo/"
                                    + photo.getOriginalFilename());
                        }
                    } catch (Exception e) {
                        throw new Exception("Impossible de télécharger l\'image");
                    }
                }
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
    }

        return publicationRepository.save(p);
    }

    public List<Publication> findAll(){
        List<Publication> p = publicationRepository.findAll();

         if(p.isEmpty()){
            throw new IllegalStateException("Aucune publication trouvée");
    
        }
        // p.sort(Comparator.comparing(Publication::DatePublication).reversed());
        return p;
    }

    public Publication findById(Long id) {
        return publicationRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune publication trouvé"));
    }

     public Publication updateLike(Long id) throws Exception {
        Optional<Publication> re = publicationRepository.findById(id);
        
        if (re.isPresent()) {
            Publication r = re.get();
            Integer count = r.getLike() + 1;
            r.setLike(count);

            return publicationRepository.save(r);
        } else {
            throw new Exception("Une erreur s'est produite");
        }
    }

    public void deleteById(Long id) {
        publicationRepository.deleteById(id);
    }
}
