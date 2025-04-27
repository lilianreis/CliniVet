package br.ueg.progwebi.clinivet.service;

import br.ueg.progwebi.clinivet.model.Pet;

import java.util.List;

public interface PetService {

    Pet create(Pet pet);
    Pet update(Long id, Pet pet);
    Pet getbyId(Long id);
    List<Pet> getAll();
    Pet delete(Long id);
}
