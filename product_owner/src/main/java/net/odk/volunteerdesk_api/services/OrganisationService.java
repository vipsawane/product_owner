package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.Organisation;
import net.odk.volunteerdesk_api.repositories.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganisationService {

    @Autowired
    private OrganisationRepository organisationRepository;

    public Organisation save(Organisation organisation) {
        return organisationRepository.save(organisation);
    }

    public Organisation update(Organisation or, Long id){
        Organisation o =  organisationRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune organisation trouvé"));
        
        o.setNumeroIdentification(or.getNumeroIdentification());
        o.setRaisonSocial(or.getRaisonSocial());
        o.setDescription(or.getDescription());
        o.setSiege(or.getSiege());
        o.setDomaineActivite(or.getDomaineActivite());
        o.setDateCreation(or.getDateCreation());
        o.setNbrSanction(or.getNbrSanction());

        return organisationRepository.save(o);
    }

    public List<Organisation> findAll(){
        return organisationRepository.findAll();
    }

    public Organisation findById(Long id) {
        Organisation o =  organisationRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune organisation trouvé"));
        return o;
    }

    public void deleteById(Long id) {
        organisationRepository.deleteById(id);
    }
}
