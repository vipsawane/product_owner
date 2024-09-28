package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.DetailsEvenement;
import net.odk.volunteerdesk_api.repositories.DetailsEvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailsEvenementService {

    @Autowired
    private DetailsEvenementRepository detailsEvenementRepository;

    public DetailsEvenement save(DetailsEvenement detailsEvenement) {
        return detailsEvenementRepository.save(detailsEvenement);
    }

    public DetailsEvenement update(DetailsEvenement d , Long id){

        DetailsEvenement de = detailsEvenementRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun détails trouvé"));
        de.setDateDebutEvenement(d.getDateDebutEvenement());
        de.setDateFinEvenement(d.getDateFinEvenement());
        de.setLieuEvenement(d.getLieuEvenement());
        de.setNbrCandidat(d.getNbrCandidat());
        de.setNbrParticipant(d.getNbrParticipant());
    
        return detailsEvenementRepository.save(de);
    }

    public DetailsEvenement active(Long id) throws Exception{
        DetailsEvenement de = detailsEvenementRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun détails trouvé"));

        try {
        de.setParticipation(true);
        } catch (Exception e) {
            throw new Exception("Erreur lors de l'activation " + e.getMessage());
        }
        return detailsEvenementRepository.save(de);
    }

    public DetailsEvenement desactive(Long id) throws Exception{
        DetailsEvenement de = detailsEvenementRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun détails trouvé"));

        try {
        de.setParticipation(false);
        } catch (Exception e) {
            throw new Exception("Erreur lors de la desactivation " + e.getMessage());
        }
        return detailsEvenementRepository.save(de);
    }


    public List<DetailsEvenement> findAll(){
        return detailsEvenementRepository.findAll();
    }

    public DetailsEvenement findById(Long id) {
        DetailsEvenement d = detailsEvenementRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun détails trouvé"));
        return d;
    }

    public void deleteById(Long id) {
        detailsEvenementRepository.deleteById(id);
    }

}
