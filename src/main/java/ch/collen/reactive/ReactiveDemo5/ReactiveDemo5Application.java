package ch.collen.reactive.ReactiveDemo5;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Stream;

@SpringBootApplication
public class ReactiveDemo5Application {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveDemo5Application.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {

            Mono<String> oneElement = Mono.just("test");
            oneElement.subscribe(System.out::println);
            Flux<String> flux = Flux.fromStream(Stream.of("Cyril", "Franck"));
            flux.subscribe(System.out::println);

        };
	}

}
