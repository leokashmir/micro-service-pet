package com.petz.api.repository;

import com.petz.api.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface PetRepository extends JpaRepository<Pet, Long> {

    @Transactional
    void deleteByIdPet(Long idpet);


}
