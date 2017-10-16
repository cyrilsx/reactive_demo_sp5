package ch.collen.reactive.ReactiveDemo5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by cyril on 15/10/17.
 */
@RestController
@RequestMapping("movies")
public class RestMovieService {

    private final FluxMovieService fluxMovieService;

    @Autowired
    public RestMovieService(FluxMovieService fluxMovieService) {
        this.fluxMovieService = fluxMovieService;
    }

    @GetMapping(value = "{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MovieEvent> events(@PathVariable("id") String id) {
        //TODO
    }

    @GetMapping
    public Flux<Movie> all() {
        return fluxMovieService.all();
    }

    @GetMapping("{id}")
    public Mono<Movie> byId(@PathVariable("id") String id) {
        return fluxMovieService.findById(id);
    }

}
