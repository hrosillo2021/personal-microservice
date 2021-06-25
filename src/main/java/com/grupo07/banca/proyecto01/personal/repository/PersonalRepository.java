package com.grupo07.banca.proyecto01.personal.repository;

import com.grupo07.banca.proyecto01.personal.domain.Personal;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface PersonalRepository extends ReactiveMongoRepository<Personal, String> {

    public Mono<Personal> findByDni(String dni);

    //@Query("{ 'gender': ?0, 'age' gt ?1}")
    Flux<Personal> findByGenderAndAgeGreaterThan(String gender, Integer age);

    @Query("{ 'gender' : ?0, 'age' : { '$gt' : ?1}}") //greater than=gt
    Flux<Personal> findUsingQuery(String gender, Integer age);
}
