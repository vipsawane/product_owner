package net.odk.volunteerdesk_api.repositories;

import net.odk.volunteerdesk_api.models.Evenement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Long> {
}
