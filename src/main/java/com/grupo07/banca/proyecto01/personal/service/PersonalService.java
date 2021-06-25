package com.grupo07.banca.proyecto01.personal.service;

import com.grupo07.banca.proyecto01.personal.domain.Personal;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonalService {

    Flux<Personal> findAllPersona();

    Mono<Personal> savePersonal(Personal Personal);

    Flux<Personal> findUsingQuery(String gender, Integer age);

    Mono<Personal> updatePersonalsByDni(Personal Personal);

    Mono<Void> deletePersonal(Personal Personal);
}
