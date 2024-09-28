package net.odk.volunteerdesk_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor 
@NoArgsConstructor 
@Getter 
@Setter
public class TypeOrganisation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeOrganisation;

    @Column(nullable = false)
    private  String libelleTypeOrganisation;
}
