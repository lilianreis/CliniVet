package br.ueg.progwebi.clinivet.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Pet {
    public static final String SEQUENCE_NAME="PET_ID_GENERATE" ;
    @Id
    @SequenceGenerator(
            name=SEQUENCE_NAME,
            sequenceName = SEQUENCE_NAME+"_bd",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = SEQUENCE_NAME
    )
    private Long id;

    @Column(length = 200, nullable = false, unique = true )
    private String name;

    @Column(length = 200, nullable = false)
    private String tutor;

    @Column(length = 200, nullable = false)
    private String breed;

    @Column(length = 200, nullable = false)
    private String species;

    private LocalDate birthDate;

    private boolean isNeutered;
}
