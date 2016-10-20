package by.epam.kinorating.constant;

/**
 * Created by Диана и Глеб on 28.08.2016.
 */
public class Pattern {
    public static final String PATTERN_NAME = "(\\A[A-Z]?[a-z]{1,15}\\z)|(\\A[А-Я]?[а-я]{1,15}\\z)";
    public static final String PATTERN_SURNAME = "(\\A[A-Z]?[a-z]{1,15}\\z)|(\\A[А-Я]?[а-я]{1,15}\\z)";
    public static final String PATTERN_EMAIL = "\\A[a-z0-9\\.]{3,25}@[a-z\\.]{3,10}\\.{1}[a-z]{2,5}\\z";
    public static final String PATTERN_PASSWORD = "\\A[a-zA-Z0-9_\\*\\!\\^]{6,15}\\z";
}
