package com.zhaldak.springpetclinic.repositories;

import com.zhaldak.springpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {

    public Vet findByLastName(String lastName);
}
