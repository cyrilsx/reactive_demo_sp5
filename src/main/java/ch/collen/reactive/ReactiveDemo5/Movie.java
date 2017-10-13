package ch.collen.reactive.ReactiveDemo5;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

/**
 * @author COC
 * @since 12.10.2017
 */
@Document
public class Movie {

    @Id
    private String id;

    private String movieName;

    public Movie(String id, String movieName) {
        this.id = id;
        this.movieName = movieName;
    }

    public Movie() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movieName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Movie other = (Movie) obj;
        return Objects.equals(this.id, other.id)
                && Objects.equals(this.movieName, other.movieName);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", movieName='" + movieName + '\'' +
                '}';
    }
}
