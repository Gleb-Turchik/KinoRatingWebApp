package by.epam.kinorating.entity;

/**
 * Created by Диана и Глеб on 31.08.2016.
 */
public class Genre {
    private long genreId;
    private String genre;

    public Genre() {}

    public Genre(long genreId) {
        this.genreId = genreId;
    }

    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return genre;
    }
}
