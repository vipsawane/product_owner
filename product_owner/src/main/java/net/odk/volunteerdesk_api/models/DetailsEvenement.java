package net.odk.volunteerdesk_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class DetailsEvenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetailsEvenement;

    @Column(nullable = false)
    private String lieuEvenement;

    @Column(nullable = false)
    private String dateDebutEvenement;

    @Column(nullable = false)
    private String dateFinEvenement;

    @Column(nullable = false)
    private Boolean participation;

    @Column(nullable = true)
    private Integer nbrCandidat;
    
    @Column(nullable = true)
    private Integer nbrParticipant;

    @OneToOne
    private Evenement evenement;
}
