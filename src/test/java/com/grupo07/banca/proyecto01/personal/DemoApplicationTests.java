package com.grupo07.banca.proyecto01.personal;

import reactor.core.publisher.Flux;

//@SpringBootTest
class DemoApplicationTests {

	//@Test
	void contextLoads() {

		Flux<String> fluxColors = Flux.just("red", "green", "blue");
		fluxColors.subscribe(System.out::println);
		fluxColors.log().subscribe(System.out::println);
	}
}
