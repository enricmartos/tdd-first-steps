package org.emartos.moviestore;

import org.emartos.moviestore.model.Movie;

import java.util.LinkedList;
import java.util.List;

public class MovieStore {
    LinkedList<Movie> movies = new LinkedList<>();

    public void add(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> findByPartialTitle(String partialTitle) {
        Predicate predicate = new Predicate() {
            public boolean matches(Movie movie) {
                return movie.title().toUpperCase().contains(partialTitle.toUpperCase());
            }
        };
        return findBy(predicate);
    }

    public List<Movie> findByDirector(String partialTitle) {
        Predicate predicate = new Predicate() {
            public boolean matches(Movie movie) {
                return movie.director().equals(partialTitle);
            }
        };
        return findBy(predicate);
    }

    public List<Movie> findByReleaseYear(int from, int to) {
        Predicate predicate = new Predicate() {
            public boolean matches(Movie movie) {
                return movie.releaseYear() > from && movie.releaseYear() < to;
            }
        };
        return findBy(predicate);

    }

    private List<Movie> findBy(Predicate predicate) {
        LinkedList<Movie> result = new LinkedList<>();
        for (Movie movie : movies) {
            if (predicate.matches(movie)) {
                result.add(movie);
            }
        }

        return result;
    }

    interface Predicate {
        boolean matches(Movie movie);
    }
}
