package com.grupo07.banca.proyecto01.personal.service.impl;

import com.grupo07.banca.proyecto01.personal.domain.Personal;
import com.grupo07.banca.proyecto01.personal.repository.PersonalRepository;
import com.grupo07.banca.proyecto01.personal.service.PersonalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class PersonalServiceImpl implements PersonalService {

    @Autowired
    PersonalRepository personalRepository;

    @Override
    public Flux<Personal> findAllPersona() {
        return personalRepository.findAll();
    }

    @Override
    public Mono<Personal> savePersonal(Personal Personal) {
        return personalRepository.save(Personal);
    }

    @Override
    public Flux<Personal> findUsingQuery(String gender, Integer age) {
        return personalRepository.findUsingQuery(gender, age);
    }

    @Override
    public Mono<Personal> updatePersonalsByDni(Personal Personal) {
        return personalRepository.findByDni(Personal.getDni()).flatMap(
                dbPersonal -> {
                    dbPersonal.setName(Personal.getName());
                    return personalRepository.save(dbPersonal);
                });
    }

    @Override
    public Mono<Void> deletePersonal(Personal Personal) {
        return personalRepository.delete(Personal);
    }

}