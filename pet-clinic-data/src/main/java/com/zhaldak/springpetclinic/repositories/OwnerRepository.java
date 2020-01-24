package com.zhaldak.springpetclinic.repositories;

import com.zhaldak.springpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    public Owner findByLastName(String lastName);
}
