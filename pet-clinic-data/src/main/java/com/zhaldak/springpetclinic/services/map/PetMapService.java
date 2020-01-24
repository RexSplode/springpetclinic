package com.zhaldak.springpetclinic.services.map;

import com.zhaldak.springpetclinic.model.Pet;
import com.zhaldak.springpetclinic.services.CrudService;
import com.zhaldak.springpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet type) {
        return super.save(type);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet type) {
        super.delete(type);
    }
}
