package net.odk.volunteerdesk_api.repositories;

import net.odk.volunteerdesk_api.models.Sanction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SanctionRepository extends JpaRepository<Sanction, Long> {
}