package ch.collen.reactive.ReactiveDemo5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.security.SecureRandom;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.stream.Stream;

/**
 * Created by cyril on 14/10/17.
 */
@Service
public class FluxMovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public FluxMovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Flux<Movie> all() {
        return movieRepository.findAll();
    }

    public Mono<Movie> findById(String id) {
        return movieRepository.findById(id);
    }

    public Flux<MovieEvent> streamEvents(Movie movie) {
        return Flux.interval(Duration.ofSeconds(1))
                .zipWith(generate(movie)).map(Tuple2::getT2);
    }

    private Flux<MovieEvent> generate(Movie movie) {
        return Flux.fromStream(Stream.generate(() -> new MovieEvent(movie, LocalDateTime.now(), pickRnadomUser())));
    }

    private String pickRnadomUser() {
        String[] userName = {"Cyril", "Franck", "Bob", "JB"};
        return userName[new SecureRandom().nextInt(4)];
    }
}
