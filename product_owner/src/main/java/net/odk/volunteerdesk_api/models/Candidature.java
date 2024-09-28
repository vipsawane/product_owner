package net.odk.volunteerdesk_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Candidature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCandidature;

    @Column(nullable = true)
    private String libelleCandidature;

    @Column(nullable = true)
    private String etatCandidature;

    @Column(nullable = true)
    private String dateCandidature;
}
