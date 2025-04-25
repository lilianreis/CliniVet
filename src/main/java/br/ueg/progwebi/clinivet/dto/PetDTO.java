package br.ueg.progwebi.clinivet.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PetDTO {
    private String name;
    private String tutor;
    private String breed;
    private String species;
    private LocalDate birthDate;
    private boolean isNeutered;
}
