package ru.netology.manager;

import ru.netology.domain.FilmItem;
import ru.netology.repository.FilmRepository;

public class AfishaManager {
    private FilmRepository repository;
    private int defaultAfishaLength = 10;
    private int customAfishaLength;

    public AfishaManager(FilmRepository repository) {
        this.repository = repository;
    }

    public AfishaManager(FilmRepository repository, int customAfishaLength) {
        this.repository = repository;
        this.customAfishaLength = customAfishaLength;
    }

    public void addFilm(FilmItem film) {
        repository.save(film);
    }

    public FilmItem[] getFilms() {
        FilmItem[] filmsFromRepo = repository.findAll();
        int length = filmsFromRepo.length;

        if (customAfishaLength <= 0) {
            if (defaultAfishaLength < filmsFromRepo.length) {
                length = defaultAfishaLength;
            }
        } else {
            if (customAfishaLength < filmsFromRepo.length) {
                length = customAfishaLength;
            }
        }

        FilmItem[] result = new FilmItem[length];
        for (int i = 0; i < result.length; i++) {
            int index = filmsFromRepo.length - i - 1;
            result[i] = filmsFromRepo[index];
        }
        return result;
    }
}
