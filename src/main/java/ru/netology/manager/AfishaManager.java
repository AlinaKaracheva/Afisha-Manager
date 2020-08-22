package ru.netology.manager;

public class AfishaManager {

    private FilmItem[] films = new FilmItem[0];
    private int defaultAfishaLength = 10;
    private int customAfishaLength;

    public AfishaManager() {
    }

    public AfishaManager(int customAfishaLength) {
        this.customAfishaLength = customAfishaLength;
    }

    public void addFilm(FilmItem film) {
        int length = films.length + 1;
        FilmItem[] tmp = new FilmItem[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int index = tmp.length - 1;
        tmp[index] = film;
        films = tmp;
    }

    public FilmItem[] getFilms() {
        int length = films.length;

        if (customAfishaLength <= 0) {
            if (defaultAfishaLength < films.length) {
                length = defaultAfishaLength;
            }
        } else {
            if (customAfishaLength < films.length) {
                length = customAfishaLength;
            }
        }

        FilmItem[] result = new FilmItem[length];

        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }
}
