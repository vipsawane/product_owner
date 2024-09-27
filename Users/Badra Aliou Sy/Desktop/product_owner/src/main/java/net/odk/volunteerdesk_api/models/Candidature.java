package net.odk.volunteerdesk_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Candidature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCandidature;

    private String libelleCandidature;
    private String etatCandidature;
    private Date dateCandidature;
}
