package ch.collen.reactive.ReactiveDemo5;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 *
 * @author COC
 * @since 12.10.2017
 */
public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {

}
