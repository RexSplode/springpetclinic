package com.zhaldak.springpetclinic.repositories;

import com.zhaldak.springpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
