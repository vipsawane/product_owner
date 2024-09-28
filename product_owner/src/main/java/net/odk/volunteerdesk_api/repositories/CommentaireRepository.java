package net.odk.volunteerdesk_api.repositories;

import java.util.List;

import net.odk.volunteerdesk_api.models.Commentaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

    public List<Commentaire> findByPublication_idPublication(Long id);
}
