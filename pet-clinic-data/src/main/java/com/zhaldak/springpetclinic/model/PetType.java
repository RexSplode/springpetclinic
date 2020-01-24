package com.zhaldak.springpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "pet_type")
public class PetType extends BaseEntity{

    @Column(name = "name")
    private String name;

}
