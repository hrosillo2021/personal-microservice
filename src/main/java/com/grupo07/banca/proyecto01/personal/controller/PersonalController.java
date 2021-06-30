package com.grupo07.banca.proyecto01.personal.controller;

import com.grupo07.banca.proyecto01.personal.domain.Personal;
import com.grupo07.banca.proyecto01.personal.service.PersonalService;
import com.grupo07.banca.proyecto01.personal.service.impl.PersonalServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RefreshScope
@Controller
@CrossOrigin("*")
@RequestMapping(path = "/personal")
@Slf4j
public class PersonalController {

    @Value("${config.test}")
    private String configTest;

    @Autowired
    PersonalService personalService;

    @GetMapping(value = "/findAllPersonal")
    public @ResponseBody
    Flux<Personal> getPersonal() {
        log.debug("test->" + configTest);
        return personalService.findAllPersona();
    }

    @PostMapping(value = "/postPersonal")
    public @ResponseBody
    Mono<Personal> postPersonal(@RequestBody Personal personal) {
        return personalService.savePersonal(personal);
    }

    @GetMapping(value = "/getPersonalSutmostes/{sex}/{age}")
    public @ResponseBody
    Flux<Personal> getPersonalSutmostes(@PathVariable String sex, @PathVariable Integer age) {
        return personalService.findUsingQuery(sex,age);
    }

    @PutMapping(value = "/putPersonalByDni")
    public @ResponseBody
    Mono<Personal> updatePersonalsByDni(@RequestBody Personal personal) {
        return personalService.updatePersonalsByDni(personal);
    }

    @DeleteMapping(value = "/deletePersonal")
    public Mono<Void> deletePersonals(@RequestBody Personal Personal){
        return  personalService.deletePersonal(Personal);
    }
}