package net.odk.volunteerdesk_api.repositories;

import net.odk.volunteerdesk_api.models.Ressource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RessourceRepository extends JpaRepository<Ressource, Long> {
}
