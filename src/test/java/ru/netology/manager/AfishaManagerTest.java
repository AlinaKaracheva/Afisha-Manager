package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.FilmItem;
import ru.netology.repository.FilmRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerTest {
    @Mock
    private FilmRepository repository;
    @InjectMocks
    AfishaManager manager = new AfishaManager(repository);

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
        manager = new AfishaManager(repository);
    }

    @Test
    void shouldGetLastTenIfTen() {
        FilmItem[] returned = new FilmItem[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10};
        doReturn(returned).when(repository).findAll();

        FilmItem[] expected = new FilmItem[]{film10, film9, film8, film7, film6, film5, film4, film3, film2, film1};
        FilmItem[] actual = manager.getFilms();

        assertArrayEquals(expected, actual);

        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldGetLastTenIfEleven() {
        FilmItem[] returned = new FilmItem[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11};
        doReturn(returned).when(repository).findAll();

        FilmItem[] expected = new FilmItem[]{film11, film10, film9, film8, film7, film6, film5, film4, film3, film2};
        FilmItem[] actual = manager.getFilms();

        assertArrayEquals(expected, actual);

        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldNotGetFilmsIfNoFilms() {
        FilmItem[] returned = new FilmItem[]{};
        doReturn(returned).when(repository).findAll();

        FilmItem[] expected = new FilmItem[]{};
        FilmItem[] actual = manager.getFilms();

        assertArrayEquals(expected, actual);

        verify(repository, times(1)).findAll();

    }

    @Test
    void shouldGetOneIfOne() {
        FilmItem[] returned = new FilmItem[]{film1};
        doReturn(returned).when(repository).findAll();

        FilmItem[] expected = new FilmItem[]{film1};
        FilmItem[] actual = manager.getFilms();

        assertArrayEquals(expected, actual);

        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldGetLastFiveIfFive() {
        manager = new AfishaManager(repository, 5);
        FilmItem[] returned = new FilmItem[]{film1, film2, film3, film4, film5};
        doReturn(returned).when(repository).findAll();

        FilmItem[] expected = new FilmItem[]{film5, film4, film3, film2, film1};
        FilmItem[] actual = manager.getFilms();

        assertArrayEquals(expected, actual);

        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldGetLastFiveIfMore() {
        manager = new AfishaManager(repository, 5);
        FilmItem[] returned = new FilmItem[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11};
        doReturn(returned).when(repository).findAll();

        FilmItem[] expected = new FilmItem[]{film11, film10, film9, film8, film7};
        FilmItem[] actual = manager.getFilms();

        assertArrayEquals(expected, actual);

        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldGetTenIfDefaultIfZero() {
        manager = new AfishaManager(repository, 0);
        FilmItem[] returned = new FilmItem[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10};
        doReturn(returned).when(repository).findAll();

        FilmItem[] expected = new FilmItem[]{film10, film9, film8, film7, film6, film5, film4, film3, film2, film1};
        FilmItem[] actual = manager.getFilms();

        assertArrayEquals(expected, actual);

        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldGetTenIfDefaultLessZero() {
        manager = new AfishaManager(repository, -3);
        FilmItem[] returned = new FilmItem[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10};
        doReturn(returned).when(repository).findAll();

        FilmItem[] expected = new FilmItem[]{film10, film9, film8, film7, film6, film5, film4, film3, film2, film1};
        FilmItem[] actual = manager.getFilms();

        assertArrayEquals(expected, actual);

        verify(repository, times(1)).findAll();
    }
}
