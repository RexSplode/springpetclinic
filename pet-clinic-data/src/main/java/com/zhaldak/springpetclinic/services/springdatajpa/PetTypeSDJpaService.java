package com.zhaldak.springpetclinic.services.springdatajpa;

import com.zhaldak.springpetclinic.model.PetType;
import com.zhaldak.springpetclinic.repositories.PetTypeRepository;
import com.zhaldak.springpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {
    private final PetTypeRepository repository;

    public PetTypeSDJpaService(PetTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public PetType findById(Long aLong) {
        return repository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType type) {
        return repository.save(type);
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> types = new HashSet<>();
        repository.findAll().forEach(types::add);
        return types;
    }

    @Override
    public void delete(PetType type) {
        repository.delete(type);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
