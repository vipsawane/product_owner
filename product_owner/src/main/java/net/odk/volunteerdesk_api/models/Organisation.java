package net.odk.volunteerdesk_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Organisation{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrganisation;

    @Column(nullable = false)
    private String numeroIdentification;

    @Column(nullable = false)
    private String raisonSocial;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String siege;

    @Column(nullable = false)
    private String domaineActivite;
    
    @Column(nullable = true)
    private String dateCreation;

    @Column(nullable = true)
    private Integer nbrSanction;



}
