package net.odk.volunteerdesk_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import org.hibernate.mapping.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity @NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Like {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLike;

    @Column(nullable = true)
    private Integer nbrLike;

    // @OneToMany(mappedBy = "like")
    // @JsonIgnore
    // private List<User> user;
}
