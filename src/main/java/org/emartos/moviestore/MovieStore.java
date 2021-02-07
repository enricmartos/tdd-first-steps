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
        LinkedList<Movie> result = new LinkedList<>();
        for (Movie movie : movies) {
            if (movie.title().toUpperCase().contains(partialTitle.toUpperCase())) {
                result.add(movie);
            }
        }

        return result;
    }

    public List<Movie> findByDirector(String partialTitle) {
        LinkedList<Movie> result = new LinkedList<>();
        for (Movie movie : movies) {
            if (movie.director().equals(partialTitle)) {
                result.add(movie);
            }
        }

        return result;
    }

    public List<Movie> findByReleaseYear(int from, int to) {
        LinkedList<Movie> result = new LinkedList<>();
        for (Movie movie : movies) {
            if (movie.releaseYear() > from && movie.releaseYear() < to) {
                result.add(movie);
            }
        }

        return result;
    }


}
