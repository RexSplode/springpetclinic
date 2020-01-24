package com.zhaldak.springpetclinic.services;

import com.zhaldak.springpetclinic.model.Vet;

import java.util.Set;

public interface VetService extends CrudService<Vet, Long> {
    Vet findByLastName(String lastName);
}
