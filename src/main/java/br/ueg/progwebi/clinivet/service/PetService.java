package br.ueg.progwebi.clinivet.service;

import br.ueg.progwebi.clinivet.model.Pet;

public interface PetService {

    Pet create(Pet pet);
    Pet update(Long id, Pet pet);
    Pet getbyId(Long id);
}
