package by.epam.kinorating.entity;

/**
 * Created by Диана и Глеб on 31.08.2016.
 */
public class Country {
    private long countryId;
    private String country;

    public Country() {}

    public Country(long countryId) {
        this.countryId = countryId;
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return country;
    }
}
