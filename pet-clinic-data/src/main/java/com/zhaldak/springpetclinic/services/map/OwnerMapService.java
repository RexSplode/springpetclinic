package com.zhaldak.springpetclinic.services.map;

import com.zhaldak.springpetclinic.model.Owner;
import com.zhaldak.springpetclinic.model.Pet;
import com.zhaldak.springpetclinic.model.PetType;
import com.zhaldak.springpetclinic.services.OwnerService;
import com.zhaldak.springpetclinic.services.PetService;
import com.zhaldak.springpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.function.Consumer;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }


    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {

        if(owner != null) {
            if(owner.getPets() != null) {
               owner.getPets().forEach(savePetIfNecessary());
            }
            return super.save(owner);

        } else return null;
    }

    private Consumer<Pet> savePetIfNecessary() {
        return pet -> {
            Pet petWithSavedType = savePetTypeIfNecessary(pet);
            if(pet.getId() == null) {
                petService.save(petWithSavedType);
            }
        };
    }

    private Pet savePetTypeIfNecessary(Pet pet) {
        PetType type = pet.getPetType();
        if(type == null) {
            throw new RuntimeException("Pet type cannot be null");
        } else {
            if(type.getId() == null) {
                PetType savedPetType = petTypeService.save(type);
                pet.setPetType(savedPetType);
            }
        }
        return pet;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner type) {
        super.delete(type);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
