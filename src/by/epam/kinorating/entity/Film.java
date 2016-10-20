package by.epam.kinorating.entity;


/**
 * Created by Диана и Глеб on 06.08.2016.
 */
public class Film {
    private long filmId;
    private String title;
    private int year;
    private int duration;
    private String details;
    private String trailer;
    private String director;
    private String actor;
    private Country country;
    private Genre genre;

    public Film() {
    }

    public Film(long countryId, long genreId, String title, int year, int duration, String details, String director, String actor, String trailer) {
        this.country = new Country(countryId);
        this.genre = new Genre(genreId);
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.details = details;
        this.director = director;
        this.actor = actor;
        this.trailer = trailer;
    }

    public Film(long filmID, String title, int year, Genre genre, int duration, Country country, String director, String actor, String details, String trailer) {
        this.filmId = filmID;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.duration = duration;
        this.country = country;
        this.director = director;
        this.actor = actor;
        this.details = details;
        this.trailer = trailer;
    }


    public long getFilmId() {
        return filmId;
    }

    public void setFilmId(long filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
