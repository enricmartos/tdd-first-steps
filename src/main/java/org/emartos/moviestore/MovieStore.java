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
        return findBy(movie -> movie.title().toUpperCase().contains(partialTitle.toUpperCase()));
    }

    public List<Movie> findByDirector(String partialTitle) {
        return findBy(movie -> movie.director().equals(partialTitle));
    }

    public List<Movie> findByReleaseYear(int from, int to) {
        return findBy(movie -> movie.releaseYear() > from && movie.releaseYear() < to);
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
