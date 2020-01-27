package com.zhaldak.springpetclinic.services.springdatajpa;

import com.zhaldak.springpetclinic.model.Owner;
import com.zhaldak.springpetclinic.repositories.OwnerRepository;
import com.zhaldak.springpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaService ownerService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastName() {
        Owner returnOwner = new Owner();
        returnOwner.setLastName("Sam");
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner josh = ownerService.findByLastName("Sam");

        assertEquals("Sam", josh.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void findAll() {

    }

    @Test
    void delete() {
    }
}