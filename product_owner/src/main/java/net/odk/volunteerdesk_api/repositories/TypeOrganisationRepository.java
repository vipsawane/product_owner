package net.odk.volunteerdesk_api.repositories;

import net.odk.volunteerdesk_api.models.TypeOrganisation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOrganisationRepository extends JpaRepository<TypeOrganisation, Long> {
}
