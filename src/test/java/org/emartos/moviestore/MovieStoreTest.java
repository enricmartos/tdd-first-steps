package org.emartos.moviestore;

import org.emartos.moviestore.model.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class MovieStoreTest {

    private Movie harryPotter = new Movie("Harry Potter", "Rowling", 2000);
    private Movie startWars = new Movie("Star Wars", "Shwimmer", 1999);
    private Movie startTrek = new Movie("STAR Trek", "Shwimmer", 2002);
    private Movie shawsank = new Movie("Shawsank Redemption", "Bob", 2001);
    private Movie takeThat = new Movie("Take that", "Shwimmer", 2010);

    MovieStore movieStore = new MovieStore();

    @Before
    public void setUp() {
        movieStore.add(shawsank);
        movieStore.add(harryPotter);
        movieStore.add(startWars);
        movieStore.add(startTrek);
        movieStore.add(takeThat);
    }

    @Test
    public void returnsNoResultsWhenNoTitlesPartiallyMatchSearch() {
        MovieStore movieStore = new MovieStore();

        List<Movie> results = movieStore.findByPartialTitle("abc");

        assertThat(results.size(), is(0));
    }

    @Test
    public void findsMoviesWhenTitlesArePartiallyMatchedCaseInsensitive() {
        List<Movie> results = movieStore.findByPartialTitle("tar");

        assertThat(results.size(), is(2));
        assertThat(results, containsInAnyOrder(startWars, startTrek));
    }

    @Test
    public void findsMoviesWhenDirectorExactlyMatches() {
        List<Movie> results = movieStore.findByDirector("Shwimmer");

        assertThat(results.size(), is(3));
        assertThat(results, containsInAnyOrder(startWars, startTrek, takeThat));
    }

    @Test
    public void findsMoviesWhenReleaseYearIsBetweenTwoValues() {
        List<Movie> results = movieStore.findByReleaseYear(1999, 2002);

        assertThat(results.size(), is(2));
        assertThat(results, containsInAnyOrder(harryPotter, shawsank));
    }


}