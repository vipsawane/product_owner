package net.odk.volunteerdesk_api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPublication;

    @Column(nullable = true)
    private String imagePublication;

    @Column(nullable = true)
    private String contenuPublication;
    
    @Column(nullable = true)
    private String datePublication;

    @Column(nullable = false)
    private Integer like;

    @OneToMany(mappedBy= "publication")
    @JsonIgnore
    private List<Commentaire> Commentaire;
}
