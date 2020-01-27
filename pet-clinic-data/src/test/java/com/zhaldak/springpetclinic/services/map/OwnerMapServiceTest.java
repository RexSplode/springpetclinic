package com.zhaldak.springpetclinic.services.map;


import com.zhaldak.springpetclinic.model.Owner;

import lombok.val;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class OwnerMapServiceTest {
    OwnerMapService ownerMapService;


    @BeforeEach
    public void setUp() throws Exception {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().city("Kyiv").build());
    }

    @Test
    public void findById() {
    }

    @Test
    public void save() {
    }

    @Test
    public void findAll() {
        val set = ownerMapService.findAll();
        assertEquals(1, set.size());
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void findByLastName() {
    }
}
