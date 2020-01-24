package com.zhaldak.springpetclinic.repositories;

import com.zhaldak.springpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {


}
