package by.epam.kinorating.manager;

import java.util.ResourceBundle;

/**
 * Created by Диана и Глеб on 06.08.2016.
 */
public class MessageManager {
    private static final String PATH_RUS = "message_ru_RU";
    private static final String PATH_ENG = "message_en_US";
    private static final String RUS = "ru_RU";
    private static final String ENG = "en_US";
    private static ResourceBundle bundle;

    MessageManager() {
    }

    public static String getMessage(String key, String locale) {
        switch (locale) {
            case RUS:
                bundle = ResourceBundle.getBundle(PATH_RUS);
                break;
            case ENG:
                bundle = ResourceBundle.getBundle(PATH_ENG);
                break;
        }
        return bundle.getString(key);
    }
}
