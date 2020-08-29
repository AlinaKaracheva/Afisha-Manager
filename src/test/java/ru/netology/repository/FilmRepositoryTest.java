package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmItem;

import static org.junit.jupiter.api.Assertions.*;

class FilmRepositoryTest {
    FilmRepository repository = new FilmRepository();

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

    @Test
    void shouldSave() {
        repository.save(film1);
        FilmItem[] expected = new FilmItem[]{film1};
        FilmItem[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturn() {
        repository.save(film1);
        repository.save(film2);
        repository.save(film3);
        repository.save(film4);
        repository.save(film5);
        repository.save(film6);
        repository.save(film7);
        repository.save(film8);
        repository.save(film9);
        repository.save(film10);
        repository.save(film11);
        FilmItem[] expected = new FilmItem[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11};
        FilmItem[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyArray() {
        FilmItem[] expected = new FilmItem[]{};
        FilmItem[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        int idToFind = 3;
        repository.save(film1);
        repository.save(film2);
        repository.save(film3);
        repository.save(film4);
        repository.save(film5);
        repository.save(film6);
        repository.save(film7);
        repository.save(film8);
        repository.save(film9);
        repository.save(film10);
        repository.save(film11);
        repository.findById(idToFind);
        FilmItem expected = film3;
        FilmItem actual = repository.findById(idToFind);

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnNullIfNotExists() {
        int idToFind = 7;
        repository.save(film1);
        repository.save(film2);
        repository.save(film3);
        repository.save(film4);
        repository.save(film5);
        repository.findById(idToFind);
        FilmItem expected = null;
        FilmItem actual = repository.findById(idToFind);

        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveIfExists() {
        int idToRemove = 1;
        repository.save(film1);
        repository.save(film2);
        repository.save(film3);
        repository.save(film4);
        repository.save(film5);
        repository.removeById(idToRemove);
        FilmItem[] expected = new FilmItem[]{film2, film3, film4, film5};
        FilmItem[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotRemoveIfNoExists() {
        int idToRemove = 5;
        repository.save(film1);
        repository.save(film2);
        repository.save(film3);
        repository.save(film4);
        repository.removeById(idToRemove);
        FilmItem[] expected = new FilmItem[]{film1, film2, film3, film4};
        FilmItem[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {
        repository.save(film1);
        repository.save(film2);
        repository.save(film3);
        repository.save(film4);
        repository.save(film5);
        repository.removeAll();
        FilmItem[] expected = new FilmItem[]{};
        FilmItem[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }
}


