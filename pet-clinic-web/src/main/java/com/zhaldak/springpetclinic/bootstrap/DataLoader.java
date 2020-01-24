package com.zhaldak.springpetclinic.bootstrap;

import com.zhaldak.springpetclinic.model.*;
import com.zhaldak.springpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType("dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType("cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Jackson");
        owner1.setAddress("123 whereisIt");
        owner1.setCity("Kyiv");
        owner1.setPhoneNumber("14345435");

        Pet doggo = new Pet();
        doggo.setName("Scruppy");
        doggo.setPetType(savedDogType);
        doggo.setOwner(owner1);
        owner1.getPets().add(doggo);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Sam");
        owner2.setLastName("Smith");
        owner1.setAddress("123 here");
        owner1.setCity("Kyiv");
        owner1.setPhoneNumber("865646654");

        Pet anotherDoggo = new Pet();
        anotherDoggo.setName("Fluffy");
        anotherDoggo.setPetType(savedDogType);
        anotherDoggo.setOwner(owner2);
        owner2.getPets().add(anotherDoggo);

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Vet vet1 = new Vet();
        vet1.setFirstName("John");
        vet1.setLastName("Goodenough");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Amanda");
        vet2.setLastName("Morrison");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded vets...");

        Visit oneVisit = new Visit();
        oneVisit.setPet(doggo);
        oneVisit.setDate(LocalDate.now());
        oneVisit.setDescription("Checkup procedure");
        visitService.save(oneVisit);
    }
}
