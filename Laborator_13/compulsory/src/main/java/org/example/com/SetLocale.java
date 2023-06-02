package org.example.com;

import java.util.Locale;

public class SetLocale {
    public static void set(String langTag) {
        Locale.setDefault(Locale.forLanguageTag(langTag));
    }
}