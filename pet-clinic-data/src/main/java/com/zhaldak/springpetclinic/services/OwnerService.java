package com.zhaldak.springpetclinic.services;

import com.zhaldak.springpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

   Owner findByLastName(String lastName);

}
