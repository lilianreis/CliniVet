package br.ueg.progwebi.clinivet.controller;

import br.ueg.progwebi.clinivet.dto.PetDTO;
import br.ueg.progwebi.clinivet.model.Pet;
import br.ueg.progwebi.clinivet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService petService;

    @PostMapping
    public ResponseEntity<Pet> create(@RequestBody PetDTO petDTO) {
         Pet newPet = petDTOToModel(petDTO);
         return ResponseEntity.ok(petService.create(newPet));
    }

    private static Pet petDTOToModel(PetDTO pet) {
        return Pet.builder()
                .name(pet.getName())
                .tutor(pet.getTutor())
                .species(pet.getSpecies())
                .breed(pet.getBreed())
                .birthDate(pet.getBirthDate())
                .isNeutered(pet.isNeutered())
                .build();
    }
}
