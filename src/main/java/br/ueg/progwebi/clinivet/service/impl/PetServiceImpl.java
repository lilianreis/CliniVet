package br.ueg.progwebi.clinivet.service.impl;

import br.ueg.progwebi.clinivet.model.Pet;
import br.ueg.progwebi.clinivet.repository.PetRepository;
import br.ueg.progwebi.clinivet.service.PetService;
import br.ueg.progwebi.clinivet.service.exceptions.BusinessException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
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

    @Override
    public Pet update(Long id, Pet pet) {
        Pet dbPet = this.getbyId(id);
        dbPet.setName(pet.getName());
        dbPet.setTutor(pet.getTutor());
        dbPet.setBreed(pet.getBreed());
        dbPet.setSpecies(pet.getSpecies());
        dbPet.setBirthDate(pet.getBirthDate());
        dbPet.setNeutered(pet.isNeutered());

        return repository.save(dbPet);
    }

    @Override
    public Pet getbyId(Long id) {
        Optional<Pet> pet = this.repository.findById(id);

        if(Boolean.FALSE.equals(pet.isPresent())){
            throw new BusinessException("Pet id: "+id+" não encontrado", 404);
        }else{
            return pet.get();
        }
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
        private static void updateValidation(Pet pet){
            if(Strings.isEmpty(pet.getName()) ||
                    Objects.isNull(pet.getId()) ||
                    pet.getId().longValue()==0
            ){
                throw new BusinessException("Information incomplete (name or ID)");
            }
        }
}
