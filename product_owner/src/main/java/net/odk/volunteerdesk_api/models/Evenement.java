package net.odk.volunteerdesk_api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvenement;

    @Column(unique = true)
    private String libelle;
    
    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String lieuEvenement;

    @Column(nullable = false)
    private String organisateur;

    @Column(nullable = true)
    private String Formateur;
    
    @Column(nullable = false)
    private String photo;

    @Column(nullable = false)
    private Integer nbrPoste;

    @ManyToOne
    @JoinColumn(name = "idTypeEvenement")
    private TypeEvenement typeEvenement;

    @OneToOne
    @JsonIgnore
    private DetailsEvenement detailsEvenement;
}
