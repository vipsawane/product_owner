package net.odk.volunteerdesk_api.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(nullable = false)
    private String nomUser;

    @Column(nullable = false)
    private String prenomUser;

    @Column(nullable = true)
    private String photoUser;
    
    @Column(nullable = true)
    private String description;

    @Column(nullable = false)
    private String motDePasse;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String telephone;

    @Column(nullable = true)
    private String dateNaissance;

    @Column(nullable = true)
    private String photoProfil;

    @Column(nullable = true)
    private String numCarteIdentification;

    @Column(nullable = true)
    private String competences;

    @Column(nullable = true)
    private String anneeExperiences;

    @Column(nullable = true)
    private Integer nbrSuspension;

    @ManyToOne
    @JoinColumn( name = "idRole")
    private List<Role> role;
}
