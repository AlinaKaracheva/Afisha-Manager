package ru.netology.repository;

import ru.netology.domain.FilmItem;

public class FilmRepository {
    private FilmItem[] films = new FilmItem[0];

    public FilmItem[] findAll() {
        return films;
    }

    public void save(FilmItem film) {
        int length = films.length + 1;
        FilmItem[] tmp = new FilmItem[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int index = tmp.length - 1;
        tmp[index] = film;
        films = tmp;
    }

    public FilmItem findById(int id) {
        for (FilmItem filmItem : films) {
            if (filmItem.getId() == id) {
                return filmItem;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = films.length - 1;
        FilmItem[] tmp = new FilmItem[length];
        int index = 0;
        for (FilmItem filmItem : films) {
            if (filmItem.getId() != id) {
                tmp[index] = filmItem;
                index++;
            }
        }
        films = tmp;
    }

    public void removeAll() {
        films = new FilmItem[0];
    }
}
