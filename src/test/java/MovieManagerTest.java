package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class MovieManagerTest {
    MovieManager manager = new MovieManager();
    private Movie first = new Movie(1, "Little Things", "crime", true);
    private Movie second = new Movie(2, "Palmer", "drama", true);
    private Movie third = new Movie(3, "Akira", "fantasy", true);
    private Movie fourth = new Movie(4, "The Gentlemen", "crime", true);
    private Movie fifth = new Movie(5, "Green Book", "comedy", true);
    private Movie sixth = new Movie(6, "Moana", "cartoon", false);
    private Movie seventh = new Movie(7, "Number One", "comedy", false);
    private Movie eighth = new Movie(8, "eighth", "none", false);
    private Movie ninth = new Movie(9, "ninth", "none", false);
    private Movie tenth = new Movie(10, "tenth", "none", false);

    Movie[] expected = {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

    @BeforeEach
    public void setUp(){
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
    }

    @Test
    void giveOutActualNumberMovies() {
        MovieManager manager = new MovieManager(5);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        Movie movieAdd = new Movie(5, "Green Book", "comedy", true);
        manager.addMovie(movieAdd);
        Movie[] actual = manager.getAddLastMovie();
        Movie[] expected = {new Movie(5, "Green Book", "comedy", true), fourth, third, second, first};
        assertArrayEquals(actual, expected);
    }

    @Test
    void giveOutTenMovies() {
        MovieManager manager = new MovieManager(10);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
        Movie[] actual = manager.getAddLastMovie();
        Movie[] expected = new Movie[] {tenth,ninth,eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void giveOutFifthLimitMovies() {
        MovieManager manager = new MovieManager(5);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        Movie[] actual = manager.getAddLastMovie();
        Movie[] expected = new Movie[] {fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void giveOutLimitLessListMovies() {
        MovieManager manager = new MovieManager(8);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
        Movie[] actual = manager.getAddLastMovie();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third};
        assertArrayEquals(expected, actual);
    }
}