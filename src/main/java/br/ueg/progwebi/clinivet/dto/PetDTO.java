package br.ueg.progwebi.clinivet.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PetDTO {
    private String name;
    private String tutor;
    private String breed = "SRD";
    private String species;
    private LocalDate birthDate;
    private boolean isNeutered;
    private String gender;
}
