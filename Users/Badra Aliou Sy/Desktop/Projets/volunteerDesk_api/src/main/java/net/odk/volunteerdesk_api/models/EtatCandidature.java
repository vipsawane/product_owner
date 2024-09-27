package net.odk.volunteerdesk_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class EtatCandidature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtatCandidature;

    private String libelleEtatCandidature;
}
