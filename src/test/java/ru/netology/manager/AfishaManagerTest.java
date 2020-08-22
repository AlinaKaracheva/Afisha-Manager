package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AfishaManagerTest {
    AfishaManager manager = new AfishaManager();

    private FilmItem film1 = new FilmItem(1, "Бладшот", "боевик", 2020);
    private FilmItem film2 = new FilmItem(2, "Вперед", "мультфильм", 2020);
    private FilmItem film3 = new FilmItem(3, "Отель Белград", "комедия", 2020);
    private FilmItem film4 = new FilmItem(4, "Джентльмены", "боевик", 2020);
    private FilmItem film5 = new FilmItem(5, "Человек-невидимка", "ужасы", 2020);
    private FilmItem film6 = new FilmItem(6, "Тролли. Мировой тур", "мультфильм", 2020);
    private FilmItem film7 = new FilmItem(7, "Номер один", "комедия", 2020);
    private FilmItem film8 = new FilmItem(8, "Калашников", "история", 2020);
    private FilmItem film9 = new FilmItem(9, "Хищные птицы", "боевик", 2020);
    private FilmItem film10 = new FilmItem(10, "Эмма", "комедия", 2020);
    private FilmItem film11 = new FilmItem(11, "Один вдох", "драма", 2020);

    @BeforeEach
    void setUp() {
        AfishaManager manager = new AfishaManager();
    }

    @Test
    void shouldGetLastTenIfTen() {
        manager.addFilm(film1);
        manager.addFilm(film2);
        manager.addFilm(film3);
        manager.addFilm(film4);
        manager.addFilm(film5);
        manager.addFilm(film6);
        manager.addFilm(film7);
        manager.addFilm(film8);
        manager.addFilm(film9);
        manager.addFilm(film10);
        FilmItem[] expected = new FilmItem[]{film10, film9, film8, film7, film6, film5, film4, film3, film2, film1};
        FilmItem[] actual = manager.getFilms();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetLastTenIfEleven() {
        manager.addFilm(film1);
        manager.addFilm(film2);
        manager.addFilm(film3);
        manager.addFilm(film4);
        manager.addFilm(film5);
        manager.addFilm(film6);
        manager.addFilm(film7);
        manager.addFilm(film8);
        manager.addFilm(film9);
        manager.addFilm(film10);
        manager.addFilm(film11);
        FilmItem[] expected = new FilmItem[]{film11, film10, film9, film8, film7, film6, film5, film4, film3, film2};
        FilmItem[] actual = manager.getFilms();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotGetFilmsIfNoFilms() {
        FilmItem[] expected = new FilmItem[]{};
        FilmItem[] actual = manager.getFilms();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetOneIfOne() {
        manager.addFilm(film1);
        FilmItem[] expected = new FilmItem[]{film1};
        FilmItem[] actual = manager.getFilms();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetLastFiveIfFive() {
        AfishaManager manager = new AfishaManager(5);
        manager.addFilm(film1);
        manager.addFilm(film2);
        manager.addFilm(film3);
        manager.addFilm(film4);
        manager.addFilm(film5);
        FilmItem[] expected = new FilmItem[]{film5, film4, film3, film2, film1};
        FilmItem[] actual = manager.getFilms();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetLastFiveIfMore() {
        AfishaManager manager = new AfishaManager(5);
        manager.addFilm(film1);
        manager.addFilm(film2);
        manager.addFilm(film3);
        manager.addFilm(film4);
        manager.addFilm(film5);
        manager.addFilm(film6);
        manager.addFilm(film7);
        manager.addFilm(film8);
        manager.addFilm(film9);
        manager.addFilm(film10);
        manager.addFilm(film11);
        FilmItem[] expected = new FilmItem[]{film11, film10, film9, film8, film7};
        FilmItem[] actual = manager.getFilms();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetTenIfDefaultIfZero() {
        AfishaManager manager = new AfishaManager(0);
        manager.addFilm(film1);
        manager.addFilm(film2);
        manager.addFilm(film3);
        manager.addFilm(film4);
        manager.addFilm(film5);
        manager.addFilm(film6);
        manager.addFilm(film7);
        manager.addFilm(film8);
        manager.addFilm(film9);
        manager.addFilm(film10);
        FilmItem[] expected = new FilmItem[]{film10, film9, film8, film7, film6, film5, film4, film3, film2, film1};
        FilmItem[] actual = manager.getFilms();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetTenIfDefaultLessZero() {
        AfishaManager manager = new AfishaManager(-3);
        manager.addFilm(film1);
        manager.addFilm(film2);
        manager.addFilm(film3);
        manager.addFilm(film4);
        manager.addFilm(film5);
        manager.addFilm(film6);
        manager.addFilm(film7);
        manager.addFilm(film8);
        manager.addFilm(film9);
        manager.addFilm(film10);
        FilmItem[] expected = new FilmItem[]{film10, film9, film8, film7, film6, film5, film4, film3, film2, film1};
        FilmItem[] actual = manager.getFilms();
        assertArrayEquals(expected, actual);
    }
}
