package com.zhaldak.springpetclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "specialities")
public class Speciality extends BaseEntity {
    private String description;

   @ManyToMany(mappedBy = "specialities")
    private Set<Vet> vets;


}
