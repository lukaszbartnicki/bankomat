package com.codeforce.firstboot.repositories;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<PersonEntity, Long> {

    PersonEntity findByName(String name);

    PersonEntity findByAccountCardNumber(Long cardNumber);
}
