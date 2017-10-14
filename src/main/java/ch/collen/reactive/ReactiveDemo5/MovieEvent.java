package ch.collen.reactive.ReactiveDemo5;

import java.time.LocalDateTime;

/**
 * Created by cyril on 14/10/17.
 */
public class MovieEvent {

    private Movie movie;
    private LocalDateTime when;
    private String user;

    public MovieEvent(Movie movie, LocalDateTime when, String user) {
        this.movie = movie;
        this.when = when;
        this.user = user;
    }

    public MovieEvent() {
    }


    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime getWhen() {
        return when;
    }

    public void setWhen(LocalDateTime when) {
        this.when = when;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
