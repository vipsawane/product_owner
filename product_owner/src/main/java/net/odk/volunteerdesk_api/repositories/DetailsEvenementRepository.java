package net.odk.volunteerdesk_api.repositories;

import net.odk.volunteerdesk_api.models.DetailsEvenement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsEvenementRepository extends JpaRepository<DetailsEvenement, Long> {

    public DetailsEvenement findByEvenement_idEvenement(Long idEvenement);
}
