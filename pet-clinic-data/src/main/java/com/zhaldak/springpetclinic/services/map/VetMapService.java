package com.zhaldak.springpetclinic.services.map;

import com.zhaldak.springpetclinic.model.Speciality;
import com.zhaldak.springpetclinic.model.Vet;
import com.zhaldak.springpetclinic.services.SpecialityService;
import com.zhaldak.springpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
        vet.getSpecialities().forEach(
                speciality -> {
                    if(speciality.getId() == 0) {
                        Speciality saved = specialityService.save(speciality);
                        speciality.setId(saved.getId());
                    }
                }
        );
        return super.save(vet);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet type) {
        super.delete(type);
    }

    @Override
    public Vet findByLastName(String lastName) {
        return null;
    }
}
