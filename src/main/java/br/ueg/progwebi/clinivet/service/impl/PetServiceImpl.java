package br.ueg.progwebi.clinivet.service.impl;

import br.ueg.progwebi.clinivet.model.Pet;
import br.ueg.progwebi.clinivet.repository.PetRepository;
import br.ueg.progwebi.clinivet.service.PetService;
import br.ueg.progwebi.clinivet.service.exceptions.BusinessException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository repository;

    @Override
    public Pet create(Pet pet) {
        createValidator(pet);
        return repository.save(pet);
    }

    private void createValidator(Pet pet) {
        if(Strings.isEmpty(pet.getName())){
            throw new BusinessException("Name não pode ser nulo ou vazio");
        }

        Optional<Pet> checkExist2 = repository.findByName(pet.getName());
        if(checkExist2.isPresent()){
            throw new BusinessException("Já existe um pet com esse nome:"+ pet
                    .getName());
        }
    }
}
