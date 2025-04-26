package br.ueg.progwebi.clinivet.repository;

import br.ueg.progwebi.clinivet.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {

    Optional<Pet> findByName(String name);

    Optional<Pet> findById(Long id);
}
