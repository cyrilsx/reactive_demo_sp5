package ch.collen.reactive.ReactiveDemo5;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class ReactiveDemo5Application {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveDemo5Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(MovieRepository movieRepository) {
        return args -> movieRepository.deleteAll()
                .subscribe(null, null, () ->
                        movieRepository.insert(
                                Stream.of("Il etait une fois", "Bob l'eponge", "Ca fuite dans le titanic")
                                        .map(s -> new Movie(UUID.randomUUID().toString(), s))
                                        .collect(Collectors.toList())
                        ).subscribe(System.out::println));
    }

    @Bean
    public RouterFunction<?> routes(FluxMovieService service) {
        return RouterFunctions.route(
                RequestPredicates.GET("/movies"), req -> req.bodyToFlux(Movie.class)) //FIXME to finish
        )
    }

}
