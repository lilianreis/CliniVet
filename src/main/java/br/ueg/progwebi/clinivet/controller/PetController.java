package br.ueg.progwebi.clinivet.controller;

import br.ueg.progwebi.clinivet.dto.PetDTO;
import br.ueg.progwebi.clinivet.model.Pet;
import br.ueg.progwebi.clinivet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService petService;

    private static Pet petDTOToModel(PetDTO pet) {
        return Pet.builder()
                .name(pet.getName())
                .tutor(pet.getTutor())
                .species(pet.getSpecies())
                .breed(pet.getBreed())
                .birthDate(pet.getBirthDate())
                .isNeutered(pet.isNeutered())
                .gender(pet.getGender())
                .build();
    }

    @PostMapping
    public ResponseEntity<Pet> create(@RequestBody PetDTO petDTO) {
         Pet newPet = petDTOToModel(petDTO);
         return ResponseEntity.ok(petService.create(newPet));
    }

    @PutMapping(path = "/{id}")
    public Pet update(
            @PathVariable Long id,
            @RequestBody PetDTO petDTO) {
        Pet petUpdate = petDTOToModel(petDTO);
        return petService.update(id, petUpdate);
    }

    @GetMapping(path = "/{id}")
    public Pet getById(@PathVariable Long id) {
        return this.petService.getbyId(id);
    }

    @GetMapping
    public List<Pet> getAll() {
        return this.petService.getAll();
    }


}
