package com.zhaldak.springpetclinic.repositories;

import com.zhaldak.springpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
