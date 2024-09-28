package net.odk.volunteerdesk_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.odk.volunteerdesk_api.models.Sanction;

@Repository
public interface SanctionRepository extends JpaRepository<Sanction, Long> {
}
